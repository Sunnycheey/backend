package dblab.bit.backend.models.RelationEntity;

import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.SentimentEval;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

/**
 * @program: backend
 * @description: Paper Relation
 * @author: lihuichao
 * @create: 2020-04-17
 **/
@RelationshipEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaperCitation {
    @Id
    @GeneratedValue
    private long paperRelationId;
    @Property
    private SentimentEval sentimentEval;
    @StartNode
    private Paper paper;
    @EndNode
    private Paper citedPaper;
}
