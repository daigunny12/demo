package MT;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class taoFile {

	public static void main(String[] args) throws IOException {
	File dir = new File("fileMaTran");
	if (!dir.exists()) {
	dir.mkdir();
	}
	
	File file = new File("fileMaTran/test.txt");
	if (!file.exists())
	{
		file.createNewFile();
	}

	File f = new File("fileMaTran/output.txt");
	if (!f.exists())
	{
		f.createNewFile();
	}
	FileReader fileReader = new FileReader(file);
	
	int c = fileReader.read();
	while (c != -1)
	{
		System.out.print((char)c);
		c= fileReader.read();
	}
	fileReader.close();
	}
}
