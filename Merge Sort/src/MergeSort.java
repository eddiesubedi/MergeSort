import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


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
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel headingLabel = new JLabel("New label");
		headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(headingLabel, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel centerLeftPanel = new JPanel();
		centerPanel.add(centerLeftPanel);
		centerLeftPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerLeftLabelPanel = new JPanel();
		centerLeftPanel.add(centerLeftLabelPanel, BorderLayout.NORTH);
		
		JLabel inputlabel = new JLabel("Input");
		centerLeftLabelPanel.add(inputlabel);
		
		JPanel centerRightTxtPanel = new JPanel();
		centerLeftPanel.add(centerRightTxtPanel, BorderLayout.CENTER);
		centerRightTxtPanel.setLayout(new CardLayout(0, 0));
		
		JTextPane inputTxtArea = new JTextPane();
		
		JScrollPane inputScrollPane = new JScrollPane(inputTxtArea);
		centerRightTxtPanel.add(inputScrollPane);
		
		JPanel centerRightPanel = new JPanel();
		centerPanel.add(centerRightPanel);
		centerRightPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerRightLabelPanel = new JPanel();
		centerRightPanel.add(centerRightLabelPanel, BorderLayout.NORTH);
		
		JLabel outputlabel = new JLabel("Output");
		centerRightLabelPanel.add(outputlabel);
		
		JPanel centerRightTxtArea = new JPanel();
		centerRightPanel.add(centerRightTxtArea, BorderLayout.CENTER);
		centerRightTxtArea.setLayout(new CardLayout(0, 0));
		
		JTextPane outputTextArea = new JTextPane();
		
		JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
		centerRightTxtArea.add(outputScrollPane);
		
		JPanel buttompanel = new JPanel();
		contentPane.add(buttompanel, BorderLayout.SOUTH);
		buttompanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSort = new JButton("Sort");
		buttompanel.add(btnSort);
		
		JButton btnReset = new JButton("Reset");
		buttompanel.add(btnReset);
		
		setTitle("Merge Sort");
		setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/4),Toolkit.getDefaultToolkit().getScreenSize().height/2);
		setVisible(true);
		setResizable(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}