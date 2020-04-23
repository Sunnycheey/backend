package dblab.bit.backend.models.NodeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

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
    private String name;
    private String relatedEntity;
    private String description;
    private String createdTime;
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
