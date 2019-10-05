package snt;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class taoFile {

	public static void main(String[] args) throws IOException {
	File dir = new File("fileSNT");
	if (!dir.exists()) {
	dir.mkdir();
	}
	
	File file = new File("fileSNT/output.txt");
	if (!file.exists())
	{
		file.createNewFile();
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
