package services;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import models.PersonalInformation;
import models.brpservice.BrpRootObject;
import models.brpservice.Data;
import services.interfaces.BrpService;

public class BrpServiceImpl extends BaseClientService implements BrpService {

    private static final String BASE_URI = "http://brp.fontys-project.nl";

    @Override
    public PersonalInformation getPersonalInformation(long brpId) {
        String query = "{%0A%20personById(id%3A%20" + brpId + ")%20{%0A%20%20%20%20gegeven_naam%0A%20%20%20%20achternaam%0A%20%20%20%20straat%0A%20%20%20%20postcode%0A%20%20%20%20woonplaats%0A%20%20%20%20land%0A%20%20}%0A}%0A";

        BrpRootObject data = getClient().target(BASE_URI + "/graphql?query=" + query)
                .request(MediaType.APPLICATION_JSON).get(BrpRootObject.class);

        return data.getData().getPersonByBsn().toPersonalInformation();
    }

}