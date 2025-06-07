import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
	String[] jautajumi = {
	        "1. Kas notiks, ja izpildīsies šis kods: if (5 > 3) System.out.println(\"A\"); else System.out.println(\"B\");",
	        
	        "2. Kāds būs rezultāts šim kodam?\nint x = 10;"
	        + "\nif (x > 5) {"
	        + "\n    if (x < 15) {"
	        + "\n        System.out.println(\"Mazāks\");"
	        + "\n    }"
	        + "\n} else {"
	        + "\n    System.out.println(\"Vēl mazāks\");\n}",
	        
	        "3. Kā pareizi apvienot divus nosacījumus ar loģisko operatoru UN?",
	        
	        "4. Kāda ir switch-case konstrukcijas galvenā priekšrocība salīdzinājumā ar if-else?",
	        
	        "5. Kāds būs rezultāts triskāršo operatora izteiksmei: int result = (8 > 5) ? 100 : 200;",
	        
	        "6. Kas notiks šajā switch blokā?"
	        + "\nint day = 2;"
	        + "\nswitch(day) {"
	        + "\n    case 1: System.out.println(\"Pirmdiena\");"
	        + "\n    case 2: System.out.println(\"Otrdiena\");"
	        + "\n    case 3: System.out.println(\"Trešdiena\");\n}",
	        "7. Kā pareizi rakstīt default bloku switch konstrukcijā?",
	        
	        "8. Kāds būs šī koda rezultāts?"
	        + "\nboolean a = true, b = false;"
	        + "\nif (a || b) {"
	        + "\n    System.out.println(\"Patiess\");"
	        + "\n} else {"
	        + "\n    System.out.println(\"Nepatiess\");"
	        + "\n}",
	        
	        "9. Kā var apvienot vairākus case vienā izpildes blokā?",
	        
	        "10. Kāds būs rezultāts sarežģītai triskāršai izteiksmei?\nint a = 3, b = 7, c = 5;"
	        + "\nint max = (a > b) ? (a > c ? a : c) : (b > c ? b : c);"
	    };
	
    String[][] atbilzuVarianti = {
            {"a) Izprintēs \"A\"", "b) Izprintēs \"B\"", "c) Compile error", "d) Nekas netiks izprintēts"},
            
            {"a) Vēl mazāks", "b) Mazāks", "c) Compile error", "d) Nekas netiks izprintēts"},
            
            {"a) if (x > 5 AND y < 10)", "b) if (x > 5 && y < 10)", "c) if (x > 5 & y < 10)", "d) if (x > 5 || y < 10)"},
            
            {"a) Ātrāka izpilde vairākiem nosacījumiem", "b) Mazāka koda rakstīšana", "c) Vieglāk salasāms", "d) Visas minētās atbildes"},
            
            {"a) 100", "b) 200", "c) 8", "d) 5"},
            
            {"a) Tikai \"Otrdiena\"", "b) \"Otrdiena\" un \"Trešdiena\"", "c) Tikai \"Trešdiena\"", "d) Compile error"},
            
            {"a) default:", "b) case default:", "c) else:", "d) otherwise:"},
            
            {"a) Patiess", "b) Nepatiess", "c) Compile error", "d) Runtime error"},
            
            {"a) case 1, 2, 3:", "b) case 1: case 2: case 3:", "c) case 1 | 2 | 3:", "d) case (1,2,3):"},
            
            {"a) 3", "b) 5", "c) 7", "d) Compile error"}
        };
	
    char[] pareizasAtbildes = {'a', 'b', 'b', 'd', 'a', 'a', 'a', 'a', 'b', 'c'};
    int jautajumuIndekss = 0;
    
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
		for(int i =0; i < 4; i++) {
			atbilzuPogas[i] = new JRadioButton("Atbildes variants " + i+1);
			atbilzuPogas[i].setFont(new Font("Arial", Font.PLAIN, 14));
			poguGrupa.add(atbilzuPogas[i]);
			atbilzuLogs.add(atbilzuPogas[i]);
		}
		parbauditPoga = new JButton("Pārbaudīt atbildi");
		parbauditPoga.setFont(new Font("Arial", Font.BOLD, 14));
		
		add(atbilzuLogs,BorderLayout.CENTER);
		add(parbauditPoga,BorderLayout.SOUTH);
		parbauditPoga.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parbauditAtbildi();
			}
		});
		saktTestu();
		setVisible(true);
	}
	
	void saktTestu() {
		jautajumuLauks.setText(jautajumi[jautajumuIndekss]);
		for(int i = 0; i < 4; i++) {
			atbilzuPogas[i].setText(atbilzuVarianti[jautajumuIndekss][i]);
		}
	}
	
	void parbauditAtbildi() {
		int izvelesIndekss = -1;
		for(int i= 0; i < 4; i++) {
			if(atbilzuPogas[i].isSelected()) {
				izvelesIndekss = i;
				break;
			}
		}
		if(izvelesIndekss == -1) JOptionPane.showMessageDialog(this, "Lūdzu izvēlies atbildi!", "Kļūda", JOptionPane.ERROR_MESSAGE);
		
		char izveletaAtbilde = (char)('a' + izvelesIndekss); //Palīdzība ņemta no ChatGPT un ar ASCII palīdzību, indekss maina atbildes variantus līdz d
		if(izveletaAtbilde == pareizasAtbildes[jautajumuIndekss]) {
			JOptionPane.showMessageDialog(this, "Pareizi!", "Apsveicu!", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "Nepareizi!", "Mēģini vēlreiz!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		new ElektroniskaisTests();
	}

}
