import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;


public class TEst extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TEst frame = new TEst();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TEst() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "name_2688877728895085");
		
		JPanel inputTab = new JPanel();
		tabbedPane.addTab("Input", null, inputTab, null);
		inputTab.setLayout(new CardLayout(0, 0));
		
		JPanel inputbodyPane = new JPanel();
		inputTab.add(inputbodyPane, "name_2689381137107681");
		inputbodyPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInputYourData = new JLabel("Input Your Data below");
		lblInputYourData.setBackground(Color.WHITE);
		lblInputYourData.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblInputYourData.setHorizontalAlignment(SwingConstants.CENTER);
		inputbodyPane.add(lblInputYourData);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputbodyPane.add(editorPane);
		
		JPanel panel = new JPanel();
		inputbodyPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton, BorderLayout.SOUTH);
		
		JPanel outputTab = new JPanel();
		tabbedPane.addTab("Output", null, outputTab, null);
	}

}
