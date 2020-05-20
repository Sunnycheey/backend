package dblab.bit.backend.models.NodeEntity.AuthorDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: backend
 * @description: address information in author affiliation
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private String settlement;
    private String region;
    private String postCode;
    private String country;
}
