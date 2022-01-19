package hms.database.interfaces.payment.governmentschemespersistence;

public interface IGovernmentSchemePersistence {

    double getpatientSalDtls(int patientid);

    int updateFinalAmount(int patientid);

}

