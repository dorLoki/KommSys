package net.heydel.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPReceiver {
    Socket socket;
    InputStream inputStream;

    public TCPReceiver(Socket socket) {
        this.socket = socket;
        try {
            inputStream = socket.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String receiveMessage() {
        int length = readMessageLength();
        if (length == -1) {
            return null;
        }
        return readMessage(length);
    }

    private String readMessage(int length) {
        byte[] messageBytes = new byte[length];
        int actualLength = 0;
        while (actualLength < length) {
            int read = readChunk(messageBytes, actualLength, length - actualLength);
            if (read == -1) {
                return null;
            }
            actualLength += read;
        }
        return new String(messageBytes, StandardCharsets.UTF_8);
    }

    private int readChunk(byte[] messageBytes, int actualLength, int i) {
        try {
            return inputStream.read(messageBytes, actualLength, i);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private int readMessageLength() {
        int length = 0;
        byte b = (byte) 0x80;
        do {
            try {
                int i = inputStream.read();
                if (i == -1) {
                    return -1;
                }
                b = (byte) i;
                byte b2 = (byte) (b & 0x7F);
                length |= b2;
                length <<= 7;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while ((b & 0x80) != 0);
        length >>= 7;
        return length;
    }
}
