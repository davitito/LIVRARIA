package dao;

import java.util.List;
import entidade.Livro;

public interface LivroDAO {
	
	public void inserir(Livro livro);
	
	public void alterar(Livro livro);

	public List<Livro> listarTodos();

}
