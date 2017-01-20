package com.mycompany.common;

import lombok.Data;

/**
 * Created by antongusev on 15.12.16.
 */
@Data
public class Error {

    private int code;

    private String message;

    public Error() {}

    public Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
