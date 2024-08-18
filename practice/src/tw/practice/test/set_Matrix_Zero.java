package tw.practice.test;

import java.util.Arrays;
import java.util.Scanner;

public class set_Matrix_Zero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many rows ?");
		int row = sc.nextInt();
		System.out.print("How many columns ?");
		int column = sc.nextInt();
		
		int[][] matrix = new int[row][column];
		
		System.out.println("Original:");
		for(int i = 0 ; i < row ; i++) {
			System.out.print("Row" + (i+1) + " : ");
			for(int j = 0 ; j < column ; j++) {
				int r = (int)(Math.random()*10);
				matrix[i][j] = r;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------");
		
		setZeroes(matrix);
		
		System.out.println("After SetZeroes:");
		for(int i = 0 ; i < row ; i++) {
			System.out.print("Row" + (i+1) + " : ");
			for(int j = 0 ; j < column ; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int k = 0;
		
		// check if row1 has zero
		while(k < n && matrix[0][k]!=0) k++;
		
		// check row2 ~ last row if there has zero , then let element at position i=0 and j=0 to zero 
		for(int i = 1 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
			}
		}
		
		// check from last column , if element at position i=0 or j=0 is zero , then let element to zero
		for(int i = 1 ; i < m ; i++) {
			for(int j = n - 1 ; j >= 0 ; j--) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
			}
		}
		
		// let row1 all elements to zero , if row1 has zero
		if(k < n) Arrays.fill(matrix[0] , 0);
	}

}
