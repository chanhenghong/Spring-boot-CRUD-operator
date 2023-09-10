package com.acleda.crud.base;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class Rest<T> {
    private String message;
    private Boolean status;
    private Integer code;
    private Timestamp timestamp;
    private T data;

}
