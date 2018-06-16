/**
 * Code is taken from Computer Networking: A Top-Down Approach Featuring 
 * the Internet, second edition, copyright 1996-2002 J.F Kurose and K.W. Ross, 
 * All Rights Reserved.
 **/

import java.io.*; 
import java.net.*; 
class TCPClient { 
    
    public static void main(String argv[]) throws Exception 
    { 
        String sentence; 
        String modifiedSentence; 
	
        BufferedReader inFromUser = 
	    new BufferedReader(new InputStreamReader(System.in)); 
	
        Socket clientSocket = new Socket("hostname", 6789); 
	
        DataOutputStream outToServer = 
	    new DataOutputStream(clientSocket.getOutputStream()); 
	
        
	BufferedReader inFromServer = 
	    new BufferedReader(new
		InputStreamReader(clientSocket.getInputStream())); 
	
        sentence = inFromUser.readLine(); 
	
        outToServer.writeBytes(sentence + '\n'); 
	
        modifiedSentence = inFromServer.readLine(); 
	
        System.out.println("FROM SERVER: " + modifiedSentence); 
	
        clientSocket.close(); 
	
    } 
} 