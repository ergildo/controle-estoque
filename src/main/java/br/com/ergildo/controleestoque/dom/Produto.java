package br.com.ergildo.controleestoque.dom;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author desenv
 *
 */
@Entity
@Table
@NamedQuery(name = "Produto.findAll", query = "select p from Produto p")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1904462211040987558L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String descricao;
	private String categoria;
	private Integer estoque;
	private BigDecimal preco;
	private Integer codBarra;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(Integer codBarra) {
		this.codBarra = codBarra;
	}

}
