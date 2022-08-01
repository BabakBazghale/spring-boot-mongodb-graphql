package com.bob.projects.graphql.exception;

public class SingerNotExistException extends RuntimeException {

    public SingerNotExistException(String message) {
        super(message);
    }
}