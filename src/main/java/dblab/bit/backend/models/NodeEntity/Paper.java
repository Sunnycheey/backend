package dblab.bit.backend.models.NodeEntity;

import dblab.bit.backend.models.NodeEntity.AuthorDetail.AuthorDetail;
import dblab.bit.backend.utils.converter.DateTimeConverter;
import dblab.bit.backend.utils.converter.KeywordsConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.Convert;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
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
@Entity
public class Paper {
    @Id
    @Index(unique = true)
    private String ID;
    private List<String> doi;
    private String title;
    private List<String> authors;
    @Property(name = "AuthorDetail")
    @Convert(dblab.bit.backend.utils.converter.AuthorDetailConverter.class)
    private List<AuthorDetail> authorDetail;
    private List<String> comment;
    private String docType;
    @DateString
    private Date date;
    private int referenceCount;
    private int citationCount;
    @Property(name = "pdf")
    private String pdfUrl;
    private List<String> Abstract;
    @Property(name = "MainSubject")
    private String mainSubject;
    @Property(name = "RelatedSubjects")
    private List<String> relatedSubject;
    @Property(name = "Content")
    private String content;
    @Property(name = "Reference")
    private String reference;
    @Property(name = "ReferenceContext")
    private String referenceContext;

    @Property(name = "Keywords")
    @Convert(KeywordsConverter.class)
    private List<String> keywords;
    @Property(name = "CreateTime")
    @Convert(DateTimeConverter.class)
    private Date createdTime;

    @Property(name="base_method")
    private List<String>BaseMethod;

    @Property(name="dataset_or_shared_task")
    private List<String>Dataset;

    @Property(name="prev_method")
    private List<String>PrevMethod;

    @Property(name="domain_or_problem")
    private List<String>Domain;

    @Property(name="experiment_result")
    private List<String>ExperimentAndResult;

    @Property(name="current_method")
    private List<String>CurrentMethod;


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
