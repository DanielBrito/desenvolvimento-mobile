package com.br.mobile;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	private static ServerSocket server;

	public static void main(String[] args) {
		
		try {
			
            server = new ServerSocket(60000);

            while(true){
            	
                Socket socket = server.accept();

                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
                
                dOut.writeLong(System.currentTimeMillis());

                dOut.flush();
                dOut.close();
                socket.close();
            }
        } catch (IOException e) {
            
            e.printStackTrace();
        }
	}
}

