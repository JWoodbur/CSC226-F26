package medical_action_tracking;

public class TreatmentRecord {
    private String patientID;
    private String treatmentName;
    private String timestamp;
    private String staffId;

    public TreatmentRecord(String patientID, String treatmentName, String timestamp, String staffId) {
        this.patientID = patientID;
        this.treatmentName = treatmentName;
        this.timestamp = timestamp;
        this.staffId = staffId;
    }

    public String getPatientID() {
        // TODO: Return the patient ID.
        return patientID;
    }

    public String getTreatmentName() {
        // TODO: Return the treatment description.
        return treatmentName;
    }

    public String getTimestamp() {
        // TODO: Return the timestamp.
        return timestamp;
    }
    

    @Override
    public String toString() {
        // TODO: Return "timestamp | patientID | treatmentName".
        return timestamp + " | " + patientID + " | " + treatmentName;
    }

    public String getStaffId() {
        return staffId;
    }
}
