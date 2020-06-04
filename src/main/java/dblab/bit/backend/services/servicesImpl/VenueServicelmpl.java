package dblab.bit.backend.services.servicesImpl;

import dblab.bit.backend.models.NodeEntity.Paper;
import dblab.bit.backend.models.NodeEntity.Venue;
import dblab.bit.backend.repository.VenueRepository;
import dblab.bit.backend.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: backend
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-06-04 13:06
 **/

@Service
public class VenueServicelmpl implements VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public List<Venue> getAll(){
        Iterable<Venue> venues=venueRepository.findAll();
        List<Venue> tmp=new ArrayList<>();
        for(Venue venue:venues){
            tmp.add(venue);
        }
        return tmp;
    }

    @Override
    public List<Venue>getVenueByName(String name){
        return venueRepository.findVenueByName(name);
    }

    @Override
    public Map<String,Object>getVenuePageInfoById(long id){
        Optional<Venue> optionalVenue=venueRepository.findById(id);
        Map<String,Object> ans=new HashMap<>();
        if(optionalVenue.isPresent()){
            Venue venue=optionalVenue.get();
            List<Paper> papers=venueRepository.findPaperByVenueId(id);
            ans.put("Venue",venue);
            ans.put("Paper",papers);
        }
        return ans;
    }
}
