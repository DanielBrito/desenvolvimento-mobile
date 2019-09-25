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
			
            server = new ServerSocket(50000);

            while(true){
            	
                Socket socket = server.accept();

                DataInputStream dIn = new DataInputStream(socket.getInputStream());
                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
                
                String result = dIn.readUTF();

                System.out.println(result);
                
                if(result.equals("1")) {
                	
                	dOut.writeUTF("OK 1");
                }
                else
                if(result.equals("2")) {
                	
                	dOut.writeUTF("OK 2");
                }
                else {
                	
                	dOut.writeUTF("Not found");
                }
                
                dOut.writeUTF("OK");

                dOut.close();
                dIn.close();
                socket.close();
            }
        } catch (IOException e) {
            
            e.printStackTrace();
        }

	}

}
