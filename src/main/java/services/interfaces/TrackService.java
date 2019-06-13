package services.interfaces;

import java.time.Month;
import java.util.List;

import models.trackservice.Step;

public interface TrackService {
    List<Step> getDriven(long trackerId, int year, Month month);
}