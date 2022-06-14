package com.camilla.service.exception;

public class ParticipanteNaoEncontradoException extends RuntimeException {
    public ParticipanteNaoEncontradoException(Long id) {
        super("Particioante não encontrado. ID = " + id);
    }
}
