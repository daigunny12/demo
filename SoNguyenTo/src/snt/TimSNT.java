package snt;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TimSNT {
	
	private static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		int k = 0;
		getSet a1 = new getSet(k);
		// xoa noi dung file truoc khi ghi ket qua
				FileWriter fos = new FileWriter("fileSNT/output.txt", false);
				PrintWriter pw1 = new PrintWriter(fos);
				pw1.flush();
				pw1.close();
				fos.close();
		int a;
		int b;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap a:");
		a = sc.nextInt();
		System.out.println("Nhap b:");
		b = sc.nextInt();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = a; i <= b; i++) {
					{
						int dem = 0;
						for (int j = 1; j <= i; j++) {
							if (i % j == 0)
								dem++;
						}
						if (dem == 2)
							a1.k=i;
						System.out.println();
						
					}
				}

			}
		});
		t1.start();
		ghiFile(a,b,a1.k);
	}
	public static void kiemTraSNT(int n,getSet a2 ) {
		int dem = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				dem++;
		}
		if (dem == 2)
			a2.k=n;
		System.out.println(n);
		
	}
	// Ghi file
	public static void ghiFile(int a, int b,int k) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("fileSNT/output.txt", true);
		PrintWriter pw = new PrintWriter(fos);
		pw.println("Ma tran: ");
		for (int i =a; i <= b; i++) {
			pw.println("i: "+i);
			pw.println("k: "+k);
			
		}
		pw.close();
	}
}
