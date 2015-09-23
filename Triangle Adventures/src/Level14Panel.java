import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Level14Panel extends JPanel{
	
	public Level14Panel() {

    JPanel p = new JPanel();
    p.setSize(1000,1000);
    p.setBackground(Color.RED);
   
    JLabel lab1 = new JLabel("LEVEL 14) Create your own!");
    JLabel lab2 = new JLabel("OBJECTIVE: You are in control now! Create a new class and design a level");
    JLabel lab3 = new JLabel("HINT: Look at pre-made levels for tips");
    lab2.setFont(new Font("Serif", Font.PLAIN, 30));
    lab3.setFont(new Font("Serif", Font.PLAIN, 30));

    
    lab1.setForeground(Color.WHITE);
    lab1.setFont(new Font("Serif", Font.PLAIN, 30));
    p.setLayout(new BorderLayout()); 
    p.add(lab1, BorderLayout.PAGE_START);
    p.add(lab2, BorderLayout.LINE_START);
    p.add(lab3, BorderLayout.PAGE_END);
    

    add(p);
	}

public static void main(String[] args) {

    JFrame frame = new JFrame();
    frame.getContentPane().add(new Level14Panel());
    frame.setBackground(Color.WHITE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 150);
    frame.setVisible(true);

	}
}