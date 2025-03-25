# Protobuf-Based Text Messaging System

This project is developed for the "Kommunikations Systeme" module. It demonstrates a custom protocol built with Protocol Buffers for transmitting text messages.

## Overview

- **Custom Protocol:**  
  Implements a text messaging protocol using Protocol Buffers. The protocol definition is available in the `test.proto` file included in the project.

- **Server Component:**  
  A scalable server capable of handling an arbitrary number of users concurrently.

- **Client Component:**  
  A JavaFX-based application that serves as the user interface for sending and receiving messages.

- **Platform:**  
  Entirely implemented in Java.

## Features

- **Efficient Communication:**  
  Utilizes Protocol Buffers to serialize and deserialize messages efficiently.

- **Scalable Architecture:**  
  The server is designed to manage multiple users simultaneously.

- **User-Friendly Interface:**  
  The client application provides a graphical interface built with JavaFX.

- **Preconfigured Users:**  
  The database already includes the following user accounts:
  - **luke** with password **1234**
  - **toni** with password **5678**