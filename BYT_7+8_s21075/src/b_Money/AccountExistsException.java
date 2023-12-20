package b_Money;

/**
 * Custom exception class to represent the situation where an account already exists.
 */
public class AccountExistsException extends Exception {
	// Unique identifier for serialization
	static final long serialVersionUID = 1L;

	/**
	 * Default constructor with a default error message.
	 */
	public AccountExistsException() {
		super("Account already exists");
	}
}
