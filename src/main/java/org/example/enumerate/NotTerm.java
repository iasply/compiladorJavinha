package org.example.enumerate;

public class NotTerm extends Throwable {
    @Override
    public String getMessage() {
        return "This is a NotTerm exception";
    }
}