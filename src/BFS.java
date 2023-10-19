import java.util.*;

 public class BFS {

	private Queue<Integer> queue;
	
	public BFS() {
		queue = new LinkedList<>();
	}
	
	public void bfs(int[][]matriks, int simpulAwal, int jumlahSimpul) {
		int[] kunjungi = new int [jumlahSimpul + 1];
		int element;
		
		kunjungi[simpulAwal] = 1;
		queue.add(simpulAwal);
		System.out.println("Simpul Awal " + " ");
		
		while (!queue.isEmpty()) {
			
			element = queue.remove();
			int i = 1;
			
			while(i < jumlahSimpul) {
				
				if(matriks[element][i] == 1 && kunjungi[i] == 0) {
					queue.add(i);
					kunjungi[i] = 1;
					System.out.println(i + " ");
				}
				
				i++;
			}
		}
	}
	
	public static void main(String[]args) {
		int jumlahSimpul, jumlahSisi, count = 1, asal = 0, tujuan = 0;
		int simpulAwal;
		Scanner sc = new Scanner(System.in);
		Matriks_Ketetanggaan graf;
		BFS bfs = new BFS();
		
		System.out.print("Masukkan Jumlah Simpul : ");
		jumlahSimpul = sc.nextInt();
		System.out.print("Masukkan Jumlah Sisi : ");
		jumlahSisi = sc.nextInt();
		
		graf = new Matriks_Ketetanggaan(jumlahSimpul);
		int matriks[][] = new int[jumlahSimpul + 1][jumlahSimpul + 1];
		
		System.out.println("Masukkan Sisi <Asal> <Tujuan>");
		while(count <= jumlahSisi) {
			asal = sc.nextInt();
			tujuan = sc.nextInt();
			
			graf.setSisi(asal, tujuan, 1);
			count++;
		}
		
		System.out.println("\nMatriks Ketetanggaan : ");
		System.out.print("");
		
		for(int i = 1; i <= jumlahSimpul; i++) {
			System.out.print(i + " ");
			for(int j = 1; j <= jumlahSimpul; j++) {
				System.out.print(graf.getSisi(i, j) + " ");
				matriks[i][j] = graf.getSisi(i, j);
			}
			System.out.println();
		}
		
		System.out.print("Masukkan Simpul Awal = ");
		simpulAwal = sc.nextInt();
		
		System.out.println("\nBFS = ");
		bfs.bfs(matriks, simpulAwal, 6);
		
	}
}
 
 class Matriks_Ketetanggaan{
	 
	 private int simpul;
	 private int[][] matriks_ketetanggaan;
	 
	 public Matriks_Ketetanggaan(int v) {
		 simpul = v;
		 matriks_ketetanggaan = new int[simpul + 1][simpul+1];
		 
	 }
	 
	 public void setSisi(int asal, int tujuan, int sisi) {
		 try {
			 matriks_ketetanggaan[asal][tujuan] = sisi;
		 }
		 
		 catch(Exception e) {
			 System.out.println("Error");
		 }
	 }
	 
	 public int getSisi(int asal, int tujuan) {
		 try {
			 return matriks_ketetanggaan[asal][tujuan];
		 }
		 
		 catch(Exception e) {
			 System.out.println("Error");
		 }
		 
		 return -1;
	 }
	 
 }


