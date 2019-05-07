package models.input;

import java.time.LocalTime;
import java.util.Date;

import models.RoadType;

public class TripPoint {
    public Double lat;
    public Double lng;
    public Date dateTime;
    public RoadType roadType;

    public TripPoint() {
    }

    public TripPoint(Double lat, Double lng, Date dateTime, RoadType roadType) {
        this.lat = lat;
        this.lng = lng;
        this.dateTime = dateTime;
        this.roadType = roadType;
    }

    public Double getLat() {
        return this.lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return this.lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Date getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public RoadType getRoadType() {
        return this.roadType;
    }

    public void setRoadType(RoadType roadType) {
        this.roadType = roadType;
    }

    public LocalTime getLocalTime(){
        return LocalTime.of(this.dateTime.getHours(), this.dateTime.getMinutes());
    }
}