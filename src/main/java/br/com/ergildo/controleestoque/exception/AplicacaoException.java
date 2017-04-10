package br.com.ergildo.controleestoque.exception;

/**
 * @author desenv
 *
 */
public class AplicacaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param e
	 */
	public AplicacaoException(Exception e) {
		super(e);
	}

}
