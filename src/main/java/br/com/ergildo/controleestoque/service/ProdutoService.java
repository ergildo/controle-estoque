package br.com.ergildo.controleestoque.service;

import java.util.List;

import br.com.ergildo.controleestoque.dom.Produto;
import br.com.ergildo.controleestoque.exception.AplicacaoException;


/**
 * @author desenv
 *
 */
public interface ProdutoService {
	/**
	 * @param Produto
	 * @throws AplicacaoException
	 */
	public void salvar(Produto Produto) throws AplicacaoException;

	/**
	 * @param id
	 * @return
	 * @throws AplicacaoException
	 */
	public Produto consultar(Integer id) throws AplicacaoException;

	/**
	 * @param Produto
	 * @throws AplicacaoException
	 */
	public void excluir(Produto Produto) throws AplicacaoException;

	/**
	 * @return
	 * @throws AplicacaoException
	 */
	public List<Produto> listar() throws AplicacaoException;
}
