package fachada;


import java.util.List;

import daojpa.DAO;
import daojpa.DAOAssunto;
//import daojpa.DAOIncrementalId;
import daojpa.DAOUsuario;
import daojpa.DAOVideo;
import daojpa.DAOVisualizacao;
import modelo.*;

public class Fachada {
	
	private static DAOVideo daovideo = new DAOVideo();
	private static DAOAssunto daoassunto = new DAOAssunto();
	private static DAOUsuario daousuario = new DAOUsuario();
	private static DAOVisualizacao daovisualizacao = new DAOVisualizacao();
//	private static DAOIncrementalId daoincrementalid= new DAOIncrementalId();
	
	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}
	
	
	public static Video cadastrarVideo(String link, String nome, String palavra) throws  Exception{
		DAO.begin();
		palavra.toLowerCase();
		Video vi = daovideo.read(link);
		if(vi != null) {
			DAO.rollback();
			throw new Exception("Video já cadastrado: " + link);
		}
		Assunto ass = daoassunto.read(palavra);
		if(ass == null) {
			ass = new Assunto(palavra);
			daoassunto.create(ass);
		}
		vi = new Video(link, nome);
		vi.adicionar(ass);
		daovideo.create(vi);
		
		ass = daoassunto.read(palavra);
		ass.adicionar(vi);
		daoassunto.update(ass);
		
		DAO.commit();
		return vi;
		
	}
	
	public static void adicionarAssunto(String link, String palavra) throws  Exception{
		DAO.begin();
		palavra.toLowerCase();
		Video vi = daovideo.read(link);
		if(vi == null) {
			DAO.rollback();
			throw new Exception("Video não cadastrado: " + link);
		}
		Assunto ass = daoassunto.read(palavra);
		if(ass == null) {
			daoassunto.create(new Assunto(palavra));
		} else {
			List<Assunto> assus = vi.getAssuntos();
			for (Assunto a: assus) {
				if (a.getPalavra() == palavra) {
					DAO.rollback();
					throw new Exception("Video já contem esse assunto! -> " + palavra);
				}
			}
		}
		
		ass = daoassunto.read(palavra);
		vi.adicionar(ass);
		daovideo.update(vi);
		
		ass.adicionar(vi);
		daoassunto.update(ass);
		
		DAO.commit();
	}
	
	public static Visualizacao registrarVisualizacao(String link, String email, int nota) throws  Exception{
		DAO.begin();
		
		if(nota > 5 || nota < 1) {
			DAO.rollback();
			throw new Exception("Por favor, pôr uma nota entre 1 e 5!" );
		}
		
		Video vi = daovideo.read(link);
		if(vi == null) {
			DAO.rollback();
			throw new Exception("Video não existe: " + link);
		}
		Usuario us = daousuario.read(email);
		if(us == null) {
			Usuario us2 = new Usuario(email);
			daousuario.create(us2);
		}
		us = daousuario.read(email);

		//Id antigo que não será mais utilizado
//		IncrementalId counter = (IncrementalId) daoincrementalid.resgatar();
//		if(counter == null) {
//			counter = new IncrementalId();
//			daoincrementalid.create(counter);
//		}
//		counter = (IncrementalId) daoincrementalid.resgatar();
//		int id = counter.incrementAndGet();
//		daoincrementalid.update(counter);
		
		Visualizacao visu = new Visualizacao(nota, us, vi);
		daovisualizacao.create(visu);
		us.adicionar(visu);
		daousuario.update(us);
		vi.adicionar(visu);
		vi.atualizarMedia();
		daovideo.update(vi);
		DAO.commit();
		return visu;
	}
	
	public static Visualizacao localizarVisualizacao(int id) {
		return daovisualizacao.read(id);
	}
	
	public static void apagarVisualizacao(int id) throws  Exception{
		DAO.begin();
		Visualizacao vi = daovisualizacao.read(id);
		if (vi==null) {
			DAO.rollback();
			throw new Exception("Visualização inexistente:" + id);
		}
		Video v = vi.getVideo();
		Usuario us = vi.getUsuario();
		
		v.remover(vi);
		us.remover(vi);

		daovideo.update(v);
		daousuario.update(us);
		daovisualizacao.delete(vi);
		DAO.commit();
	}
	
	public static List<Video> listarVideos() {
		return daovideo.readAll();
	}
	
	public static List<Visualizacao> listarVisualizacao() {
		return daovisualizacao.readAll();
	}
	
	public static List<Usuario> listarUsuarios() {
		return daousuario.readAll();
	}
	public static List<Assunto> listarAssuntos() {
		return daoassunto.readAll();
	}
	
	public static List<Video> consultarVideosPorAssunto(String palavra) throws Exception {
		if (palavra.isEmpty() || palavra == "") {
			throw new Exception("É necessario preencher com algum assunto!");
		}
		palavra.toLowerCase();
		List<Video> aux = daovideo.consultarVideosPorAssunto(palavra);
		if (aux == null) {
			throw new Exception("Não tem videos com esse assunto");
		} else {
			return aux;
		}
		
	}
	
	public static List<Video> consultarVideosPorUsuario(String email) throws Exception {
		if (email.isEmpty() || email == "") {
			throw new Exception("É necessario preencher com algum email!");
		}
		List<Video> aux = daovideo.consultarVideosPorUsuario(email);
		if (aux == null) {
			throw new Exception("Não tem videos com esse email");
		} else {
			return aux;
		}
	}
	
	public static List<Usuario> consultarUsuariosPorVideo(String link) throws Exception {
		if (link.isEmpty() || link == "") {
			throw new Exception("É necessario preencher com algum email!");
		}
		List<Usuario> aux = daousuario.consultarUsuarioPorVideo(link);
		if (aux == null) {
			throw new Exception("Não tem videos com esse email");
		} else {
			return aux;
		}
	}
	
}
