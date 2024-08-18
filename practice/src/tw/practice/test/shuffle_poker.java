package tw.practice.test;

import java.util.ArrayList;
import java.util.Collections;

public class shuffle_poker {

	public static void main(String[] args) {
		ArrayList<Integer> poker = new ArrayList<>();
		for(int i=0;i<52;i++) poker.add(i);
		Collections.shuffle(poker);
		
		int k = 0;
		for(int i=0;i<4;i++) {
			System.out.print("Player"+(i+1)+" = ");
			for(int j=0;j<13;j++) {
				if(poker.get(k)/13 == 0) System.out.print("黑桃" + (poker.get(k)%13+1) + "\t");
				if(poker.get(k)/13 == 1) System.out.print("紅心" + (poker.get(k)%13+1) + "\t");
				if(poker.get(k)/13 == 2) System.out.print("方塊" + (poker.get(k)%13+1) + "\t");
				if(poker.get(k)/13 == 3) System.out.print("梅花" + (poker.get(k)%13+1) + "\t");
				k++;
			}
			System.out.println();
		}
	}

}
