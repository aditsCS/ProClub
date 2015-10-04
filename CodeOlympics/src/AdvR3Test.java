
public class AdvR3Test {
	
	public static void main(String[] args) {
		int score = 0;
		
		AdvR3P1 p1 = new AdvR3P1();
		if (p1.toCoins("$2.67").equals("10 quarters, 1 dimes, 1 nickels, 2 pennies")) score++;
		else System.out.println("ERROR: "+1.1);
		
		AdvR3P2 p2 = new AdvR3P2();
		if (p2.toNumber("one hundred twenty six") == 126) score++;
		else System.out.println("ERROR: "+2.1);
		if (p2.toNumber("three hundred eighty") == 380) score++;
		else System.out.println("ERROR: "+2.2);
		if (p2.toNumber("nine hundred five") == 905) score++;
		else System.out.println("ERROR: "+2.3);
		
		AdvR3P3 p3 = new AdvR3P3();
		int[] arr = {4, 5, 1};
		if (p3.modifiedArray(arr, 1, 7)[1] == 7) score++;
		else System.out.println("ERROR: "+3.1);
		if (p3.modifiedArray(arr, 0, 9)[0] == 9) score++;
		else System.out.println("ERROR: "+3.2);
		if (p3.modifiedArray(arr, 3, 2)[3] == 2) score++;
		else System.out.println("ERROR: "+3.3);
		
		AdvR3P4 p4 = new AdvR3P4();
		if (p4.middle(arr) == 5) score++;
		else System.out.println("ERROR: "+4.1);
		int[] arr2 = {1};
		if (p4.middle(arr2) == 1) score++;
		else System.out.println("ERROR: "+4.2);
		
		AdvR3P5 p5 = new AdvR3P5();
		if (p5.toDecimal(100) == 4) score++;
		else System.out.println("ERROR: "+5.1);
		if (p5.toDecimal(1010) == 10) score++;
		else System.out.println("ERROR: "+5.2);
		
		System.out.println("SCORE: "+score);
	}

}
