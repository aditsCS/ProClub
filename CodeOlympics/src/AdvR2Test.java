
public class AdvR2Test {
	
	public static void main(String[] args) {
		int score = 0;
		
		AdvR2P1 p1 = new AdvR2P1();
		int[] arr = {3, 2, 1, 5};
		if (p1.findMissing(arr) == 4) score++;
		else System.out.println("ERROR: "+1.1);
		
		AdvR2P2 p2 = new AdvR2P2();
		if (p2.sumDigits(100) == 1) score++;
		else System.out.println("ERROR: "+2.1);
		if (p2.sumDigits(102) == 3) score++;
		else System.out.println("ERROR: "+2.2);
		if (p2.sumDigits(0) == 0) score++;
		else System.out.println("ERROR: "+2.3);
		
		AdvR2P3 p3 = new AdvR2P3();
		if (p3.evalExpr("6 * 2 + 3 - 6 / 2") == 12) score++;
		else System.out.println("ERROR: "+3.1);
		if (p3.evalExpr("1 + 2") == 3) score++;
		else System.out.println("ERROR: "+3.2);
		if (p3.evalExpr("1 * 2 / 2 ") == 1) score++;
		else System.out.println("ERROR: "+3.3);
		
		AdvR2P4 p4 = new AdvR2P4();
		int[] seq = {5, 2, -1};
		if (p4.sequenceConstant(seq) == -3) score++;
		else System.out.println("ERROR: "+4.1);
		int[] seq2 = {1, -3, 9, -27};
		if (p4.sequenceConstant(seq2) == -3) score++;
		else System.out.println("ERROR: "+4.2);
		
		AdvR2P5 p5 = new AdvR2P5();
		if (p5.factor(144).equals("2*2*2*2*3*3")) score++;
		else System.out.println("ERROR: "+5.1);
		if (p5.factor(2).equals("2")) score++;
		else System.out.println("ERROR: "+5.2);
		
		System.out.println("SCORE: "+score);		
	}

}
