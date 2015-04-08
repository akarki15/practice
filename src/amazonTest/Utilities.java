package amazonTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.print.DocFlavor.STRING;
import javax.swing.text.AbstractDocument.BranchElement;

public class Utilities {
	public static void main(String[] args) {
		// int[][] inputMatrix = readFile(System.getProperty("user.dir")
		// + "/src/amazonTest/a1.txt");
		// printMatrix(inputMatrix);
		// int[][][] a = divide(inputMatrix, 64);
		// System.out.println("______________________________");
		// for (int i = 0; i < a.length; i++) {
		// printMatrix(a[i]);
		// System.out.println("=+++++++++++++++++++++=");
		// }
		// eightWaysSend();

		// String file1 =" blha";
		// String file2 =" blhadsafdsa";
		// char[][] filePaths = {file1.toCharArray(),
		// file2.toCharArray()};
		// for (int i=0;i< file2.length();i++){
		// System.out.println(filePaths[1][i]);
		// }

		// char [] bleh = {'a','b'};
		// char [][] q ={bleh,bleh};
		// System.out.println(charArrayToString(q[0]));
		// eightWaysSend();
		glue2();
		
	}

	static int[][] readFile(String fileName) {
		// Declare and initialize with zero values.
		int counter = 0;
		int size = 0;
		int[][] input = {};

		try {
			FileReader fileReader = new FileReader(new File(fileName));
			BufferedReader bf = new BufferedReader(fileReader);
			String s;
			while ((s = bf.readLine()) != null) {
				/*
				 * Decide the size of matrix after having read the first line of
				 * the input file
				 */
				int[] parsedLine = parseLine(s);
				if (size == 0) {
					size = parsedLine.length;
					input = new int[size][size];
				}
				input[counter++] = parsedLine;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return input;
	}

	static int[] parseLine(String s) {
		String[] sList = s.split("\\ "); // Use space as delimiter
		int[] lineInt = new int[sList.length];
		for (int i = 0; i < sList.length; i++) {
			lineInt[i] = Integer.parseInt(sList[i]);
		}

		return lineInt;
	}

	static int[][][] divideMatrix(int[][] input, int parts) {
		// Assumes the matrix is a square matrix and is dividable into parts.
		int inputSize = input.length;
		int dividedSize = (inputSize / parts) * 2;
		System.out.println(dividedSize);
		int[][][] dividedMatrix = new int[parts][dividedSize][dividedSize];
		for (int i = 0; i < parts; i++) {
			System.out.println("----------");
			// (dividedSize*i)%inputSize gives starting col no. for parts in
			// successive order
			for (int j = (dividedSize * i) % inputSize; j < ((dividedSize * i)
					% inputSize + dividedSize); j++) {
				// for (int k = 0; k < size; k++) {
				// dividedMatrix[i][j][k] = input [j*i][k*i];
				// }
				System.out.print(j + "\t");
			}
			System.out.println();
		}
		return dividedMatrix;
	}

	public static int[][][] divide(int[][] a, int p) {

		int sub = (int) Math.cbrt(p * p);
		int sq = (int) Math.sqrt(sub);

		int divided = (a.length) / (sq);

		int[][][] dividedMatrix = new int[sub][divided][divided];

		for (int m = 0; m <= sq - 1; m++) {// m and n help start at the correct
											// beginning location
			for (int n = 0; n <= sq - 1; n++) {
				int startk = n * divided;
				int startl = m * divided;
				int x = m * sq + n; // determines which spot in the three
									// dimmensional array the subarray will go
									// into
				for (int y = 0; y <= divided - 1; y++) {
					for (int z = 0; z <= divided - 1; z++) {
						dividedMatrix[x][y][z] = a[startk + y][startl + z];
					}
				}
			}
		}

		for (int i = 0; i <= dividedMatrix.length - 1; i++) {
			for (int j = 0; j <= dividedMatrix[0].length - 1; j++) {
				for (int k = 0; k <= dividedMatrix[0][j].length - 1; k++) {
					// System.out.print(dividedMatrix[i][j][k] + " ");
				}
				// System.out.println();
			}
			// System.out.println(dividedMatrix.length + " ");
		}
		return dividedMatrix;
	}

	static void printMatrix(int[][] matrix) {
		int size = matrix.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	static int[][] dummyInput(int fill, int size) {
		int[][] output = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				output[i][j] = fill;
			}
		}
		return output;
	}

	static int[][] multiply(int[][] a, int[][] b) {
		int size = a.length;
		// printMatrix(a);
		// printMatrix(b);
		int[][] output = new int[size][size];

		for (int i = 0; i < size; i++) { // row
			for (int j = 0; j < size; j++) { // col
				int val = 0;
				for (int k = 0; k < size; k++) {
					val += a[i][k] * b[k][j];
				}
				output[i][j] = val;
			}
		}
		return output;
	}

	static void eightWaysSend() {
		int dest = 1; // start sending with process ranked 1
		int[][] indexMatrix = { { 0, 1 }, { 3, 4 } };
		// int[][] indexMatrix =
		// {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
		// since the m1 and m2 hold inputs as linear chain, indexMatrix will
		// help us track indices.

		// int size = indexMatrix.length; // length of a dimension
		int size = 4;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					System.out.println(dest + "   :   " + i + " " + k + " ||| "
							+ k + "," + j);
					// int index1 = indexMatrix[i][k];
					// int index2 = indexMatrix[k][j];
					dest++;
					// System.out.println(index1+" "+index2);

				}
			}
		}
	}

	public static String charArrayToString(char[] array) {
		String s = "";
		for (char a : array) {
			s += a;
		}
		return s;
	}

	public static void make() {
		int k = 1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print((k++) + " ");
			}
			System.out.println();
		}
	}

	public static void glue2() {
		String[] list = nameList(4);
		int num = 0;
		System.out.println();
		int size =4;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					System.getProperty("user.dir") + "/c1.txt")));
			for (int i = 0; i < size; i++) {
				String s="";
				String full= System.getProperty("user.dir") + "/src/amazonTest/small/64/";
				BufferedReader br1 = new BufferedReader(new FileReader(
						new File(full+list[num++])));
				BufferedReader br2 = new BufferedReader(new FileReader(
						new File(full+list[num++])));
				BufferedReader br3 = new BufferedReader(new FileReader(
						new File(full+list[num++])));
				BufferedReader br4 = new BufferedReader(new FileReader(
						new File(full+list[num++])));
				
				while((s=br1.readLine())!=null){
					s+=br2.readLine();
					s+=br3.readLine();
					s+=br4.readLine();
					bw.write(s);					
					bw.write("\n");
					System.out.println("write");
				}
				
				br1.close();
				br2.close();
				br3.close();
				br4.close();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String[] nameList(int size) {
		String[] fileList = new String[16];
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				String s = "";
				for (int k = 0; k < size; k++) {
					if (k == 0)
						s = i + "_" + k + "_" + k + "_" + j;
					else
						s += "+" + i + "_" + k + "_" + k + "_" + j;
				}
				System.out.println(s);
				fileList[count++] = s;
			}
		}
		return fileList;
	}

}
