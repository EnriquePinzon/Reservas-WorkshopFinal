package com.example.reservas.Exceptions;

public class InvalidStatementException extends RuntimeException{
    public InvalidStatementException() {
    }

    public InvalidStatementException(String messageError) {
        super(messageError);
    }
}
