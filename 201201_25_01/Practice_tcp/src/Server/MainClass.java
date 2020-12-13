package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
	
	public static void main(String[] args) {
		Socket clientSocket;
		List<Socket> list = null;
		
		try {
			ServerSocket servSocket = new ServerSocket(9000);
			
			while(true) {
				clientSocket = servSocket.accept();
				list.add(clientSocket);
				
				new ServerThread(clientSocket, list).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
