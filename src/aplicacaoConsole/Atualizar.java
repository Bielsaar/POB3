package aplicacaoConsole;

import fachada.Fachada;

public class Atualizar {
	public Atualizar(){
		try {
			Fachada.inicializar();
			
			System.out.println("atualizando...");
			Fachada.adicionarAssunto("https://www.youtube.com/watch?v=r7W-g-ohrwU", "VTuber");
			Fachada.adicionarAssunto("https://www.youtube.com/watch?v=r7W-g-ohrwU", "Entreternimento");
			Fachada.adicionarAssunto("https://www.youtube.com/watch?v=3GRKJ87S5cI", "Jogos");
		} 
		catch (Exception e){
			System.out.println(e.getMessage());
		} 
		finally {
			Fachada.finalizar();
		}
		System.out.println("Fim do programa.");
	}
	
	
	
	//Inicializar==============================================
		public static void main(String[] args) {
			new Atualizar();
		}
	
}
