package dblab.bit.backend.models.NodeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @program: backend
 * @description: authors class in the graph
 * @author: lihuichao
 * @create: 2020-04-17
 **/
@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {
    @Id
    private String authorId;
    private String name;
    private long paperCount;
    private String lastKnownAffiliation;
    private String lastKnownEmail;
    private String createdTime;
}
