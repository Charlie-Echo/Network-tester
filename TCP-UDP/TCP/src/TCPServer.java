/**
 * Code is taken from Computer Networking: A Top-Down Approach Featuring 
 * the Internet, second edition, copyright 1996-2002 J.F Kurose and K.W. Ross, 
 * All Rights Reserved.
 **/

import java.io.*; 
import java.net.*; 

class TCPServer { 
    
    public static void main(String argv[]) throws Exception 
    { 
	String clientSentence; 
	String capitalizedSentence; 
	
	ServerSocket welcomeSocket = new ServerSocket(6789); 
	
	while(true) { 
	    
            Socket connectionSocket = welcomeSocket.accept(); 
	    
	    BufferedReader inFromClient = 
		new BufferedReader(new
		    InputStreamReader(connectionSocket.getInputStream())); 
	    
	    DataOutputStream  outToClient = 
		new DataOutputStream(connectionSocket.getOutputStream()); 
	    
	    clientSentence = inFromClient.readLine(); 
	    
	    capitalizedSentence = clientSentence.toUpperCase() + '\n'; 
	    
	    outToClient.writeBytes(capitalizedSentence); 
        } 
    } 
} 
