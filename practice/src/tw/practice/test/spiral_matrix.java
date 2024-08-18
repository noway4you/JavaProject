package tw.practice.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class spiral_matrix {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Choose the method ? (Array to Matrix / Matrix to Array)\nInput = ");
		String method = sc.nextLine();
		check_method(method);
	}
	public static void check_method(String method) {
		Scanner sc = new Scanner(System.in);
		
		if(method.equals("Array to Matrix")) {
			
			System.out.print("How many rows?");
			int s1 = sc.nextInt();
			System.out.print("How many columns?");
			int s2 = sc.nextInt();
			int[] array = new int[s1*s2];
			
			for(int i = 0 ; i < s1*s2 ; i++) {
				System.out.print("number" + (i+1) + " = ");
				int nums = sc.nextInt();
				array[i] = nums;
			}
			
			System.out.println("-----------------------------");
			System.out.println("Array to Spiral Matrix :");
			generateMatrix(array,s1,s2);
			
		}else if(method.equals("Matrix to Array")) {
			
			System.out.print("How many rows?");
			int s1 = sc.nextInt();
			System.out.print("How many columns?");
			int s2 = sc.nextInt();
			int[][] matrix = new int[s1][s2];
			
			for(int i = 0 ; i < s1 ; i++) {
				System.out.println("Enter the row" + (i+1) + " values :");
				for(int j = 0 ; j < s2 ; j++) {
					System.out.print("number" + (j+1) + " = ");
					int nums = sc.nextInt();
					matrix[i][j] = nums;
				}
			}
			
			System.out.println("-----------------------------");
			System.out.println("Spiral Matrix to Array :\n" + spiral_matrix(matrix));
		}else {
			
			System.out.println("Wrong method!");
			
		}
	}
	
	public static List<Integer> spiral_matrix(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if(matrix.length == 0 || matrix[0].length == 0) return res;
		
		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		
		while(true) {
			for(int i = left ; i <= right ; i++) res.add(matrix[top][i]);
			top++;
			if(top > bottom) break;
			
			for(int i = top ; i <= bottom ; i++) res.add(matrix[i][right]);
			right--;
			if(left > right) break;
			
			for(int i = right ; i >= left ; i--) res.add(matrix[bottom][i]);
			bottom--;
			if(top > bottom) break;
			
			for(int i = bottom ; i >= top ; i--) res.add(matrix[i][left]);
			left++;
			if(left > right) break;
		}
		
		return res;
	}
	
	public static void generateMatrix(int[] array , int row , int column) {
        int[][] res = new int[row][column];
        
        int left = 0;
        int right = column-1;
        int top = 0;
        int bottom = row-1;
        int count = 0;

        while(true){
        	
            for(int i=left;i<=right;i++) {
            	res[top][i] = array[count];
                count++;
            }
            top++;
            if(top > bottom) break;
            
            for(int i=top;i<=bottom;i++){
                res[i][right] = array[count];
                count++;
            }
            right--;
            if(left > right) break;
            
            for(int i=right;i>=left;i--){
                res[bottom][i] = array[count];
                count++;
            }
            bottom--;
            if(top > bottom) break;
            
            for(int i=bottom;i>=top;i--){
                res[i][left] = array[count];
                count++;
            }
            left++;
            if(left > right) break;
        }

        for(int i = 0 ; i < row ; i++) {
        	for(int j = 0 ; j < column ; j++) {
        		System.out.print(res[i][j] + "\t");
        	}
        	System.out.println();
        }
    }
}
