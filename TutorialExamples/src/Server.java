import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {

	public static void main(String[] args) {
		int port = 8000;
		DataInputStream in;
		DataOutputStream out;
		ServerSocket server;
		Socket socket;

		try {
			server = new ServerSocket(port);
			socket = server.accept();
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			while (true) {
				int x = in.readInt();
				JOptionPane.showMessageDialog(null, "Number recieved from client: " + x);
				out.writeInt(x*2);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
