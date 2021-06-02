package modelo;
import daojpa.TriggerListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name="video20191370025")
@Cacheable(false)
@EntityListeners(TriggerListener.class)
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String link;
	private String nome;
	private double media;
	@Version
	private int versao;
	@ManyToMany(mappedBy="videos",
			cascade={CascadeType.ALL})
	private List<Assunto> assuntos = new ArrayList<>();
	@OneToMany(mappedBy="video",
			cascade={CascadeType.ALL})
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	public Video(){};

	public Video(String link, String nome) {
		this.link = link;
		this.nome = nome;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public List<Visualizacao> getVisualizacoes() {
		return visualizacoes;
	}
	public List<Assunto> getAssuntos() {
		return this.assuntos;
	}

	public void adicionar(Assunto a) {
		assuntos.add(a);
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

	public void atualizarMedia() {
		int quant = visualizacoes.size();
		double med = 0;
		for(Visualizacao vi: visualizacoes) {
			double nota = vi.getNota();
			double aux = nota/quant;
			med += aux;;
		}
		
		this.media = med;
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (visualizacoes == null) {
			if (other.visualizacoes != null)
				return false;
		} else if (!visualizacoes.equals(other.visualizacoes))
			return false;
		return true;
	}
	@Override
	public String toString() {
		String texto = "Video:\n  [" + (link != null ? "link = " + link + ", " : "") + (nome != null ? "nome = " + nome + ", " : "")
				+ "media = " + media ;
		
		texto+=", assuntos = ";
		for(Assunto a : assuntos) {
			texto += a.getPalavra() + ", ";
		}
		texto+="\n visualizacoes => ";
		for(Visualizacao vis : visualizacoes) {
			texto += vis;
		}
		return texto;
	}

	
}
