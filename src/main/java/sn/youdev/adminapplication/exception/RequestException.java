package sn.youdev.adminapplication.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class  RequestException extends RuntimeException {
    final String message;
    final HttpStatus status;
}
