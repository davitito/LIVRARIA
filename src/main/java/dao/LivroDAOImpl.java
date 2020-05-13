package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Livro;
import util.JpaUtil;


public class LivroDAOImpl implements LivroDAO {

	public void inserir(Livro livro) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(livro);
		
		tx.commit();
		ent.close();

	}
	
	public void alterar(Livro livro) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.merge(livro);
		
		tx.commit();
		ent.close();

	}

	public List<Livro> listarTodos() {

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Usuario l");
		
		List<Livro> livros = query.getResultList();
	
		return livros;
		
	}

	
	
	
	
	
	
	
	
	
	
}
