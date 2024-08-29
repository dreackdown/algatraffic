package dev.hugofaria.algatransito.domain.exception;

public class NegocioException extends RuntimeException{

    public NegocioException(String message) {
        super(message);
    }
}