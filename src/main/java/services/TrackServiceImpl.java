package services;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import models.trackservice.Step;
import services.interfaces.TrackService;

public class TrackServiceImpl extends BaseClientService implements TrackService {

    private static final String BASE_URI = "http://192.168.178.52:9300/trackings";

    @Override
    public List<Step> getDriven(long trackerId, int year, Month month) {
        WebTarget target = getClient().target(BASE_URI + "/" + trackerId + "/" + year + "/" + (month.getValue() - 1));

        String stepJson = target.request(MediaType.APPLICATION_JSON).get(String.class);

        if (stepJson.equals("")) {
            return new ArrayList<>();
        }

        return Arrays.asList(new Gson().fromJson(stepJson, Step[].class));
    }

}