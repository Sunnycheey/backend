package dblab.bit.backend.models.NodeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import java.util.Date;
import java.util.Set;

/**
 * @program: backend
 * @description: Paper class in the graph
 * @author: lihuichao
 * @create: 2020-04-16
 **/
@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Paper {
    @Id
    @GeneratedValue
    private String paperId;
    private String doi;
    private String title;
    private String authors;
    private String authorDetail;
    private String docType;
    @DateString
    private Date date;
    private int referenceCount;
    private int citationCount;
    private String pdfUrl;
    private String paperAbstract;
    private String mainSubject;
    private String relatedSubject;
    private String content;
    private String reference;
    private String referenceContext;
    private String keywords;
    @DateString
    private Date createdTime;

    @Relationship(type = "PaperCitation", direction = Relationship.INCOMING)
    private Set<Paper> citedPaperSet;
    @Relationship(type = "referencing", direction = Relationship.INCOMING)
    private Set<Paper> referencingPaperSet;
    @Relationship(type = "WritenBy", direction = Relationship.OUTGOING)
    private Set<Author> authorSet;
    @Relationship(type = "PublishedBy", direction = Relationship.OUTGOING)
    private Set<Venue> venueSet;
    @Relationship(type = "PaperFieldOfStudy", direction = Relationship.OUTGOING)
    private Set<Topic> topicSet;

}
