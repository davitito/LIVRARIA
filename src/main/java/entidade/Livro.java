package entidade;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LIVRO")
public class Livro {

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(generator = "S_LIVRO")
	@SequenceGenerator(name = "S_LIVRO", sequenceName = "S_LIVRO", allocationSize = 1)	
	private Long id;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
	@Column(name="EDITORA", nullable = false)
	private String editora;

	@Column(name="EDICAO", nullable = false)
	private String edicao;
	
	@Column(name="AUTOR", nullable = false)
	private String autor;
	
	@Column(name="GENERO", nullable = false)
	private String genero;
	
	@Column(name="USUARIO_CPF", nullable = false)
	private String usuario_cpf;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private Livro livro;	
	

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getUsuario_cpf() {
		return usuario_cpf;
	}

	public void setUsuario_cpf(String usuario_cpf) {
		this.usuario_cpf = usuario_cpf;
	}

	
}
