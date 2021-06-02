package aplicacaoSwing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class TelaPrincipal {

	private JFrame frame;
	private JMenu mnConsulta;
	private JMenu mnUsuario;
	private JMenu mnVideo;
	private JMenuItem mntmCadastrarPessoa;
	private JMenuItem mntmListarPessoa;
	private JMenuItem mntmListarTelefone;
	private JLabel label;
	private JMenu mnPessoa_1;
	private JMenuItem mntmCadastrarPessoa_1;
	private JMenuItem mntmListarPessoa_1;
	private JMenuItem mntmCadastrarVisuali;
	private JMenuItem mntmApagarVisuali;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

				Fachada.inicializar();

				frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(frame, "banco fechado !");
			}
		});
		frame.setTitle("YouBanco");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("Inicializando...");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(label);
		frame.setResizable(false);


		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		mnVideo = new JMenu("Video");
		menuBar.add(mnVideo);

		mntmCadastrarPessoa = new JMenuItem("Cadastrar");
		mntmCadastrarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrar tela = new TelaCadastrar();
			}
		});
		mnVideo.add(mntmCadastrarPessoa);


		mntmListarPessoa = new JMenuItem("Listar");
		mntmListarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarVideo tela = new TelaListarVideo();
			}
		});
		mnVideo.add(mntmListarPessoa);
		
		mntmCadastrarVisuali = new JMenuItem("Add Visualizacao");
		mntmCadastrarVisuali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAddVisualizacao tela = new TelaAddVisualizacao();
			}
		});
		mnVideo.add(mntmCadastrarVisuali);
		
		mntmApagarVisuali = new JMenuItem("Apagar Visualizacao");
		mntmApagarVisuali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaApagar tele = new TelaApagar();
			}
		});
		mnVideo.add(mntmApagarVisuali);

		//-----------------------------------------------------------------
		mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);


		mntmListarTelefone = new JMenuItem("Listar");
		mntmListarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListar tela = new TelaListar();
			}
		});
		mnUsuario.add(mntmListarTelefone);


		mnConsulta = new JMenu("Consultas");
		menuBar.add(mnConsulta);
		
		mnPessoa_1 = new JMenu("Assunto");
		menuBar.add(mnPessoa_1);
		
		mntmCadastrarPessoa_1 = new JMenuItem("Adicionar");
		mntmCadastrarPessoa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdicionar tela = new TelaAdicionar();
			}
		});
		mnPessoa_1.add(mntmCadastrarPessoa_1);
		
		mntmListarPessoa_1 = new JMenuItem("Listar");
		mntmListarPessoa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarAssuntos tela = new TelaListarAssuntos();
			}
		});
		mnPessoa_1.add(mntmListarPessoa_1);
		mnConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaConsultar tela = new TelaConsultar();
			}
		});

	}
}
