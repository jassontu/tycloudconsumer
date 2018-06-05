package ty.cloud.mq.consumer.exp;



public class BusiException extends RuntimeException {
	private static final long serialVersionUID = -1L;

	public BusiException() {
		super();
	}

	public BusiException(String message) {
		super(message);
	}

	public BusiException(String message, Throwable e) {
		super(message, e);
	}

	public BusiException(Throwable e) {
		super(e);
	}
}
