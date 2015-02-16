import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
					//split new lines
					String[] lines = gui.inputTxtArea.getText().split(
							"\r\n|\r|\n");
					String output = "";
					for (int i = 0; i < lines.length; i++) {
						//split spaces between each number
						String[] arr = lines[i].split("\\s+");
						int[] ints = new int[arr.length];
						//convert string array to integer array
						for (int j = 0; j < arr.length; j++) {
							ints[j] = Integer.parseInt(arr[j]);
						}
						//sort the list
						int[] sortedList = sort(ints);
						//calculate median an d print it
						output = output + Arrays.toString(sortedList)
								+ " Median = " + round(median(sortedList))
								+ "\n";
					}
					gui.outputTextArea.setText(output);
				} catch (NumberFormatException e2) {
					gui.outputTextArea
							.setText("Error, Please remove the empty line");
				} catch (Exception e2) {
					gui.outputTextArea
							.setText("Error, wrong input format\n Enter each number sperated by a space\n And no empty Lines\n Try again");
				}
			}
		});
		gui.btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.inputTxtArea.setText("");
				gui.outputTextArea.setText("Enter you data in each line sperate by space. You can also add multiple entieres on diffrent lines. Example on the left");
			}
		});
	}

	public static double round(double value) {
		BigDecimal bigDecimal = new BigDecimal(value);
		return bigDecimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	public static double median(int[] value) {
		//check if it has odd or even amount of entries
		if (value.length % 2 == 1) {
			//Calculate the median
			return value[value.length / 2];
		} else {
			//calculate the median
			return (value[value.length / 2 - 1] + value[value.length / 2]) / 2.0;
		}
	}

	private static int[] sort(int value[]) {
		int leftSize = value.length / 2;
		int rightSize = value.length - leftSize;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		int totalLength = left.length + right.length;
		int i = 0;
		//split the array and populate the left side of the array
		for (i = 0; i < leftSize; i++) {
			left[i] = value[i];
		}
		//split the array and populate the right side of the array
		for (int j = 0; j < rightSize; j++) {
			right[j] = value[i];
			i++;
		}
		//ignore the intermediate step and only focus on the last step of the splitting process
		if (totalLength <= 3) {
			//sort the array
			//if the left array has the size of two sort that
			if (left.length == 2 && left[0] > left[1]) {
				int temp = left[0];
				left[0] = left[1];
				left[1] = temp;
			}
			//if the right array has the size of two sort that
			if (right.length == 2 && right[0] > right[1]) {
				int temp = right[0];
				right[0] = right[1];
				right[1] = temp;
			}
		}
		//call the method again and stop when the length of the array are not equal to one
		if (left.length != 1 && right.length != 1) {
			left = sort(left);
			right = sort(right);
		}
		//merge the values
		value = merge(left, right);
		return value;
	}

	private static int[] merge(int[] left, int[] right) {
		int totalLength = left.length + right.length;
		//this array will contain the sorted merged data
		int mergedArr[] = new int[totalLength];
		//Create indexes
		int leftIndex = 0, rightIndex = 0;
		//use the for loop to populate the merged array
		for (int i = 0; i < totalLength; ++i) {
			//check if it is at the end of the array if so add it to the merged array
			if (leftIndex == left.length) {
				mergedArr[i] = right[rightIndex];
				rightIndex++;
				//check if it is at the end of the array if so add it to the merged array
			} else if (rightIndex == right.length) {
				mergedArr[i] = left[leftIndex];
				leftIndex++;
				//check if the next element in the left is greater than the next element on the right. If so add the 
				//right element to the merged array
			} else if (left[leftIndex] > right[rightIndex]) {
				mergedArr[i] = right[rightIndex];
				rightIndex++;
				//exactly the same as the last else if but check for the left side
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
		outputTextArea.setText("Enter you data in each line sperate by space. You can also add multiple entieres on diffrent lines. Example on the left");
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

		inputTxtArea
				.setText("5 6 8 9 7 8 1 0 1123 456 2 3 0 4\n6 8 5 4 5 2 0 20 1 2 4 5");

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