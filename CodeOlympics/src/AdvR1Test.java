
public class AdvR1Test {
	
	public static void main(String[] args) {
		int score = 0;
		
		AdvR1P1 p1 = new AdvR1P1();
		if (p1.replaceAll("ccatatfishdog", "cat").equals("fishdog")) score++;
		else System.out.println("ERROR: "+1.1);
		if (p1.replaceAll("cacacatttat", "cat").equals("at")) score++;
		else System.out.println("ERROR: "+1.2);
		if (p1.replaceAll("cacacatttatcatcat", "cat").equals("at")) score++;
		else System.out.println("ERROR: "+1.3);
		
		AdvR1P2 p2 = new AdvR1P2();
		if (p2.anagram("cat").split(" ").length == 6) score++;
		else System.out.println("ERROR: "+2.1);
		System.out.print(p2.anagram("cat"));
		if (p2.anagram("aaa").split(" ").length == 0) score++;
		else System.out.println("ERROR: "+2.2);
		System.out.println(p2.anagram("aaa"));
		if (p2.anagram("blue").split(" ").length == 24) score++;
		else System.out.println("ERROR: "+2.3);
		System.out.println(p2.anagram("blue"));
		
		AdvR1P3 p3 = new AdvR1P3();
		if (p3.isAnagram("cat", "tac")) score++;
		else System.out.println("ERROR: "+3.1);
		if (!p3.isAnagram("ggg", "fgh")) score++;
		else System.out.println("ERROR: "+3.2);
		if (p3.isAnagram("a", "a")) score++;
		else System.out.println("ERROR: "+3.3);
		
		AdvR1P4 p4 = new AdvR1P4();
		if (p4.overlap("asdf", "sdfa").equals("asdfa")) score++;
		else System.out.println("ERROR: "+4.1);
		if (p4.overlap("aaa", "aaa").equals("aaa")) score++;
		else System.out.println("ERROR: "+4.2);
		if (p4.overlap("purple", "please").equals("purplease")) score++;
		else System.out.println("ERROR: "+4.3);
		
		AdvR1P5 p5 = new AdvR1P5();
		if (p5.allSubstrings("cat").split(" ").length == 5) score++;
		else System.out.println(5.1);
		System.out.print(p5.allSubstrings("cat"));
		if (p5.allSubstrings("aaa").split(" ").length == 2) score++;
		else System.out.println(5.2);
		System.out.println(p5.allSubstrings("aaa"));
		if (p5.allSubstrings("blue").split(" ").length == 9) score++;
		else System.out.println(5.3);
		System.out.println(p5.allSubstrings("blue"));
		
		AdvR1P6 p6 = new AdvR1P6();
		if (p6.stretch("food", 3).equals("fffooooooddd")) score++;
		else System.out.println(6.1);
		if (p6.stretch("aaaabbaa", 2).equals("aaaaaaaabbbbaaaa")) score++;
		else System.out.println(6.2);
		if (p6.stretch("bye", 1).equals("bye")) score++;
		else System.out.println(6.3);
		
		System.out.println("SCORE: "+score);
	}

}
