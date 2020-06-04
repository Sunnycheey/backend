package dblab.bit.backend.services;


import dblab.bit.backend.models.NodeEntity.Venue;

import java.util.List;
import java.util.Map;

public interface VenueService {

    Map<String,Object> getVenuePageInfoById(long id);

    List<Venue> getAll();

    List<Venue> getVenueByName(String name);
}
