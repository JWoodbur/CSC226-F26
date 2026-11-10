package staff_assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void seniorityComparison() {
        StaffMember attending = new StaffMember("S1", "Dr. Smith", Seniority.ATTENDING);
        StaffMember resident = new StaffMember("S2", "Dr. Jones", Seniority.RESIDENT);
        StaffMember nurse = new StaffMember("S3", "Nurse Brown", Seniority.NURSE);
        StaffMember tech = new StaffMember("S4", "Tech Green", Seniority.TECH);

        assertTrue(attending.getSeniority().compareTo(resident.getSeniority()) > 0);
        assertTrue(resident.getSeniority().compareTo(nurse.getSeniority()) > 0);
        assertTrue(nurse.getSeniority().compareTo(tech.getSeniority()) > 0);
    }


@Test 
void assignAndReleaseStaff() {
    StaffRoster roster = new StaffRoster();
    StaffMember nurse = new StaffMember("S1", "Nurse Brown", Seniority.NURSE);
    roster.addStaff(nurse);

    // Assign a treatment to the nurse
    StaffMember assigned = roster.assign(Seniority.NURSE);
    assertEquals(nurse, assigned);
    assertEquals(1, nurse.getCaseLoad());

    // Release the nurse from the treatment
    roster.release(nurse);
    assertEquals(0, nurse.getCaseLoad());
}

@Test 
void assignStaffWithNoAvailableMembers() {
    StaffRoster roster = new StaffRoster();
    // No staff members added to the roster

    // Attempt to assign a treatment with no available staff
    assertThrows(java.util.NoSuchElementException.class, () -> {
        roster.assign(Seniority.NURSE);
    });
}

@Test 
void addDuplicateStaffMember() {
    StaffRoster roster = new StaffRoster();
    StaffMember nurse1 = new StaffMember("S1", "Nurse Brown", Seniority.NURSE);
    roster.addStaff(nurse1);

    // Attempt to add a duplicate staff member
    StaffMember nurseDuplicate = new StaffMember("S1", "Nurse Green", Seniority.NURSE);
    assertThrows(IllegalArgumentException.class, () -> {
        roster.addStaff(nurseDuplicate);
    });
}

@Test 
void releaseStaffMemberWithZeroLoad() {
    StaffRoster roster = new StaffRoster();
    StaffMember nurse = new StaffMember("S1", "Nurse Brown", Seniority.NURSE);
    roster.addStaff(nurse);

    // Release the nurse when their load is already 0
    roster.release(nurse);
    assertEquals(0, nurse.getCaseLoad(), "Case load should not go below 0");
}
}