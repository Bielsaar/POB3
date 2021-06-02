package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.*;


public class DAOUsuario extends DAO<Usuario>{

	public Usuario read (Object chave){
		try{
			String email = (String) chave;
			TypedQuery<Usuario> q = manager.createQuery("select u from Usuario u where u.email=:e", Usuario.class);
			q.setParameter("e", email);
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	
	public List<Usuario> consultarUsuarioPorVideo(String link){
		try {
			TypedQuery<Usuario> q = manager.createQuery("select u from Usuario u join u.visualizacoes vis join vis.video v where v.link=:L"
					, Usuario.class);
				q.setParameter("L", link);
				return q.getResultList();
		}catch(NoResultException e) {
			return null;
		}
		
	}
	

}
