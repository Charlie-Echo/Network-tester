/**
 * Code is taken from Computer Networking: A Top-Down Approach Featuring 
 * the Internet, second edition, copyright 1996-2002 J.F Kurose and K.W. Ross, 
 * All Rights Reserved.
 **/

import java.io.*; 
import java.net.*; 

class UDPServer { 
    public static void main(String args[]) throws Exception 
    { 
	
	DatagramSocket serverSocket = new DatagramSocket(9876); 
	
	byte[] receiveData = new byte[1024]; 
	byte[] sendData  = new byte[1024]; 
	
	while(true) 
	    { 
		
		DatagramPacket receivePacket = 
		    new DatagramPacket(receiveData, receiveData.length); 
		serverSocket.receive(receivePacket); 
		String sentence = new String(receivePacket.getData()); 
		
		InetAddress IPAddress = receivePacket.getAddress(); 
		
		int port = receivePacket.getPort(); 
		
		String capitalizedSentence = sentence.toUpperCase(); 
		
		sendData = capitalizedSentence.getBytes(); 
		
		DatagramPacket sendPacket = 
		    new DatagramPacket(sendData, sendData.length, IPAddress, 
				       port); 
		
		serverSocket.send(sendPacket); 
	    } 
    } 
}  