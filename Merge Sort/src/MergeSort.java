import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;


public class MergeSort {
	public static void main(String[] args) {
		GuiSetup guiSetup = new GuiSetup();
	}
}
class GuiSetup extends JFrame{
	private static final long serialVersionUID = 1L;

	public GuiSetup(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			
		}
		getContentPane().setLayout(new CardLayout());
		setupGUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setupGUI() {
		
		setTitle("Merge Sort");
		setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/4),Toolkit.getDefaultToolkit().getScreenSize().height/2);
		setVisible(true);
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}