package services;

import java.time.Month;
import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import models.trackservice.Step;
import services.interfaces.TrackService;

public class TrackServiceImpl extends BaseClientService implements TrackService {

    private static final String BASE_URI = "http://track.fontys-project.nl/";

    @Override
    public List<Step> getDriven(long trackerId, int year, Month month) {
        List<Step> steps = getClient().target(BASE_URI + "/" + trackerId + "/" + year + "/" + month)
                .request(MediaType.APPLICATION_JSON).get(new GenericType<List<Step>>() {
                });
        return steps;
    }

}