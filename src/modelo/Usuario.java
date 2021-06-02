package modelo;
import daojpa.TriggerListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name="usuario20191370025")
@EntityListeners(TriggerListener.class)
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	@Version
	private int versao;
	@OneToMany(mappedBy="usuario")
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	public Usuario(){};

	public Usuario(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}
	public void remover(Visualizacao vis) {
		Iterator<Visualizacao> itr = visualizacoes.iterator();
		 while (itr.hasNext()) 
	        { 
	            Visualizacao x = (Visualizacao)itr.next(); 
	            if (x.equals(vis)) {
	                itr.remove(); 
	                break;
	            }
	        } 
	}

	@Override
	public String toString() {
		String texto =  "\nUsuario [email=" + email + "]";
		
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			texto += vis;
		}
		return texto;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (visualizacoes == null) {
			if (other.visualizacoes != null)
				return false;
		} else if (!visualizacoes.equals(other.visualizacoes))
			return false;
		return true;
	}

	
	
	
}
