package patient_intake;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Patient studentTestPatient;

    @BeforeEach
    public void setUp() {
        studentTestPatient = new Patient(
            "T001", // Patient ID
            "Oswald", // First Name
            "Beeftung", // Last Name
            21, // Age
            "Headache", // Chief Complaint
            2, // Triage Level
            "Waiting", // Current Stage
            "Room538", // Room Number
            10, // Arrival Hour
            "INS65202" // Insurance ID
        );
    }

    @Test
    void testPatientRemoval() {
        PatientRegistry registry = new PatientRegistry();
        registry.addPatient(studentTestPatient);
        
        // Making sure that the patient is added
        assertEquals(1, registry.getPatientRegistry().length, "Registry should have 1 patient after addition");
        
        // Remove the patient
        boolean removed = registry.removePatient("T001");
        
        // Check if removal was successful
        assertTrue(removed, "Patient should be successfully removed");
        
        // Ensure the registry is now empty
        assertEquals(0, registry.getPatientRegistry().length, "Registry should be empty after removal");
    }

    @Test
    void testAddingPatient() {
        PatientRegistry registry = new PatientRegistry();
        registry.addPatient(studentTestPatient);
        
        // See if the patient was added
        assertEquals(1, registry.getPatientRegistry().length, "Registry should have 1 patient after addition");
        assertEquals("T001", registry.getPatientRegistry()[0].getPatientID(), "Patient ID should match");
    }

    @Test 
    void returnPatientInRegistry() {
        PatientRegistry registry = new PatientRegistry();
        registry.addPatient(studentTestPatient);
        
        // Retrieve the patient by ID
        Patient retrievedPatient = registry.getPatientByID("T001");
        
        // Check if the patient matches the one that was added
        assertNotNull(retrievedPatient, "Patient should not be null");
        assertEquals("T001", retrievedPatient.getPatientID(), "Patient ID should match");
    }

    @Test 
    void testPatientNotFound() {
        PatientRegistry registry = new PatientRegistry();
        
        // Try to retrieve a patient that doesn't exist
        Patient retrievedPatient = registry.getPatientByID("NonExistentID");
        
        // Check if the result is null
        assertNull(retrievedPatient, "Retrieved patient should be null for non-existent ID");
    }

    @Test
    void testSetChiefComplaint() {
        studentTestPatient.setChiefComplaint("Migraine");
        assertEquals("Migraine", studentTestPatient.getChiefComplaint(), "Chief complaint should be updated");
    } //Testing sets to the patient class to make sure they are working correctly.

    @Test
    void testSetTriageLevel() {
        studentTestPatient.setTriageLevel(1);
        assertEquals(1, studentTestPatient.getTriageLevel(), "Triage level should be updated");
        studentTestPatient.setTriageLevel(5);
        assertEquals(5, studentTestPatient.getTriageLevel(), "Triage level should be changed");
    }

    @Test
    void testChangeFirstName() {
        studentTestPatient.setFirstName("Bart");
        assertEquals("Bart", studentTestPatient.getFirstName(), "First name should be updated");
    }

}
