package services;

import models.Address;
import models.PersonalInformation;
import services.interfaces.BrpService;

public class BrpServiceMock implements BrpService {

    @Override
    public PersonalInformation getPersonalInformation(String bsn) {
        Address address = new Address("Mockstraat", "1", "1234MK", "Mockinton", "Groot Mocktannië");
        PersonalInformation personalInformation = new PersonalInformation("Mark Ockersson", address);
        return personalInformation;
    }

}