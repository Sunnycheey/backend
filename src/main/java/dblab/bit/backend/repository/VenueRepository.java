package dblab.bit.backend.repository;

import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Venue;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @program: backend
 * @description: Venue Services
 * @author: lihuichao
 * @create: 2020-05-20
 **/
public interface VenueRepository extends CrudRepository<Venue, Long> {
    @Query("match (n:Venue) where tolower(n.VenueName) contains tolower($0) OR tolower(n.AbbreviatedName) contains tolower($0) return n")
    List<Venue> findVenueByName(String name);

    @Query("match (n:Paper)-[:PublishedBy]->(m:Venue) where ID(m)=$0 return n")
    List<Paper> findPaperByVenueId(long id);

}
