import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * The FileIO class takes care of the reading delimited files
 *
 */

public class FileIO 
{
	public String lineSeparator;
	
	
	public FileIO()
	{
		lineSeparator = System.getProperty("line.separator");
	
	}
	
	public String readFile(String fileName)
	{
		BufferedReader breader = null;
		String fileData = null;
		FileReader reader;
		Scanner in = null;
		try 
		{
			reader = new FileReader(fileName);
			breader = new BufferedReader(reader);
			in = new Scanner(breader);
			StringBuffer buffer= new StringBuffer();
			
			while(in.hasNextLine())
			{
				
				buffer.append(in.nextLine());
				buffer.append(lineSeparator);
			}
			
			fileData = buffer.toString();
			
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(in !=  null)
				in.close();
		}
		
		
		return fileData;
	}
	
	public void writeFile(String filename, String data)
	{
		FileWriter writer = null;
		BufferedWriter bwriter = null;
		
		try
		{
			writer = new FileWriter(filename);
			bwriter = new BufferedWriter(writer);
			bwriter.write(data);
			bwriter.flush();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(bwriter != null)
				try
				{
					bwriter.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
		}
		
		
	}

}
