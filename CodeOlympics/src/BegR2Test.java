
public class BegR2Test {
	
	public static void main(String[] args) {
		int score = 0;
		
		BegR2P1 p1 = new BegR2P1();
		p1.printA("aardvark", "andrew", "amrita");
		score++;
		
		BegR2P2 p2 = new BegR2P2();
		p2.printColorsOfRainbow();
		score++;
		
		BegR2P3 p3 = new BegR2P3();
		if (p3.sumOfNumbers(9) == 45) score++;
		else System.out.println("ERROR: "+3.1);
		if (p3.sumOfNumbers(0) == 0) score++;
		else System.out.println("ERROR: "+3.2);
		if (p3.sumOfNumbers(3) == 6) score++;
		else System.out.println("ERROR: "+3.3);
		
		BegR2P4 p4 = new BegR2P4();
		if (!p4.isMultipleOf(7)) score++;
		else System.out.println("ERROR: "+4.1);
		if (p4.isMultipleOf(100)) score++;
		else System.out.println("ERROR: "+4.2);
		if (p4.isMultipleOf(160)) score++;
		else System.out.println("ERROR: "+4.3);
		
		BegR2P5 p5 = new BegR2P5();
		p5.printStickFigure();
		score++;
		
		System.out.println("SCORE: "+score);
	}

}
