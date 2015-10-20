package networking;

import java.io.Serializable;

/**
 * Thing that gets sent over the network
 * 
 * @author Aditya Sampath
 *
 */
public class NetworkMessage implements Serializable {
	private String str;
	private String myIP;
	private String myName;
	private boolean closeAlert;
	private static final long serialVersionUID = 1L;
	
	public NetworkMessage(String s, String ip, String name) {
		str = s;
		myIP = ip;
		myName = name;
		closeAlert = false;
	}
	
	public NetworkMessage(boolean close) {
		closeAlert = close;
	}
	
	public String getIP() {
		return myIP;
	}

	public String getName() {
		return myName;
	}

	public String getMessage() {
		return str;
	}
	
	public boolean getClose() {
		return closeAlert;
	}
}
