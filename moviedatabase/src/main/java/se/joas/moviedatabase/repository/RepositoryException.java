package se.joas.moviedatabase.repository;

public final class RepositoryException extends Exception {

    private static final long serialVersionUID = 6936005383757375126L;

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
