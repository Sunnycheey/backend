package dblab.bit.backend.models.RelationEntity.RelationOverTopics;

import dblab.bit.backend.models.NodeEntity.Topic;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @program: backend
 * @description: parent of relations between topics
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RelationshipEntity(type = "ParentOf")
@Data
public class ParentOf {
    @StartNode
    private Topic topic1;
    @EndNode
    private Topic topic2;
    @Id
    @GeneratedValue
    private long id;
}
