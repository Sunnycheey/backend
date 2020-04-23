package dblab.bit.backend.models.RelationEntity;

import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Venue;
import org.neo4j.ogm.annotation.*;

/**
 * @program: backend
 * @description: Published by relation between paper and venue
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RelationshipEntity
public class PublishedBy {
    @Id
    @GeneratedValue
    private long id;
    @StartNode
    private Paper paper;
    @EndNode
    private Venue venue;
    @Property
    private String date;
}
