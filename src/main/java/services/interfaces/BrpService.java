package services.interfaces;

import models.PersonalInformation;

public interface BrpService {
    PersonalInformation getPersonalInformation(long brpId);
}
