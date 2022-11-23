package interfaces;

import models.Applicant;
import models.Store;

public interface ManagerService {
    String hireCashier(Store store, Applicant applicant);
}
