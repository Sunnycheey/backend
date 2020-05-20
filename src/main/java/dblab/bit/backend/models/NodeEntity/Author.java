package dblab.bit.backend.models.NodeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import java.util.Date;

/**
 * @program: backend
 * @description: authors class in the graph
 * @author: lihuichao
 * @create: 2020-04-17
 **/
@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {
    @Id
    @Index(unique = true)
    @Property(name = "ID")
    private String id;
    private String country;
    private String institution;
    @Property(name = "UpdateTimestamp")
    @Convert(dblab.bit.backend.utils.converter.DateTimeConverterFloat.class)
    private Date updateTimestamp;
    private String name;
    private String email;
    private String department;
    /*
    private long paperCount;
    private String lastKnownAffiliation;
    private String lastKnownEmail;
     */
    @Property(name = "CreatedTime")
    @Convert(dblab.bit.backend.utils.converter.DateTimeConverter.class)
    private Date createdTime;
}
