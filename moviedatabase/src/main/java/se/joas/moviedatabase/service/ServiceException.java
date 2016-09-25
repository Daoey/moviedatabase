package se.joas.moviedatabase.service;

public final class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 7945507566147330018L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
