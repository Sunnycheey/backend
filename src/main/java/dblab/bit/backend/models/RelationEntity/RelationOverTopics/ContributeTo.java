package dblab.bit.backend.models.RelationEntity.RelationOverTopics;

import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * @program: backend
 * @description: contribute to relation between topics
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RelationshipEntity(type = "ContributeTo")
public class ContributeTo extends TopicRelations {
    public ContributeTo(RelationType relationType) {
        super(relationType);
    }

    public ContributeTo() {

    }
}
