package services;

import models.PersonalInformation;
import services.interfaces.BrpService;

public class BrpServiceImpl implements BrpService {
    
    @Override
    public PersonalInformation getPersonalInformation(int bsn) {
        // TODO: Get the personal information from an API that doesn't exist yet
        return new MockInvoiceService().GenerateMockInvoice().getPersonalInformation();
    }

}