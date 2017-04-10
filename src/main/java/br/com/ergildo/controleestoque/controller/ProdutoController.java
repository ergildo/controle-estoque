package br.com.ergildo.controleestoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ergildo.controleestoque.dom.Produto;
import br.com.ergildo.controleestoque.exception.AplicacaoException;
import br.com.ergildo.controleestoque.service.ProdutoService;

/**
 * @author ergildo
 *
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoService ProdutoService;

	/**
	 * @param Produto
	 * @throws AplicacaoException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void salvar(@RequestBody Produto produto) throws AplicacaoException {
		ProdutoService.salvar(produto);
	}

	/**
	 * @return
	 * @throws AplicacaoException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Produto> listar() throws AplicacaoException {
		return ProdutoService.listar();
	}

	/**
	 * @param id
	 * @return
	 * @throws AplicacaoException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Produto consultar(@PathVariable("id") Integer id) throws AplicacaoException {
		return ProdutoService.consultar(id);
	}

	/**
	 * @param id
	 * @throws AplicacaoException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void excluir(@PathVariable("id") Integer id) throws AplicacaoException {
		Produto produto = ProdutoService.consultar(id);
		ProdutoService.excluir(produto);
	}

}
