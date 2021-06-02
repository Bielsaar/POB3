package modelo;

import daojpa.TriggerListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@EntityListeners(TriggerListener.class)
@Table(name="visualizacao20191370025")
@Cacheable(false)
public class Visualizacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int nota;
	@Version
	private int versao;
	@Column(columnDefinition = "DATE")
	private LocalDate datahora = LocalDate.now();
	@Transient
	private int idade;
	@ManyToOne(cascade={CascadeType.ALL})
	private Usuario usuario;
	@ManyToOne(cascade={CascadeType.ALL})
	private Video video;

	public Visualizacao(){};
	
	public Visualizacao(int nota, Usuario usuario, Video video) {
		this.nota = nota;
		this.usuario = usuario;
		this.video = video;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {this.id = id; }

	public LocalDate getDatahora() {
		return datahora;
	}

	public int getNota() {
		return this.nota;
	}
	
	public Video getVideo() {
		return this.video;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int newIdade) {
		this.idade = newIdade;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}

	@Override
	public String toString() {
		return "[id=" + id +
				", datahora=" + datahora.toString() +
				", nota=" + nota +
				", idade=" + idade +
				"\n usuario=" + usuario.getEmail() + ", video=" + video.getNome() + "]";
	}






}
