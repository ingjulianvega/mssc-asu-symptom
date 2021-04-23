package ingjulianvega.ximic.msscasusymptom.exception;

import lombok.Getter;

@Getter
public class SymptomException extends RuntimeException {

    private final String code;

    public SymptomException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

