package MT;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class tichMT {
	
	

	public static void main(String[] args) throws IOException, InterruptedException {

		// xoa noi dung file truoc khi ghi ket qua
		FileWriter fos = new FileWriter("fileMaTran/output.txt", false);
		PrintWriter pw1 = new PrintWriter(fos);
		pw1.flush();
		pw1.close();
		fos.close();
		

		//khai bao cac bien duoc su dung
		docFile df = new docFile();
		int[][] a=null, b=null, c= null;
		int m=0, n=0, k=0;
		getAet a1 = new getAet(m, n, k, a, b, c);
		String q = "Thu nhat", w = "Thu Hai", e = "Ket Qua";

	
		

		// nhap ma tran
		System.out.println("Nhap ma tran a:");
		df.openFile();
		df.readFile(a1);
		System.out.println("Nhap ma tran b:");
		df.readFile2(a1);
		df.closeFile();
		
		// xuat ma tran a
		System.out.println("Xuat ma tra a: ");
		xuat(a1.a);

		// xuat ma tran b
		System.out.println("Xuat ma tran b: ");
		xuat(a1.b);

		
		a1.c = new int[a1.a.length][a1.b[0].length];
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				nhanMt1(a1.a, a1.b,a1.c);
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				nhanMt2(a1.a, a1.b,a1.c);
				 try {
		               // Ngủ 1030 milli giây.
		               Thread.sleep(1030);
		           } catch (InterruptedException e) {
		           }
			}
		});

		
		t1.start();
		t2.start();

		
		
		// Ghi ket qua ra file
		ghiFile(a1.a, q);
		ghiFile(a1.b, w);
		ghiFile(a1.c,e);

	}

	// nhap ma tran
	public static int[][] nhapmt(int m, int n, Scanner sc) {
		int[][] x = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				x[i][j] = sc.nextInt();
			}
		}
		return x;
	}

	// xuat ma tran
	public static void xuat(int[][] x){
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				System.out.printf("%4d", x[i][j]);
			}
			System.out.println();
		}
	}

	// nhan ma tran 1
	public static void nhanMt1(int[][] a, int[][] b,int[][] c) {;
		int m2 = a.length/2;
		int n = b[0].length;
		int k = a[0].length;
		for (int i = 0; i < m2; i++) {
			for (int j = 0; j < n; j++) {
				for (int l = 0; l < k; l++) {
					c[i][j] += a[i][l] * b[l][j];	
				}
			}
		}	
	}
	
	
	// nhan ma tran 2
	public static void nhanMt2(int[][] a, int[][] b,int [][] c) {
		int m = a.length;
		int n = b[0].length;
		int k = a[0].length;
		int m2 = a.length/2;
		for (int i = m2; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int l = 0; l < k; l++) {
					c[i][j] += a[i][l] * b[l][j];
				}
			}
		}
	}
	

	// Ghi file
	public static void ghiFile(int[][] x, String y) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("fileMaTran/output.txt", true);
		PrintWriter pw = new PrintWriter(fos);
		pw.println("Ma tran: " + y);
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				pw.printf("%4d", x[i][j]);
			}
			pw.println();
		}
		pw.close();
	}
}
