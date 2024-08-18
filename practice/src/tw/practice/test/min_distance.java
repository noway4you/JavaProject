package tw.practice.test;

import java.util.Scanner;

public class min_distance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Word1 = ");
		String word1 = sc.nextLine();
		System.out.print("Word2 = ");
		String word2 = sc.nextLine();
		System.out.println("-------------------------------");
		System.out.println("Minimum operation = " + min_distance(word1, word2));
	}
	
	public static int min_distance(String word1,String word2){
		int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        
        // word1 to word2 >> add words
        for(int i=0;i<=n;i++) dp[0][i] = i;
        // word1 to word2 >> delete words
        for(int i=0;i<=m;i++) dp[i][0] = i;
        // word1 to word2 >> if character is same , then operation same as before
        for(int i=1;i<=m;i++) {
        	for(int j=1;j<=n;j++) {
        		if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
        		else dp[i][j] = Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] , dp[i][j-1])) + 1;
        	}
        }
        // print the table of all conditions
        System.out.println("Table :");
        for(int i=0;i<=m;i++) {
        	for(int j=0;j<=n;j++) {
        		System.out.print(dp[i][j] + " ");
        	}
        	System.out.println();
        }
        
        System.out.println("-------------------------------");
        
        return dp[m][n];
	}

}
