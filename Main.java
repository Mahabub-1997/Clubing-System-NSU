package project;



import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {

		Gui a = new Gui();
 		a.setSize(700, 600);
		a.setVisible(true);
		a.setLocation(200, 100);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
