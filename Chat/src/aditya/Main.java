package aditya;

import aditya.gui.*;
import aditya.interfaces.*;
import aditya.networking.*;

import java.io.IOException;
import java.net.*;

import javax.swing.JOptionPane;

/**
 * Main method for the whole rigamarole
 * 
 * @author Aditya_Sampath
 */
public class Main {
	
	private String myIP;
	
	public void doConnect(int response, String ip) {
		myIP = ip;
		
		if (response == JOptionPane.YES_OPTION) {
            SchoolServer schoolS = new SchoolServer();
            
            JOptionPane.showMessageDialog(null, "Your IP address is " + myIP);
           
            String myName = JOptionPane.showInputDialog(null, "What is your name?", "Name", JOptionPane.QUESTION_MESSAGE);
            
            ChatWindow gui = new ChatWindow(schoolS, myIP, myName, true);
            
            schoolS.register(gui);
            gui.makeVisibiletoWorld();
                       
            try {
				schoolS.run();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
        } else if (response == JOptionPane.NO_OPTION) {
            SchoolClient sc = new SchoolClient();
            String host = JOptionPane.showInputDialog(null, "What is the IP Adress of the Sever you want to connect to?", 
            		"Server IP to connect to", JOptionPane.QUESTION_MESSAGE);
            Socket res = sc.connect(host);

             if (res == null) {
                 JOptionPane.showMessageDialog(null, "Could not connect to " + host + "!");
                 return;
             } else {
                 JOptionPane.showMessageDialog(null, "Connected to " + host + "!");
                 
                 String myName = JOptionPane.showInputDialog(null, "What is your name?", "Name", JOptionPane.QUESTION_MESSAGE);
                 ChatWindow gui = new ChatWindow(sc, myIP, myName, false);
                 
                 sc.register(gui);
                 gui.makeVisibiletoWorld();

                 sc.run(res);
             }
        } else {
        	System.out.println("quitting");
        	return;
        }
	}
	
    public static void main(String[] args) throws UnknownHostException {
        int response = JOptionPane.showOptionDialog(null, "Are you the server or the client?", "Settings", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Server","Client"}, null);
        InetAddress thisIp = InetAddress.getLocalHost();
        String myIP = thisIp.getHostAddress();
        Main w = new Main();
        w.doConnect(response, myIP);
    }

}
