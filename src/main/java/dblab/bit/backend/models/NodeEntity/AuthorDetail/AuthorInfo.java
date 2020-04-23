package dblab.bit.backend.models.NodeEntity.AuthorDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: backend
 * @description: author informatino class
 * @author: lihuichao
 * @create: 2020-04-23
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthorInfo {
    private String name;
    private String email;
    private Address address;
}
