package dblab.bit.backend.models.RelationEntity.RelationOverTopics;

import dblab.bit.backend.models.NodeEntity.Topic;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @program: backend
 * @description: Equivalent to relation between topics
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RelationshipEntity(type = "EquivalentTo")
@Data
public class EquivalentTo {
    @StartNode
    private Topic topic1;
    @EndNode
    private Topic topic2;
    @Id
    @GeneratedValue
    private long id;
}
