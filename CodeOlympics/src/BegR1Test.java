
public class BegR1Test {

	public static void main(String[] args) {
		int score = 0;
		
		BegR1P1 p1 = new BegR1P1();
		p1.printPrimes();
		score++;
		
		BegR1P2 p2 = new BegR1P2();
		if (p2.isLastDigit(10, 100)) score++;
		else System.out.println("ERROR: "+2.1);
		if (p2.isLastDigit(5, 5)) score++;
		else System.out.println("ERROR: "+2.2);
		if (p2.isLastDigit(13, 25)) score++;
		else System.out.println("ERROR: "+2.3);
		
		BegR1P3 p3 = new BegR1P3();
		if (p3.speedTicket(60) == 0) score++;
		else System.out.println("ERROR: "+3.1);
		if (p3.speedTicket(80) == 1) score++;
		else System.out.println("ERROR: "+3.2);
		if (p3.speedTicket(99) == 2) score++;
		else System.out.println("ERROR: "+3.3);
		
		BegR1P4 p4 = new BegR1P4();
		if (p4.copyString("Hi", 2).equals("HiHi")) score++;
		else System.out.println("ERROR: "+4.1);
		if (p4.copyString("Hi", 3).equals("HiHiHi")) score++;
		else System.out.println("ERROR: "+4.2);
		if (p4.copyString("Hi", 1).equals("Hi")) score++;
		else System.out.println("ERROR: "+4.3);
		
		BegR1P5 p5 = new BegR1P5();
		p5.printPyramid("Java", 3);
		score++;
		
		System.out.println("SCORE: "+score);
	}

}
