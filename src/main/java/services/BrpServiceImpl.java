package services;

import javax.ws.rs.client.WebTarget;

import models.PersonalInformation;
import models.brpservice.BrpRootObject;
import services.interfaces.BrpService;

public class BrpServiceImpl extends BaseClientService implements BrpService {

    private static final String BASE_URI = "http://brp.fontys-project.nl";

    @Override
    public PersonalInformation getPersonalInformation(long brpId) {
        String query = "%7BpersonById(id%3A" + brpId + ")%7Bgegeven_naam%20achternaam%20straat%20postcode%20woonplaats%20land%7D%7D%0A";
        WebTarget target = getClient().target(BASE_URI + "/graphql").queryParam("query", query);
        BrpRootObject data = target.request().get(BrpRootObject.class);

        return data.getData().getPersonById().toPersonalInformation();

    }
}