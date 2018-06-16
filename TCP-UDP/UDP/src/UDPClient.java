/**
 * Code is taken from Computer Networking: A Top-Down Approach Featuring 
 * the Internet, second edition, copyright 1996-2002 J.F Kurose and K.W. Ross, 
 * All Rights Reserved.
 **/

import java.io.*; 
import java.net.*; 

class UDPClient { 
    public static void main(String args[]) throws Exception 
    { 
	
	BufferedReader inFromUser = 
	    new BufferedReader(new InputStreamReader(System.in)); 
	
	DatagramSocket clientSocket = new DatagramSocket(); 
	
	InetAddress IPAddress = InetAddress.getByName("hostname"); 
	
	byte[] sendData = new byte[1024]; 
	byte[] receiveData = new byte[1024]; 
	
	String sentence = inFromUser.readLine(); 
	sendData = sentence.getBytes();         
	DatagramPacket sendPacket = 
	    new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
	
	clientSocket.send(sendPacket); 
	
	DatagramPacket receivePacket = 
	    new DatagramPacket(receiveData, receiveData.length); 
	
	clientSocket.receive(receivePacket); 
	
	String modifiedSentence = 
	    new String(receivePacket.getData()); 
	
	System.out.println("FROM SERVER:" + modifiedSentence); 
	clientSocket.close(); 
    } 
} 