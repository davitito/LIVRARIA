package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Usuario;

import dao.LivroDAO;
import dao.LivroDAOImpl;
import entidade.Livro;


@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {

	private String txtUsuario;
	private String txtSenha;

	private List<Usuario> listaUsuarios;
	private Usuario usuario; 
	private String msgCadastroUsuario;
	
	private UsuarioDAO usuarioDAO;
	
	private List<Livro> listaLivros;
	private Livro livro; 
	private String msgCadastroLivro;
	
	private LivroDAO livroDAO;


	public LoginBean() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuario = new Usuario();
		this.usuarioDAO = new UsuarioDAOImpl();
		
		this.listaLivros = new ArrayList<Livro>();
		this.livro = new Livro();
		this.livroDAO = new LivroDAOImpl();
	}

	public void entrar() throws IOException {

		boolean achou = false;

		this.listaUsuarios = this.usuarioDAO.listarTodos();
		
		System.out.println(" lista usuario " + listaUsuarios);
		
	
		for (Usuario usuarioPesquisa : listaUsuarios) {

			if (usuarioPesquisa.getCpf().equals(this.txtUsuario) && usuarioPesquisa.getSenha().equals(this.txtSenha)) {

				achou = true;
			}
		}

		if(achou) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("livraria.xhtml");
		}else {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Não existe usuário!!!"));
		}

	}
	
	public void editarLivro() {
		
	}
	
	public void criarLivro() throws IOException {

		Livro novo = new Livro();

		novo.setNome(this.livro.getNome());
		novo.setEditora(this.livro.getEditora());
		novo.setEdicao(this.livro.getEdicao());
		novo.setAutor(this.livro.getAutor());
		novo.setGenero(this.livro.getGenero());	

		boolean achou = false;

		this.listaLivros = this.livroDAO.listarTodos();
		
		for (Livro livroPesquisa : listaLivros) {
			if (livroPesquisa.getNome().equals(this.livro.getNome())) {
				achou = true;
			}
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Livro já existe!!!"));
		}else {
			this.livroDAO.inserir(novo);
			this.livro = new Livro();
		}
	}
	
	public void criarUsuario() {

		Usuario novo = new Usuario();

		novo.setNome(this.usuario.getNome());
		novo.setCpf(this.usuario.getCpf());
		novo.setSenha(this.usuario.getSenha());

		boolean achou = false;
		
		this.listaUsuarios = this.usuarioDAO.listarTodos();
		
		for (Usuario usuarioPesquisa : listaUsuarios) {
			if (usuarioPesquisa.getCpf().equals(this.usuario.getCpf())) {
				achou = true;
			}
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario já existe!!!"));
		}else {
			this.usuarioDAO.inserir(novo);
			this.usuario = new Usuario();	
		}
	}
	
	

	public List<Livro> getListaLivros() {
		return listaLivros;
	}

	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getMsgCadastroLivro() {
		return msgCadastroLivro;
	}

	public void setMsgCadastroLivro(String msgCadastroLivro) {
		this.msgCadastroLivro = msgCadastroLivro;
	}

	public LivroDAO getLivroDAO() {
		return livroDAO;
	}

	public void setLivroDAO(LivroDAO livroDAO) {
		this.livroDAO = livroDAO;
	}

	public String getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(String txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public String getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMsgCadastroUsuario() {
		return msgCadastroUsuario;
	}

	public void setMsgCadastroUsuario(String msgCadastroUsuario) {
		this.msgCadastroUsuario = msgCadastroUsuario;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}
