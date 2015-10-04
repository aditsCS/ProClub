
public class BegR3Test {
	
	public static void main(String[] args) {
		int score = 0;
		
		BegR3P1 p1 = new BegR3P1();
		if (p1.calculateArea(5, 5) == 25) score++;
		else System.out.println("ERROR: "+1.1);
		if (p1.calculateArea(10, 50) == 500) score++;
		else System.out.println("ERROR: "+1.2);
		
		BegR3P2 p2 = new BegR3P2();
		if (p2.replaceWords().equals("The chubby kitten met another chubby kitten at the park")) score++;
		else System.out.println("ERROR: "+2.1);
		
		BegR3P3 p3 = new BegR3P3();
		if (p3.areaCode("408 555 4321").equals("Area Code: 408")) score++;
		else System.out.println("ERROR: "+3.1);
		if (p3.areaCode("650 555 4321").equals("Area Code: 650")) score++;
		else System.out.println("ERROR: "+3.2);

		BegR3P4 p4 = new BegR3P4();
		p4.printUniqueFactors(10);
		score++;
		
		BegR3P5 p5 = new BegR3P5();
		p5.getFactors(10);
		score++;
		
		System.out.println("SCORE: "+score);
	}

}
