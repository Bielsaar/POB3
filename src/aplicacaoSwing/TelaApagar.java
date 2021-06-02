package aplicacaoSwing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fachada.Fachada;

public class TelaApagar {
	private JFrame frame;
	private JLabel label_2;
	private JTextField textField;
	private JButton button;
	private final ButtonGroup grupo = new ButtonGroup();
	private JLabel label;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					TelaCadastrar window = new TelaCadastrar();
	//					window.frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the application.
	 */
	public TelaApagar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setTitle("Apagar");
		frame.setBounds(100, 100, 263, 211);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		label_2 = new JLabel("");
		label_2.setBounds(10, 147, 227, 14);
		frame.getContentPane().add(label_2);

		textField = new JTextField();
		textField.setBounds(63, 50, 121, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		button = new JButton("Apagar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int termo = Integer.parseInt(textField.getText());
					Fachada.apagarVisualizacao(termo);
					
					textField.setText("");
					label_2.setText("exclus�o realizada");
				}
				catch(Exception e) {
					label_2.setText(e.getMessage());
				}
			}
		});
		button.setBounds(69, 94, 108, 23);
		frame.getContentPane().add(button);
		
		label = new JLabel("Id da visualizacao");
		label.setBounds(63, 25, 152, 14);
		frame.getContentPane().add(label);

		frame.setVisible(true);
	}
}
