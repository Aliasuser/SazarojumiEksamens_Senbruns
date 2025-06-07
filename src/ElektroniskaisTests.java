import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class ElektroniskaisTests extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel jautajumuLauks;
	JRadioButton[] atbilzuPogas;
	JButton parbauditPoga;
	ButtonGroup poguGrupa;
	JPanel atbilzuLogs;
	
	public ElektroniskaisTests() {
		setSize(800, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Java Elektroniskais Tests");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10,10));
		
		jautajumuLauks = new JLabel("Tests");
		jautajumuLauks.setFont(new Font("Monospaced", Font.BOLD, 16));
		jautajumuLauks.setHorizontalAlignment(SwingConstants.CENTER);
		add(jautajumuLauks,BorderLayout.NORTH);
		atbilzuLogs = new JPanel();
		atbilzuLogs.setLayout(new GridLayout(4, 1, 5, 5));
		atbilzuPogas = new JRadioButton[4];		
		poguGrupa = new ButtonGroup();
		parbauditPoga = new JButton("Pārbaudīt atbildi");
		parbauditPoga.setFont(new Font("Arial", Font.BOLD, 14));
		
		add(atbilzuLogs,BorderLayout.CENTER);
		add(parbauditPoga,BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ElektroniskaisTests();
	}

}
