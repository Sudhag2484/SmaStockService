package in.sudha.exception;

public class StockNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StockNotFoundException() {
		super();
	}
   public StockNotFoundException(String msg) {
		super(msg);
	}
}
