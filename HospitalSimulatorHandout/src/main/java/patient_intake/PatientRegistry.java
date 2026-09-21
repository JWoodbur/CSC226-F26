package patient_intake;
// Switch from using ArrayList to a flat array implementation for patient storage.

import java.util.Arrays;

public class PatientRegistry {
    // Flat array to store patients and a size field to track the number of stored patients.
    private Patient[] patientRegistry;
    private int size; // track actual number of patients

    // Initial capacity for the flat array. Can be adjusted as needed.
    private static final int INITIAL_CAPACITY = 10;

    public PatientRegistry() {
        this.patientRegistry = new Patient[INITIAL_CAPACITY];
        this.size = 0;
        // TODO REQUIRED: Create the initial array and set the starting size.
    }

    public void addPatient(Patient patient) {
        patientRegistry[size] = patient;
        size++;
        if (size >= patientRegistry.length) {
            // Expand the array when it becomes full
            Patient[] newRegistry = new Patient[patientRegistry.length + 5];
            System.arraycopy(patientRegistry, 0, newRegistry, 0, patientRegistry.length);
            patientRegistry = newRegistry;
        }
        // TODO REQUIRED: Add a patient to the registry.
        // TODO OPTIONAL (+5%): Expand the array when it becomes full.
    }

    /**
     * Returns the patients currently stored in the registry.
     * The optional encapsulation extension requires returning a defensive copy.
     */
    public Patient[] getPatientRegistry() {
        Patient[] defensiveCopy = new Patient[size];
        System.arraycopy(patientRegistry, 0, defensiveCopy, 0, size);
        return defensiveCopy; // TODO REQUIRED: Return the patients currently stored.
    }

    public Patient getPatientByID(String patientID) {
        for (int i = 0; i < size; i++) {
            if (patientRegistry[i].getPatientID().equals(patientID)) {
                return patientRegistry[i];
            }
        }
        return null; // TODO REQUIRED: Search for and return the matching patient.
    }

    /**
     * Removes a patient from the registry by patientID.
     * @param patientID The ID of the patient to remove
     * @return true if patient was found and removed, false otherwise
     */
    public boolean removePatient(String patientID){
        for (int i = 0; i < size; i++) {
            if (patientRegistry[i].getPatientID().equals(patientID)) {
                // Shift elements to the left to fill the gap
                for (int j = i; j < size - 1; j++) {
                    patientRegistry[j] = patientRegistry[j + 1];
                }
                size--; // Decrement the size
                return true;
            }
        }
        return false; // TODO OPTIONAL (+5%): Remove the patient with this ID.
    }

    /**
     * Removes a patient from the registry by index.
     * @param index The index of the patient to remove
     * @return the removed Patient, or null if index is invalid
     */
    public Patient removePatient(int index) {
        for (int i = 0; i < size; i++) {
            if (i == index) {
                Patient removedPatient = patientRegistry[i];
                // Shift elements to the left to fill the gap
                for (int j = i; j < size - 1; j++) {
                    patientRegistry[j] = patientRegistry[j + 1];
                }
                size--; // Decrement the size
                return removedPatient;
            }
        }
        return null; // TODO OPTIONAL (+5%): Remove by index and shift later elements left.
    }

    /**
     * Updates a patient in the registry by matching patientID.
     * @param updatedPatient The patient with updated information
     * @return true if patient was found and updated, false otherwise
     */
    public boolean updatePatient(Patient updatedPatient) {
        for (int i = 0; i < size; i++) {
            if (patientRegistry[i].getPatientID().equals(updatedPatient.getPatientID())) {
                patientRegistry[i] = updatedPatient;
                return true;
            }
        }
        return false; // TODO OPTIONAL (+5%): Replace the patient with the same ID.
    }
    
    @Override
    public String toString() {
        return "PatientRegistry{" +
                "size=" + size +
                ", patientRegistry=" + Arrays.toString(patientRegistry) +
                '}';
    }

}


