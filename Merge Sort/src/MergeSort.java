import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
		final GuiSetup gui = new GuiSetup();
		gui.btnSort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] lines = gui.inputTxtArea.getText().split("\r\n|\r|\n");
					String output = "Sorted List\n";
					for(int i =0;i<lines.length;i++){
						String[] arr = lines[i].split("\\s+");
						int[] ints = new int[arr.length];
						for (int j=0; j < arr.length; j++) {
					        ints[j] = Integer.parseInt(arr[j]);
					    }
						int[] sortedList = sort(ints);
						output = output+Arrays.toString(sortedList)+"\n";
					}
					gui.outputTextArea.setText(output);
				} catch (Exception e2) {
					gui.outputTextArea.setText("Error, wrong input format\n Enter each number sperated by a space\n And no empty Lines\n Try again");
				}
			}
		});
	}

	private static int[] sort(int value[]) {
		int leftSize = value.length / 2;
		int rightSize = value.length - leftSize;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		int totalLength = left.length + right.length;
		int i = 0;
		for (i = 0; i < leftSize; i++) {
			left[i] = value[i];
		}
		for (int j = 0; j < rightSize; j++) {
			right[j] = value[i];
			i++;
		}
		if (totalLength <= 3) {
			if (left.length == 2 && left[0] > left[1]) {
				int temp = left[0];
				left[0] = left[1];
				left[1] = temp;
			}
			if (right.length == 2 && right[0] > right[1]) {
				int temp = right[0];
				right[0] = right[1];
				right[1] = temp;
			}
		}
		if (left.length != 1 && right.length != 1) {
			left = sort(left);
			right = sort(right);
		}
		value = merge(left, right);
		return value;
	}

	private static int[] merge(int[] left, int[] right) {
		int totalLength = left.length + right.length;
		int mergedArr[] = new int[totalLength];
		int leftIndex = 0, rightIndex = 0;
		for (int i = 0; i < totalLength; ++i) {
			if (leftIndex == left.length) {
				mergedArr[i] = right[rightIndex];
				rightIndex++;
			} else if (rightIndex == right.length) {
				mergedArr[i] = left[leftIndex];
				leftIndex++;
			} else if (left[leftIndex] > right[rightIndex]) {
				mergedArr[i] = right[rightIndex];
				rightIndex++;
			} else {
				mergedArr[i] = left[leftIndex];
				leftIndex++;
			}
		}
		return mergedArr;
	}
}

class GuiSetup extends JFrame {
	private static final long serialVersionUID = 1L;
	public JTextPane inputTxtArea;
	public JTextPane outputTextArea;
	public JButton btnSort;
	public JButton btnReset;

	public GuiSetup() {
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

		JLabel headingLabel = new JLabel("Merge sort");
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

		inputTxtArea = new JTextPane();

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

		outputTextArea = new JTextPane();
		outputTextArea.setEditable(false);

		JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
		centerRightTxtArea.add(outputScrollPane);

		JPanel buttompanel = new JPanel();
		contentPane.add(buttompanel, BorderLayout.SOUTH);
		buttompanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnSort = new JButton("Sort");
		buttompanel.add(btnSort);

		btnReset = new JButton("Reset");
		buttompanel.add(btnReset);

		inputTxtArea.setText("5 6 8 9 7 8 1 0 1123 456 2 3 0 4\n6 8 5 4 5 2 0 20 1 2 4 5");
		outputTextArea.setText("Sorted List:");

		setTitle("Merge Sort");
		setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 4),
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		setVisible(true);
		setResizable(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
	}
}