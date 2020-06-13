package dblab.bit.backend.models.NodeEntity;

import dblab.bit.backend.utils.converter.DateTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.Convert;

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
    @GeneratedValue
    private long id;
    @Property(name = "VenueName")
    private String venueName;
    @Property(name = "AbbreviatedName")
    private String abbreviatedName;
    @Property(name = "CreatedTime")
    @Convert(DateTimeConverter.class)
    private Date createdTime;

    @Property(name="Type")
    private long type;
    private String yearList;

    @Relationship(type = "VenueFieldOfStudy", direction = Relationship.OUTGOING)
    private Set<Topic> topicSet;
}
