package exceptions;

public class InexistentFileExeception extends RuntimeException {
    public  InexistentFileExeception() {
        super("file doesn't exist!");
    }
}
