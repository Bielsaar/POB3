package aplicacaoSwing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;

import modelo.Usuario;

public class TelaListar {

	private JFrame frmListar;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					TelaListar window = new TelaListar();
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
	public TelaListar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListar = new JFrame();
		frmListar.setTitle("Listar");
		frmListar.setBounds(100, 100, 505, 323);
		frmListar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListar.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 33, 409, 116);
		frmListar.getContentPane().add(scrollPane);

		table = new JTable();
	
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.YELLOW);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"", "", ""}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		button = new JButton("Listar Usuarios");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Email do usuario");


					List<Usuario> lista = Fachada.listarUsuarios();
					for(Usuario p : lista)
						model.addRow(new Object[]{ p.getEmail()});

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmListar,erro.getMessage());
				}
			}
		});
		button.setBounds(44, 172, 200, 23);
		frmListar.getContentPane().add(button);

		frmListar.setVisible(true);
	}
}
