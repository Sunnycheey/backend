package dblab.bit.backend.controller;

import dblab.bit.backend.models.NodeEntity.Venue;
import dblab.bit.backend.repository.VenueRepository;
import dblab.bit.backend.response.BaseCollectionResponse;
import dblab.bit.backend.response.BaseMapResponse;
import dblab.bit.backend.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: backend
 * @description:
 * @author: Lingze_Waldinsamkeit
 * @create: 2020-06-04 13:30
 **/

@RestController
public class VenueController {
    @Autowired
    private VenueService venueServicelmpl;

    @RequestMapping(value = "/static/venue/{id}",method = RequestMethod.GET)
    public BaseMapResponse getVenueById(@PathVariable long id){
        BaseMapResponse baseMapResponse=new BaseMapResponse();
        baseMapResponse.setSuccessfullyState(venueServicelmpl.getVenuePageInfoById(id));
        return baseMapResponse;
    }

    @RequestMapping(value = "/search/venue/{name}",method = RequestMethod.GET)
    public BaseCollectionResponse<Venue> getVenueByName(@PathVariable String name){
        BaseCollectionResponse<Venue> baseCollectionResponse=new BaseCollectionResponse<>();
        List<Venue> venues=venueServicelmpl.getVenueByName(name);
        baseCollectionResponse.setSuccessfullyState(venues);
        return baseCollectionResponse;
    }

}
