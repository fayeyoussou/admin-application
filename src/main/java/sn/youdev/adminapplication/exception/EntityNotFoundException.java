package sn.youdev.adminapplication.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException {
     final String message;
}
