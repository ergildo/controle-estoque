package br.com.ergildo.controleestoque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.ergildo.controleestoque.dao.ProdutoDAO;
import br.com.ergildo.controleestoque.dom.Produto;
import br.com.ergildo.controleestoque.exception.PersistenceException;


/**
 * @author desenv
 *
 */
@Repository
public class ProdutoDAOImpl implements ProdutoDAO {
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.ergildo.controleestoque.dao.DAO#salvar(java.io.Serializable)
	 */
	@Override
	public void salvar(Produto produto) throws PersistenceException {
		try {
			if (produto.getId() == null) {
				entityManager.persist(produto);
			} else {
				entityManager.merge(produto);
			}
		} catch (Exception e) {
			throw new PersistenceException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.ergildo.controleestoque.dao.DAO#consultar(java.io.Serializable)
	 */
	@Override
	public Produto consultar(Integer id) throws PersistenceException {
		try {
			return entityManager.find(Produto.class, id);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.ergildo.controleestoque.dao.DAO#excluir(java.io.Serializable)
	 */
	@Override
	public void excluir(Produto produto) throws PersistenceException {
		try {
			entityManager.remove(entityManager.merge(produto));
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.ergildo.controleestoque.dao.DAO#listar()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listar() throws PersistenceException {
		try {
			Query query = entityManager.createNamedQuery("Produto.findAll");
			return query.getResultList();
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

}
