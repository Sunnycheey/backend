package dblab.bit.backend.models.RelationEntity;

import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Topic;
import org.neo4j.ogm.annotation.*;

/**
 * @program: backend
 * @description: The topic of paper
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RelationshipEntity
public class PaperFieldOfStudy {
    @Id
    @GeneratedValue
    private long id;
    @StartNode
    private Paper paper;
    @EndNode
    private Topic topic;
    @Property
    private float score;
}
