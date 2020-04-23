package dblab.bit.backend.models.NodeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import java.util.Date;
import java.util.Set;

/**
 * @program: backend
 * @description: venue class in the graph
 * @author: lihuichao
 * @create: 2020-04-23
 **/

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venue {
    @Id
    private String venueId;
    private String venueName;
    private String abbreviatedName;
    private int paperCount;
    @DateString
    private Date createdTime;
    private int type;
    private String yearList;

    @Relationship(type = "VenueFieldOfStudy", direction = Relationship.OUTGOING)
    private Set<Topic> topicSet;
}
