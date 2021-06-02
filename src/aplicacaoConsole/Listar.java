package aplicacaoConsole;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class Listar {
	public Listar(){
		try {
			Fachada.inicializar();

			
			System.out.println("Iniciando listagem...");
			System.out.println("Listagem de Videos:");
			for(Video v : Fachada.listarVideos() )		
				System.out.println(v);

			System.out.println("\nListagem de Visualizacoes:");
			for(Visualizacao visu : Fachada.listarVisualizacao())	
				System.out.println(visu);

			System.out.println("\nListagem de Usuarios:");
			for(Usuario u : Fachada.listarUsuarios())	
				System.out.println(u);
			
			System.out.println("\nListagem de Assuntos:");
			for(Assunto u : Fachada.listarAssuntos())	
				System.out.println(u);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
		System.out.println("Fim do programa.");
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}
