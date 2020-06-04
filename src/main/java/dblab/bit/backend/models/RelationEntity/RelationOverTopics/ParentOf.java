package dblab.bit.backend.models.RelationEntity.RelationOverTopics;

import dblab.bit.backend.models.NodeEntity.Topic;
import dblab.bit.backend.utils.converter.DateTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import java.sql.Date;

/**
 * @program: backend
 * @description: parent of relations between topics
 * @author: lihuichao
 * @create: 2020-04-23
 **/
@RelationshipEntity(type = "ParentOf")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentOf{
    @StartNode
    private Topic topic1;
    @EndNode
    private Topic topic2;
    @Convert(DateTimeConverter.class)
    @Property(name = "CreatedTime")
    private Date createdTime;
    @Id
    @GeneratedValue
    private long id;
}
