package dblab.bit.backend.models.RelationEntity;

import dblab.bit.backend.models.NodeEntity.Author;
import dblab.bit.backend.models.NodeEntity.Paper;
import org.neo4j.ogm.annotation.*;

/**
 * @program: backend
 * @description: Written by relation between author and paper class
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RelationshipEntity
public class WritenBy {
    @Id
    @GeneratedValue
    private long id;
    @StartNode
    private Paper paper;
    @EndNode
    private Author author;
}
