package dblab.bit.backend.response;

import lombok.Data;

/**
 * @program: backend
 * @description: Basic class of http response
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@Data
public class BaseCollectionResponse<T> {
    // http response status code
    private int code;
    private String message;
    private Iterable<T> data;

    public void setSuccessfullyState(Iterable<T> data) {
        this.code = 200;
        this.message = "OK";
        this.data = data;
    }
}
