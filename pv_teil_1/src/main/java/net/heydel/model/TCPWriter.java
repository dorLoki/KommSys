package net.heydel.model;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPWriter {
    private OutputStream outputStream;

    public TCPWriter(Socket socket) {
        try {
            outputStream = socket.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean write(String message) {
        try {
            byte[] messageBytes = stringToByteArray(message);
            outputStream.write(messageBytes);
            outputStream.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private byte[] stringToByteArray(String message) {
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        int length = messageBytes.length;

        // Berechnen der Anzahl der Längen-Bytes
        int numLengthBytes = 0;
        while (length > 0) {
            numLengthBytes++;
            length >>= 7; // Verschieben um 7 Bit (Bei Überlauf wird while-schleife verlassen)
        }

        byte[] result = new byte[numLengthBytes + messageBytes.length];
        length = messageBytes.length;
        for (int i = numLengthBytes - 1; i >= 0; i--) {
            result[i] = (byte) (length & 0x7F); // Die unteren 7 Bit setzen (durch UND-Verknüpfung mit 01111111 wird das
                                                // unterste Bit gesetzt)
            if (i < numLengthBytes - 1) {
                result[i] |= 0x80; // Das höchste Bit setzen (durch ODER-Verknüpfung mit 10000000 wird das höchste
                                   // Bit gesetzt)
            }
            length >>= 7;
        }

        System.arraycopy(messageBytes, 0, result, numLengthBytes, messageBytes.length); // Kopieren der Nachricht in das
                                                                                        // result-Array
        // array als bit representation

        return result;
    }
}
