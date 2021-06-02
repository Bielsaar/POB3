package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Video;
import modelo.Visualizacao;

public class DAOVideo extends DAO<Video> {
	
	private DAOAssunto daoAssunto = new DAOAssunto();
	private DAOUsuario daoUsuario = new DAOUsuario();
	private static DAOVideo daoVideo = new DAOVideo();
	private static DAOVisualizacao daoVisualizacao = new DAOVisualizacao();
	
	public Video read (Object chave){
		try{
			String link = (String) chave;
			TypedQuery<Video> q = manager.createQuery("select v from Video v where v.link=:l", Video.class);
			q.setParameter("l", link);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<Video> consultarVideosPorAssunto(String assunto){
		try {
			TypedQuery<Video> q = manager.createQuery("select v from Video v join v.assuntos a where a.palavra=:A"
					, Video.class);
				q.setParameter("A", assunto);
				return q.getResultList();
		}catch(NoResultException e) {
			return null;
		}
		
	}

	
	public List<Video> consultarVideosPorUsuario(String email){
		try {
			TypedQuery<Video> q = manager.createQuery("select v from Video v join v.visualizacoes vis join vis.usuario u where u.email=:E"
					, Video.class);				
				q.setParameter("E", email);
				return q.getResultList();
		}catch(NoResultException e) {
			return null;
		}
		
	}

}
