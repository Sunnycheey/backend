package dblab.bit.backend.response;

import lombok.Data;

/**
 * @program: backend
 * @description: Basic class of http response with single record
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@Data
public class BaseSingleResponse<T> {
    private int code;
    private String message;
    private T data;
}
