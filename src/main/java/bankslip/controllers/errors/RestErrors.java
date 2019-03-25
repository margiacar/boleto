package bankslip.controllers.errors;

import org.springframework.http.HttpStatus;

public class RestErrors {
    private HttpStatus status;
    private String message;

    RestErrors(HttpStatus status) {
        this.status = status;
    }

    RestErrors(HttpStatus status, Throwable ex) {
        this.status = status;
        this.message = "Unexpected error";
    }

    RestErrors(HttpStatus status, String message, Throwable ex) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
