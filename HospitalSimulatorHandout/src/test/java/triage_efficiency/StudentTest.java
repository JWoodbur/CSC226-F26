package triage_efficiency;

import patient_intake.Patient;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    
private Patient[] patients = {
    new Patient("P00001", "Alice", "Smith", 25, "Headache", 2, "Triage", "ER-001", 9, "INS-00001"),
    new Patient("P00002", "Bob", "Jones", 35, "Back Pain", 3, "Treatment", "ER-002", 10, "INS-00002"),
    new Patient("P00003", "Cara", "Nguyen", 42, "Chest Pain", 1, "Waiting", "ER-003", 11, "INS-00003"),
    new Patient("P00004", "Dylan", "Brown", 51, "Shortness of Breath", 2, "Triage", "ER-004 ", 12, "INS-00004"),
    new Patient("P00005", "Emma", "Davis", 27, "Nausea", 4, "Recovery", "ER-005", 13, "INS-00005"),
    new Patient("P00006", "Frank", "Miller", 60, "Fractured Arm", 3, "Treatment", "ER-006", 14, "INS-00006")    
};

private EfficiencyTester tester = new EfficiencyTester();

@Test
public void testLinearSearchFirstPosition() {
    Patient result = tester.linearSearch(patients, "P00001");
    assertNotNull(result);
    assertEquals("P00001", result.getPatientID());
}

@Test
public void testLinearSearchLastPosition() {
    Patient result = tester.linearSearch(patients, "P00006");
    assertNotNull(result);
    assertEquals("P00006", result.getPatientID());
}

@Test
public void testLinearSearchMiddlePosition() {
    Patient result = tester.linearSearch(patients, "P00003");
    assertNotNull(result);
    assertEquals("P00003", result.getPatientID());
}

@Test 
public void testLinearSearchNotFound() {
    Patient result = tester.linearSearch(patients, "P99999");
    assertNull(result);
}

@Test
public void testBinarySearchFirstPosition() {
    Patient result = tester.binarySearch(patients, "P00001");
    assertNotNull(result);
    assertEquals("P00001", result.getPatientID());
}

@Test
public void testBinarySearchLastPosition() {
    Patient result = tester.binarySearch(patients, "P00006");
    assertNotNull(result);
    assertEquals("P00006", result.getPatientID());
}

@Test
public void testBinarySearchMiddlePosition() {
    Patient result = tester.binarySearch(patients, "P00003");
    assertNotNull(result);
    assertEquals("P00003", result.getPatientID());
}

@Test 
public void testBinarySearchNotFound() {
    Patient result = tester.binarySearch(patients, "P99999");
    assertNull(result);
}

@Test 
public void testLogNSearchFirstPosition() {
    Patient result = tester.logNSearch(patients, "P00001");
    assertNotNull(result);
    assertEquals("P00001", result.getPatientID());
}

@Test
public void testLogNSearchNotFound() {
    Patient result = tester.logNSearch(patients, "P99999");
    assertNull(result);
}
}
