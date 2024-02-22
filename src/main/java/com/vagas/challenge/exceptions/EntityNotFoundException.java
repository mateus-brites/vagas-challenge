package com.vagas.challenge.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class EntityNotFoundException extends DataIntegrityViolationException{
    public EntityNotFoundException() { super("id not found for "); }
    public EntityNotFoundException(String columnName) { super("id not found for " + columnName);}
    
}
