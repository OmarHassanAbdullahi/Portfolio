# 📨 Python Chat Application (Client-Server Model)

## 📌 Overview
This is a **real-time chat application** built using Python and `socket` programming. It follows a **client-server architecture**, allowing multiple users to join and communicate in a shared chatroom. The server manages connections, handles message broadcasting, and maintains a list of active users, while the client allows users to send and receive messages.

---

## 🚀 Features
- **Multiple Clients Support**: Handles multiple users simultaneously using **threading**.
- **User Identification**: Each client has a username.
- **Real-Time Messaging**: Messages are sent and received instantly.
- **Message Broadcasting**: Messages from one user are relayed to all other users.
- **Client Disconnection Handling**: Removes users from the active list when they leave.
- **Error Handling**: Prevents crashes due to unexpected disconnections.

---

## 🛠️ Technologies Used
- **Python** - Core language for implementing the chat application.
- **Sockets (`socket` module)** - Enables real-time communication.
- **Multithreading (`threading` module)** - Handles multiple users efficiently.

---

## 📜 Code Structure

### 1️⃣ `server.py` (Chat Server)
- Listens for **incoming connections**.
- Maintains a **dictionary of active clients**.
- **Broadcasts messages** to all connected clients.
- Removes users who leave or disconnect.

#### Key Functions:
| Function | Description |
|----------|-------------|
| `accept_connections()` | Accepts new client connections and starts a new thread for each. |
| `handle_client(client_socket)` | Handles messages sent by a specific client. |
| `broadcast_message(message, sender_socket)` | Sends a message to all clients except the sender. |
| `remove_client(client_socket)` | Removes a disconnected client from the active user list. |

---

### 2️⃣ `client.py` (Chat Client)
- Connects to the server.
- Allows the user to send messages.
- Receives and displays **real-time messages** from other users.

#### Key Functions:
| Function | Description |
|----------|-------------|
| `menu()` | Displays the chat options (Join, Exit, Leave). |
| `handle_chat(client_socket)` | Manages sending messages from the client to the server. |
| `receive_messages(client_socket)` | Listens for and displays incoming messages from the server. |
| `client_program()` | Main client logic to handle connections, user input, and disconnections. |

---

## 🎮 How It Works

### **1️⃣ Start the Server**
Run the server so it can listen for incoming connections.
```bash
python server.py
The server will display connections and manage clients.
```
### **2️⃣ Start a Client**
Run a client instance to connect to the server.

```bash
python client.py
```

### **3️⃣ Chat Commands**
```bash
| Command | Description           |
|---------|-----------------------|
| `1`     | Join the chatroom.    |
| `q`     | Leave the chat.       |
| `2`     | Exit the program.     |
```
## 📌 Example Chat Session

### **Server Output**
```plaintext
Server is running...
New connection from 127.0.0.1:54321
User Alex has joined the chat.
Received message from Alex: Hello everyone!
Received message from Alex: q
Removing user: Alex from clients
```
### **Client Output**
```plaintext
Connected to server.
1. Join the chat
q. Leave the chat
2. Exit the program
Enter your choice: 1
Enter your username: Alex
Joining the chat as Alex...
You: Hello everyone!
You: q
Leaving the chat...
Connection closed.
```
### 🔥 Future Improvements
```plaintext
Private Messaging: Allow direct messages between users.
Message Logging: Store chat history in a database or file.
User Authentication: Implement login/logout functionality.
UI Enhancement: Create a graphical user interface (GUI).
```
### 👨‍💻 Developer Notes
```plaintext
This chat application is built using socket programming in Python.
Threading is used to manage multiple users simultaneously.
The server ensures message broadcasting while maintaining an active user list.
```
### 📢 Now start chatting and enjoy real-time communication! 🚀
