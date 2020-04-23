package dblab.bit.backend.models.RelationEntity;

import dblab.bit.backend.models.NodeEntity.Topic;
import dblab.bit.backend.models.NodeEntity.Venue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

/**
 * @program: backend
 * @description: venue field of study relation type
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RelationshipEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VenueFieldOfStudy {
    @Id
    @GeneratedValue
    private long id;
    @StartNode
    private Venue venue;
    @EndNode
    private Topic topic;
    @Property
    private float score;

}
