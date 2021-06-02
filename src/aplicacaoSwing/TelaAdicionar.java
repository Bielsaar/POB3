package aplicacaoSwing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class TelaAdicionar {
	private JFrame frame;
	private JLabel label;
	private JLabel label_2;
	private JTextField textField;
	private JButton button;
	private JTextField textField_2;

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
	public TelaAdicionar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setTitle("Add Assunto");
		frame.setBounds(100, 100, 263, 211);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("assunto:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 51, 71, 14);
		frame.getContentPane().add(label);
		
		label_2 = new JLabel("");
		label_2.setBounds(10, 147, 227, 14);
		frame.getContentPane().add(label_2);
		
		label = new JLabel("link:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 26, 71, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(91, 23, 121, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		button = new JButton("Cadastrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String link = textField.getText();
					String palavra = textField_2.getText();
					Fachada.adicionarAssunto(link, palavra);
					textField.setText("");
					textField_2.setText("");
					label_2.setText("cadastro realizado");
				}
				catch(Exception e) {
					label_2.setText(e.getMessage());
				}
			}
		});
		button.setBounds(69, 126, 108, 23);
		frame.getContentPane().add(button);
		
		textField_2 = new JTextField();
		textField_2.setBounds(91, 51, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		frame.setVisible(true);
	}
}
