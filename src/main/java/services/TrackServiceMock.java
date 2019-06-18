package services;

import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.trackservice.DatedLocation;
import models.trackservice.NamedLocation;
import models.trackservice.Step;
import services.interfaces.TrackService;

public class TrackServiceMock implements TrackService {

    @Override
    public List<Step> getDriven(long trackerId, int year, Month month) {
        // List<Step> steps = new ArrayList<>();

        // List<DatedLocation> locations = new ArrayList<>();

        // locations.add(new DatedLocation(100.00, 100.00, new Date()));
        // locations.add(new DatedLocation(90.00, 110.00, new Date()));
        // locations.add(new DatedLocation(80.00, 120.00, new Date()));
        // locations.add(new DatedLocation(70.00, 130.00, new Date()));
        // locations.add(new DatedLocation(60.00, 140.00, new Date()));

        // steps.add(new Step(100, new NamedLocation("Mockington Avenue", 100.00, 100.00), locations));

        // return steps;
        return null;
    }

}