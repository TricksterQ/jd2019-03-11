package by.it.bolotko.jd02_06.calc;

public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: "+ message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super("ERROR: "+ cause);
    }
}
