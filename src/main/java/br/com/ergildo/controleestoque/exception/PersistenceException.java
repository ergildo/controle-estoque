package br.com.ergildo.controleestoque.exception;

/**
 * @author desenv
 *
 */
public class PersistenceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersistenceException(Exception e) {
		super(e);
	}

}
