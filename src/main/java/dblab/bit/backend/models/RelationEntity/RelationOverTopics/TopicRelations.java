package dblab.bit.backend.models.RelationEntity.RelationOverTopics;

import dblab.bit.backend.models.NodeEntity.Topic;
import lombok.*;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @program: backend
 * @description: The interface of relations between topics
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
public class TopicRelations {
    @NonNull
    private RelationType relationType;
    @StartNode
    private Topic topic1;
    @EndNode
    private Topic topic2;
    @Id
    @GeneratedValue
    private long id;
}
