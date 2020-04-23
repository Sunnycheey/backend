package dblab.bit.backend.models.RelationEntity.RelationOverTopics;

import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * @program: backend
 * @description: parent of relations between topics
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RelationshipEntity(type = "ParentOf")
public class ParentOf extends TopicRelations {
    ParentOf() {

    }

    ParentOf(RelationType relationType) {
        super(relationType);
    }
}
