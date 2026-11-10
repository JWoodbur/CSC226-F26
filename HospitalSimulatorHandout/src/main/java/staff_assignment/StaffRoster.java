package staff_assignment;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import medical_action_tracking.TreatmentHistory;
import medical_action_tracking.TreatmentRecord;

public class StaffRoster {
    // Week 3 stack-based history; every assignment is recorded here so it can be undone.
    private final TreatmentHistory history = new TreatmentHistory();

    // Outer map groups staff by seniority; each inner set is sorted by StaffMember's ordering.
    private final TreeMap<Seniority, TreeSet<StaffMember>> tiers = new TreeMap<>();

    // TODO: Add the staff member to the correct tier, and reject a duplicate staffId.
    public void addStaff(StaffMember staff) {
        if (findById(staff.getStaffId()) != null) {
            throw new IllegalArgumentException("Duplicate staffId: " + staff.getStaffId());
        }
        tiers.computeIfAbsent(staff.getSeniority(), k -> new TreeSet<>()).add(staff);
    }

    // TODO: Pick the least-loaded staff member at or above "required", raise their load by 1, and return them.
    public StaffMember assign(Seniority required) {
    StaffMember bestStaff = null;
    for (TreeSet<StaffMember> staffSet : tiers.tailMap(required, true).values()) {
        for (StaffMember staff : staffSet) {

            if (bestStaff == null ||
                staff.getCaseLoad() < bestStaff.getCaseLoad()) {
                bestStaff = staff;
            }
        }
    }
    if (bestStaff == null) {
        throw new java.util.NoSuchElementException(
            "No available staff member at or above required seniority."
        );
    }
    changeLoad(bestStaff, bestStaff.getCaseLoad() + 1);
    return bestStaff;
}

    // TODO: Lower the staff member's load by 1 (never below 0) and keep the tree ordered.
    public void release(StaffMember staff) {
        changeLoad(staff, Math.max(0, staff.getCaseLoad() - 1));
    }

    // TODO: Return how many staff members are in the roster.
    public int size() {
        int total = 0;
        for (TreeSet<StaffMember> staffSet : tiers.values()) {
            total += staffSet.size();
        }
        return total;
    }

    // TODO: Print each tier, most senior first, listing its staff in order.
    public void displayRoster() {
        for (Entry<Seniority, TreeSet<StaffMember>> entry : tiers.descendingMap().entrySet()) {
            System.out.println("Seniority: " + entry.getKey());
            for (StaffMember staff : entry.getValue()) {
                System.out.println("  - " + staff);
            }
        }
    }

    // TODO: Remove the member, set the new load, then add them back (the only safe way to change a load).
    private void changeLoad(StaffMember member, int newLoad) {
        tiers.get(member.getSeniority()).remove(member);
        member.setCaseLoad(newLoad);
        tiers.get(member.getSeniority()).add(member);
    }

    // TODO: Call assign(), record the treatment in history with the chosen staffId, and return that staff member.
    public StaffMember assignTreatment(String patientID, String treatment, String timestamp, Seniority required) {
        StaffMember assignedStaff = assign(required);
        TreatmentRecord record = new TreatmentRecord(patientID, treatment, timestamp, assignedStaff.getStaffId());
        history.recordTreatment(record);
        return assignedStaff;
    }

    // TODO: Pop the globally most recent treatment with your Week 3 undo, release whoever performed it, and return them (null if none).
    public StaffMember undoLastAssignment() {
       TreatmentRecord lastRecord = history.undoLastTreatment();
       if (lastRecord == null) {
           return null;
    }
       StaffMember staff = findById(lastRecord.getStaffId());
       if (staff != null) {
           release(staff);
       }
       return staff;
    }

    // TODO: Return the staff member with this staffId, or null if they are not in the roster.
    private StaffMember findById(String staffId) {
        for (TreeSet<StaffMember> staffSet : tiers.values()) {
            for (StaffMember staff : staffSet) {
                if (staff.getStaffId().equals(staffId)) {
                    return staff;
                }
            }
        }
        return null;
    }
}
