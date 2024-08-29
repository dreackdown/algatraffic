package dev.hugofaria.algatransito.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException {

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}