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
 * @description: topic class in the graph
 * @author: lihuichao
 * @create: 2020-04-23
 **/

@NodeEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Topic {
    @Id
    @GeneratedValue
    private long id;
    @Property(name = "Name")
    private String name;
    @Property(name = "RelatedEntity")
    private String relatedEntity;
    @Property(name = "Description")
    private String description;
    @Property(name = "CreatedTime")
    @Convert(DateTimeConverter.class)
    private Date createdTime;
    private int paperCount;
    private int authorCount;
    private int venueCount;
    @Relationship(type = "ParentOf", direction = Relationship.OUTGOING)
    private Set<Topic> topicParentOfSet;
    @Relationship(type = "ContributeTo", direction = Relationship.OUTGOING)
    private Set<Topic> topicContributeToSet;
    @Relationship(type = "EquivalentTo", direction = Relationship.OUTGOING)
    private Set<Topic> topicEquivalentToSet;
}
