package MT;

import java.io.File;
import java.util.Scanner; 
import MT.getAet;

public class docFile {
	private Scanner x;
	
	public void openFile() {
		try {
		x = new Scanner(new File("fileMaTran/test.txt"));
	}
		catch(Exception e) {
			System.out.println("Không tìm thấy tệp");
		}
	}
	aaaaa
	
	public  int[][] readFile(getAet a) {
		a.setM(x.nextInt());
		a.setN(x.nextInt());
		a.a = new int[a.getM()][a.getN()];
		for (int i = 0; i < a.getM(); i++) {
			for (int j = 0; j < a.getN(); j++) {
				a.a[i][j] = x.nextInt();
				System.out.println(a.a[i][j]);
			}
		}
		return a.a;
	
	}
	public  int[][] readFile2(getAet a) {
		a.setK(x.nextInt());
		a.b = new int[a.getN()][a.getK()];
		for (int i = 0; i < a.getN(); i++) {
			for (int j = 0; j < a.getK(); j++) {
				a.b[i][j] = x.nextInt();
				System.out.println(a.b[i][j]);
			}
		}
		return a.b;
	
	}
	public void closeFile() {
		x.close();
		
	}
	}


