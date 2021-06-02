package aplicacaoConsole;

import fachada.Fachada;

public class Consultar {
	public Consultar() {
		try {
			Fachada.inicializar();
			
			System.out.println("Iniciando listagem...");
			System.out.println("1. Procurando visualiza��o 5: \n"+Fachada.localizarVisualizacao(5));
			System.out.println("\n2. Procurando visualiza��o 3: \n"+Fachada.localizarVisualizacao(3));
			System.out.println("\n3. Procurando usuarios pelo video 'Korone singing never gonna give you up': \n"+Fachada.consultarUsuariosPorVideo("https://www.youtube.com/watch?v=r7W-g-ohrwU"));
			System.out.println("\n4. Procurando usuarios pelo video 'Porter Robinson - Goodbye To A World (Official Audio)': \n"+Fachada.consultarUsuariosPorVideo("https://www.youtube.com/watch?v=W2TE0DjdNqI"));
			System.out.println("\n5. Procurando usuarios pelo video 'Hades: Original Soundtrack - Full Album': \n"+Fachada.consultarUsuariosPorVideo("https://www.youtube.com/watch?v=3GRKJ87S5cI"));
			System.out.println("\n6. Procurando videos pelo assunto 'Musica': \n"+Fachada.consultarVideosPorAssunto("Musica"));
			System.out.println("\n7. Procurando videos pelo assunto 'VTuber': \n"+Fachada.consultarVideosPorAssunto("VTuber"));
			System.out.println("\n8. Procurando videos pelo usuario 'eusouumsimp@weeb.com': \n"+Fachada.consultarVideosPorUsuario("eusouumsimp@weeb.com"));
			System.out.println("\n9. Procurando videos pelo usuario 'odeiomusica@weeb.com': \n"+Fachada.consultarVideosPorUsuario("odeiomusica@weeb.com"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("Fim do programa.");
	}
	
	public void consultar() {
		
	}
	
	
	//Inicializar==============================================
		public static void main(String[] args) {
			new Consultar();
		}
}
