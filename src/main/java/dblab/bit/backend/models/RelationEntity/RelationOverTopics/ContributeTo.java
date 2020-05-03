package dblab.bit.backend.models.RelationEntity.RelationOverTopics;

import dblab.bit.backend.models.NodeEntity.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

/**
 * @program: backend
 * @description: contribute to relation between topics
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RelationshipEntity(type = "Contribute_To")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContributeTo {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private Topic topic1;
    @EndNode
    private Topic topic2;

}
