package aditya.interfaces;

import java.io.Serializable;

/**
 * Thing that gets sent over the network
 * 
 * @author Aditya Sampath
 *
 */
public interface NetworkMessage extends Serializable {
	public String getIP();
	public String getName();
	public String getMessage();
}
