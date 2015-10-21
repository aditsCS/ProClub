import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) {
		String host = "localhost";
		int port = 8000;
		DataInputStream in;
		DataOutputStream out;
		Socket socket;

		Scanner input = new Scanner(System.in);

		try {
			socket = new Socket(host, port);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			while (true) {
				System.out.print("Send number to server: ");
				out.writeInt(input.nextInt());
				JOptionPane.showMessageDialog(null, "Server sent number: "+in.readInt());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
