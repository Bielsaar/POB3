package aplicacaoSwing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class TelaConsultar {

	private JFrame frmConsultar;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button_2;
	private JButton button_3;
	private JButton button;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnListarReunioesPor;
	private JTextField textField_3;
	private String aux = "";
	private List<Assunto> aux2;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					TelaConsultar window = new TelaConsultar();
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
	public TelaConsultar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultar = new JFrame();
		frmConsultar.setTitle("Consultar");
		frmConsultar.setBounds(100, 100, 505, 323);
		frmConsultar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultar.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 21, 409, 116);
		frmConsultar.getContentPane().add(scrollPane);

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
				new String[] {"", ""}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		button_2 = new JButton("Listar videos por assuntos");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nome");
					model.addColumn("Link");
					model.addColumn("Media");
					model.addColumn("Assuntos");

					List<Video> lista = Fachada.consultarVideosPorAssunto(textField.getText());
					for(Video p : lista) {
							aux2 = p.getAssuntos();
							for(Assunto a: aux2 ) {
								aux += a.getPalavra()+", ";
							}
							model.addRow(new Object[]{ p.getNome(),p.getLink(),p.getMedia(),aux });
							aux = "";
					}
					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmConsultar,erro.getMessage());
				}
			}
		});
		button_2.setBounds(44, 148, 237, 23);
		frmConsultar.getContentPane().add(button_2);

		button_3 = new JButton("Listar videos por usuarios");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3.setHorizontalAlignment(SwingConstants.LEFT);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nome");
					model.addColumn("Link");
					model.addColumn("Media");
					model.addColumn("Assuntos");


					List<Video> lista = Fachada.consultarVideosPorUsuario(textField_1.getText());
					for(Video p : lista) {
						aux2 = p.getAssuntos();
						for(Assunto a: aux2 ) {
							aux += a.getPalavra()+", ";
						}
						model.addRow(new Object[]{ p.getNome(),p.getLink(),p.getMedia(),aux });
						aux = "";
					}
						

					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmConsultar,erro.getMessage());
				}
			}
		});
		button_3.setBounds(44, 182, 237, 23);
		frmConsultar.getContentPane().add(button_3);

		button = new JButton("Localizar Visualizacao");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Id");
					model.addColumn("Hora");
					model.addColumn("Nota");
					model.addColumn("Usuario");
					model.addColumn("Video");
					model.addColumn("Versão");
					//					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					//					table.getColumnModel().getColumn(1).setPreferredWidth(10);

					int n = Integer.parseInt(textField_2.getText());
					Visualizacao visu= Fachada.localizarVisualizacao(n);
					model.addRow(new Object[]{ visu.getId(),visu.getDatahora(),visu.getNota(),visu.getUsuario(), visu.getVideo().getLink(), visu.getVersao() });
							

					table.setModel(model);
				}
				catch(NumberFormatException erro){
					JOptionPane.showMessageDialog(frmConsultar,"digite somente numero");
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmConsultar,erro.getMessage());
				}
			}
		});
		button.setBounds(44, 249, 237, 23);
		frmConsultar.getContentPane().add(button);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(301, 150, 86, 20);
		frmConsultar.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(301, 184, 86, 20);
		frmConsultar.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(301, 250, 35, 20);
		frmConsultar.getContentPane().add(textField_2);

		btnListarReunioesPor = new JButton("Listar usuarios por videos");
		btnListarReunioesPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Usuarios");
				
					

					List<Usuario> lista = Fachada.consultarUsuariosPorVideo(textField_3.getText());
					for(Usuario r : lista) {
						model.addRow(new String[]{r.getEmail()});
					}
					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frmConsultar,erro.getMessage());
				}

			}
		});
		btnListarReunioesPor.setHorizontalAlignment(SwingConstants.LEFT);
		btnListarReunioesPor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListarReunioesPor.setBounds(44, 215, 237, 23);
		frmConsultar.getContentPane().add(btnListarReunioesPor);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(301, 217, 86, 20);
		frmConsultar.getContentPane().add(textField_3);

		frmConsultar.setVisible(true);
	}
}
