package b_Money;

/**
 * Custom exception class to represent the situation where an account does not exist.
 */
public class AccountDoesNotExistException extends Exception {
	// Unique identifier for serialization
	static final long serialVersionUID = 1L;

	// Default constructor
	public AccountDoesNotExistException() {
		super("Account does not exist");
	}
}
