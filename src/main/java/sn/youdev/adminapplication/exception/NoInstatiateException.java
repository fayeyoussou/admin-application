package sn.youdev.adminapplication.exception;

public class NoInstatiateException extends RuntimeException {
    public NoInstatiateException(String className) {
        super(className +" Cannot be instiated");
    }
}
