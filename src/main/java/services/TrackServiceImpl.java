package services;

import java.time.Month;
import java.util.List;

import models.trackservice.Step;
import services.interfaces.TrackService;

public class TrackServiceImpl implements TrackService {

    @Override
    public List<Step> getDriven(long trackerId, int year, Month month) {
        return null;
    }

}