package services.interfaces;

import java.util.List;

import models.trackservice.Step;

public interface TrackService {
    List<Step> getDriven(long trackerId, int year, int month);
}