package es.uniovi.asw.voter.application.exception;

public class AlredyVotedException  extends Exception {
	
	private static final long serialVersionUID = 1L;

	public AlredyVotedException() {
	}

	public AlredyVotedException(String message) {
		super(message);
	}

	public AlredyVotedException(Throwable cause) {
		super(cause);
	}

	public AlredyVotedException(String message, Throwable cause) {
		super(message, cause);
	}

}

