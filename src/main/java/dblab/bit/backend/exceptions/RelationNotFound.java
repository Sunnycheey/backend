package dblab.bit.backend.exceptions;

/**
 * @program: backend
 * @description: relation not found exception
 * @author: lihuichao
 * @create: 2020-04-23
 **/
public class RelationNotFound extends Exception {
    public RelationNotFound(String msg) {
        super(msg);
    }
}
