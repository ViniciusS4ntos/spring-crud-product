package com.vinicius.spring_crud_produtos.infrastructure.exception;

public class NomeExistenteException extends RuntimeException{
    public NomeExistenteException(String message){super(message);}
    public NomeExistenteException(String message, Throwable throwable){super(message,throwable);}
}
