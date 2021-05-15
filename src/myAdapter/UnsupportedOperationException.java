package myAdapter;

/***
 * Thrown to indicate that the requested operation is not supported.
 */
public class UnsupportedOperationException extends RuntimeException{

    /***
     * Constructs an UnsupportedOperationException with the specified detail message.
     * @param message the detail message.
     */
    public UnsupportedOperationException(String message) {
        super(message);
    }

    /***
     * Constructs an UnsupportedOperationException with no detail message.
     */
    public UnsupportedOperationException() { super(); }
}
