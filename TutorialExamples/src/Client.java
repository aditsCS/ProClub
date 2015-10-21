import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) {
		String host = "localhost";
		int port = 8000;
		BufferedReader in;
		PrintWriter out;
		Socket socket;

		Scanner input = new Scanner(System.in);

		try {
			socket = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				System.out.print("Text to send: ");
				out.println(input.nextLine());
				JOptionPane.showMessageDialog(null, "Server says: "+in.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
