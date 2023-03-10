package wwe.exception;

public class ContrincantesInsuficientesException extends Exception {
    public ContrincantesInsuficientesException(String errorMessage) {
        super("No hay suficientes luchadores para empezar el combate");
    }

}
