package com.perfumeProject.PerfumeProject.Exception;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String email){
        super("Email address '"+email+"' already exists!!");
    }
}
