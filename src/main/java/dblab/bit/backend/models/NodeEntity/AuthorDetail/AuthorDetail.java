package dblab.bit.backend.models.NodeEntity.AuthorDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * @program: backend
 * @description: author detail class
 * @author: lihuichao
 * @create: 2020-05-17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthorDetail {
    private Address address;
    private Affiliation affiliation;
    private String name;
}
