package aplicacaoConsole;

import fachada.Fachada;
import modelo.Video;
import modelo.Visualizacao;

public class Cadastrar {
	public Cadastrar(){
		try {
			Fachada.inicializar();
			
			System.out.println("cadastrando...");
			Video v;
			v = Fachada.cadastrarVideo("https://www.youtube.com/watch?v=r7W-g-ohrwU", "Korone singing never gonna give you up", "Musica");
			v = Fachada.cadastrarVideo("https://www.youtube.com/watch?v=Kg-PkgSdHkU", "Porter Robinson - Musician (Official Audio)", "Musica");
			v = Fachada.cadastrarVideo("https://www.youtube.com/watch?v=W2TE0DjdNqI", "Porter Robinson - Goodbye To A World (Official Audio)", "Musica");
//			v = Fachada.cadastrarVideo("https://www.youtube.com/watch?v=3GRKJ87S5cI", "Hades: Original Soundtrack - Full Album", "Musica");
			
			
			
			Visualizacao vi;
			vi = Fachada.registrarVisualizacao("https://www.youtube.com/watch?v=r7W-g-ohrwU", "eusouumsimp@weeb.com", 5);
			vi = Fachada.registrarVisualizacao("https://www.youtube.com/watch?v=r7W-g-ohrwU", "eusouumsimp@weeb.com", 5);
			vi = Fachada.registrarVisualizacao("https://www.youtube.com/watch?v=r7W-g-ohrwU", "odeiovtuber@weeb.com", 2);
			vi = Fachada.registrarVisualizacao("https://www.youtube.com/watch?v=3GRKJ87S5cI", "musicaboa@weeb.com", 4);
			vi = Fachada.registrarVisualizacao("https://www.youtube.com/watch?v=Kg-PkgSdHkU", "musicaboa@weeb.com", 5);
			vi = Fachada.registrarVisualizacao("https://www.youtube.com/watch?v=Kg-PkgSdHkU", "odeiomusica@weeb.com", 1);
			vi = Fachada.registrarVisualizacao("https://www.youtube.com/watch?v=W2TE0DjdNqI", "odeiomusica@weeb.com", 3);
			
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");

	}
	
	public void cadastrar(){

	}	


	//Inicializar==============================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}
	
