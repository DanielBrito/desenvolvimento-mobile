package com.br.mobile;

import java.io.DataInputStream;
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

                DataInputStream dIn1 = new DataInputStream(socket.getInputStream());
                DataInputStream dIn2 = new DataInputStream(socket.getInputStream());
                DataInputStream dIn3 = new DataInputStream(socket.getInputStream());
                
                DataOutputStream dOut1 = new DataOutputStream(socket.getOutputStream());
                DataOutputStream dOut2 = new DataOutputStream(socket.getOutputStream());
                DataOutputStream dOut3 = new DataOutputStream(socket.getOutputStream());
                
                String message1 = dIn1.readUTF();
                String message2 = dIn1.readUTF();
                String message3 = dIn1.readUTF();
                
                if(message1.equals("OK") || message2.equals("OK") || message3.equals("OK")) {
                	
                	int min=1, max=100;
                	
                	dOut1.writeInt((int)(Math.random()*((max-min)+1))+min);
                	dOut2.writeInt((int)(Math.random()*((max-min)+1))+min);
                	dOut3.writeInt((int)(Math.random()*((max-min)+1))+min);
                }
               
                dIn1.close();
                dIn2.close();
                dIn3.close();
                
                dOut1.close();
                dOut2.close();
                dOut3.close();
                
                socket.close();
            }
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
	}
}

