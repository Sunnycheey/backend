package dblab.bit.backend.models.NodeEntity.AuthorDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: backend
 * @description: affiliation information of author
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Affiliation {
    private String department;
    private String institution;
    private Address address;
}
