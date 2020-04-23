package dblab.bit.backend.models.RelationEntity.RelationOverTopics;

import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * @program: backend
 * @description: Equivalent to relation between topics
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RelationshipEntity(type = "EquivalentTo")
public class EquivalentTo extends TopicRelations {
    public EquivalentTo(RelationType relationType) {
        super(relationType);
    }

    public EquivalentTo() {

    }
}
