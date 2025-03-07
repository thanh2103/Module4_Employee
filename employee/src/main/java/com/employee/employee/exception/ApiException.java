package com.employee.employee.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
//xử lý những trường hợp ngoại lệ
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)

public class ApiException extends RuntimeException{
    ErrorCode errorcode;

    public ApiException(ErrorCode errorcode) {
        super(errorcode.getMessage());
        this.errorcode = errorcode;
    }
}
