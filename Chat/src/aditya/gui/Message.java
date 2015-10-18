package aditya.gui;

import aditya.interfaces.*;

/**
 * A message
 * 
 * @author Aditya Sampath
 *
 */
public class Message implements NetworkMessage {
	private String str;
	private String myIP;
	private String myName;
	private static final long serialVersionUID = 1L;
	
	public Message(String s, String ip, String name) {
		str = s;
		myIP = ip;
		myName = name;
	}
	
	public String getIP() {
		return myIP;
	}

	@Override
	public String getName() {
		return myName;
	}

	@Override
	public String getMessage() {
		return str;
	}
}
