package dblab.bit.backend.response;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @program: backend
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-06-03 12:12
 **/

@Data
public class BaseMapResponse {
    private int code;
    private String message;
    private Map<String,Object> data;

    public void setSuccessfullyState(Map<String,Object>data) {
        this.code = 200;
        this.message = "OK";
        this.data = data;
    }
}
