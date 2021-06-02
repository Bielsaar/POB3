package modelo;
import daojpa.TriggerListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="assunto20191370025")
@Cacheable(false)
@EntityListeners(TriggerListener.class)
public class Assunto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String palavra;
	@Version
	private int versao;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Video> videos = new ArrayList<>();

	public Assunto(){};
	
	public Assunto(String palavra) {
		this.palavra = palavra;
	}

	
	public String getPalavra() {
		return palavra;
	}

	public void adicionar(Video v) {
		videos.add(v);
	}
	
	@Override
	public String toString() {
		String texto = "Assunto [palavra=" + palavra;
		for(Video v : videos) {
			texto += v.getNome();
		}
		return texto;
	}
	
	
	
}
