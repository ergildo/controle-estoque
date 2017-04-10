package br.com.ergildo.controleestoque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ergildo.controleestoque.dao.ProdutoDAO;
import br.com.ergildo.controleestoque.dom.Produto;
import br.com.ergildo.controleestoque.exception.AplicacaoException;
import br.com.ergildo.controleestoque.exception.PersistenceException;
import br.com.ergildo.controleestoque.service.ProdutoService;

/**
 * @author desenv
 *
 */
@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {
	@Autowired
	private ProdutoDAO ProdutoDAO;

	/**
	 * @param Produto
	 * @throws AplicacaoException
	 */
	@Override
	public void salvar(Produto produto) throws AplicacaoException {
		try {
			ProdutoDAO.salvar(produto);
		} catch (PersistenceException e) {
			throw new AplicacaoException(e);
		}
	}

	/**
	 * @param id
	 * @return
	 * @throws AplicacaoException
	 */
	@Override
	public Produto consultar(Integer id) throws AplicacaoException {
		try {
			return ProdutoDAO.consultar(id);
		} catch (PersistenceException e) {
			throw new AplicacaoException(e);
		}
	}

	/**
	 * @param Produto
	 * @throws AplicacaoException
	 */
	@Override
	public void excluir(Produto produto) throws AplicacaoException {
		try {
			ProdutoDAO.excluir(produto);
		} catch (PersistenceException e) {
			throw new AplicacaoException(e);
		}

	}

	/**
	 * @return
	 * @throws AplicacaoException
	 */
	@Override
	public List<Produto> listar() throws AplicacaoException {
		try {
			return ProdutoDAO.listar();
		} catch (PersistenceException e) {
			throw new AplicacaoException(e);
		}
	}

}
