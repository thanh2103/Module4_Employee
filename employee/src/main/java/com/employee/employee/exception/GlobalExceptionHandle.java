package com.employee.employee.exception;

import com.employee.employee.dto.ApiResponsi;
import com.employee.employee.exception.ApiException;
import com.employee.employee.exception.ErrorCode;
import com.employee.employee.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
// lắng nghe các sự kiện

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException e) {
        ErrorCode errorcode = e.getErrorcode();
        return ResponseEntity.status(ErrorCode.EMPLOYEE_NOT_EXIST.getHttpStatus()).body(ApiResponsi.<Employee>builder()
                .code(ErrorCode.EMPLOYEE_NOT_EXIST.getCode())
                .message(ErrorCode.EMPLOYEE_NOT_EXIST.getMessage())
                .build());

    }
}
