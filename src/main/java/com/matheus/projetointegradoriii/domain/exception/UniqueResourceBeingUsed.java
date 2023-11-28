package com.matheus.projetointegradoriii.domain.exception;

public class UniqueResourceBeingUsed extends BusinessException{
    public UniqueResourceBeingUsed(String message) {
        super(message);
    }

    public UniqueResourceBeingUsed(String resource, String value) {
        this("%s of value %s is already taken".formatted(resource, value));
    }
}
