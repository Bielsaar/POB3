package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.*;
public class DAOVisualizacao extends DAO<Visualizacao> {
	
	private static DAOUsuario daoUsuario = new DAOUsuario();
	
	public Visualizacao read (Object chave){
		try{
			int id = (int) chave;
			TypedQuery<Visualizacao> q = manager.createQuery("select vi from Visualizacao vi where vi.id=:i", Visualizacao.class);
			q.setParameter("i", id);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<Visualizacao> readAll(){
		TypedQuery<Visualizacao> q = manager.createQuery("select vi from Visualizacao vi order by vi.id", Visualizacao.class);
		return q.getResultList();
	}

}
