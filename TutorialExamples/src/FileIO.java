import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class FileIO {

	public static void main(String[] args) {
		File file = new File("file.txt");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.println("asdf");
		writer.close();
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String text = reader.readLine();
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
