package patient_intake;

public class Patient extends Person {
    private String patientID;
    private String chiefComplaint;
    private int triageLevel;
    private String currentStage;
    private String assignedRoom;
    private int arrivalHour;
    private String insuranceID;

    public Patient(String patientID, String firstName, String lastName, int age, 
                   String chiefComplaint, int triageLevel, String currentStage, 
                   String assignedRoom, int arrivalHour, String insuranceID) {
        super(firstName, lastName, age);
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.chiefComplaint = chiefComplaint;
        this.triageLevel = triageLevel;
        this.currentStage = currentStage;
        this.assignedRoom = assignedRoom;
        this.arrivalHour = arrivalHour;
        this.insuranceID = insuranceID;
        // TODO REQUIRED: Initialize the patient-specific fields.
    }

    public Patient(String patientID2, String name, String chiefComplaint2, int triageLevel2) {
        //TODO Auto-generated constructor stub
    }

    // Getters
    public String getPatientID() {
        return patientID; // TODO REQUIRED: Return the patient ID.
    }

    public String getFirstName() {
        return firstName; // TODO REQUIRED: Return the first name.
    }

    public String getLastName() {
        return lastName; // TODO REQUIRED: Return the last name.
    }

    public int getAge() {
        return age; // TODO REQUIRED: Return the age.
    }

    public String getChiefComplaint() {
        return chiefComplaint; // TODO REQUIRED: Return the chief complaint.
    }

    public int getTriageLevel() {
        return triageLevel; // TODO REQUIRED: Return the triage level.
    }

    public String getCurrentStage() {
        return currentStage; // TODO REQUIRED: Return the current stage.
    }

    public String getAssignedRoom() {
        return assignedRoom; // TODO REQUIRED: Return the assigned room.
    }

    public int getArrivalHour() {
        return arrivalHour; // TODO REQUIRED: Return the arrival hour.
    }

    public String getInsuranceID() {
        return insuranceID; // TODO REQUIRED: Return the insurance ID.
    }

    // Setters
    public void setPatientID(String patientID) {
        this.patientID = patientID; // TODO REQUIRED: Update the patient ID.
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName; // TODO REQUIRED: Update the first name.
    }

    public void setLastName(String lastName) {
        this.lastName = lastName; // TODO REQUIRED: Update the last name.
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age; // TODO REQUIRED: Update the age.
        } else {
            throw new IllegalArgumentException("Age must be between 0 and 120."); //OPTIONAL WORK
        }
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint; // TODO REQUIRED: Update the chief complaint.
    }

    public void setTriageLevel(int triageLevel) {
        this.triageLevel = triageLevel; // TODO REQUIRED: Update the triage level.
    }

    public void setCurrentStage(String currentStage) {
        this.currentStage = currentStage; // TODO REQUIRED: Update the current stage.
    }

    public void setAssignedRoom(String assignedRoom) {
        this.assignedRoom = assignedRoom; // TODO REQUIRED: Update the assigned room.
    }

    public void setArrivalHour(int arrivalHour) {
        this.arrivalHour = arrivalHour; // TODO REQUIRED: Update the arrival hour.
    }

    public void setInsuranceID(String insuranceID) {
        this.insuranceID = insuranceID; // TODO REQUIRED: Update the insurance ID.
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID='" + patientID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", chiefComplaint='" + chiefComplaint + '\'' +
                ", triageLevel=" + triageLevel +
                ", currentStage='" + currentStage + '\'' +
                ", assignedRoom='" + assignedRoom + '\'' +
                ", arrivalHour=" + arrivalHour +
                ", insuranceID='" + insuranceID + '\'' +
                '}'; // TODO REQUIRED: Return a useful representation of a patient.
    }
}