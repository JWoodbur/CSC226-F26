package staff_assignment;

public class Main {
    //TODO, create a main file to demonstrate your roster: add staff, assign treatments, undo one, release cases,
    //and show each treatment's performedBy staffId
    public static void main(String[] args) {
        StaffRoster roster = new StaffRoster();

        // Adding staff members
        roster.addStaff(new StaffMember("S001", "Alice", Seniority.NURSE));
        roster.addStaff(new StaffMember("S002", "Bob", Seniority.TECH));
        roster.addStaff(new StaffMember("S003", "Charlie", Seniority.RESIDENT));
        roster.addStaff(new StaffMember("S004", "Diana", Seniority.ATTENDING));

        // Displaying the roster
        System.out.println("Initial Roster:");
        roster.displayRoster();

        // Assigning treatments
        System.out.println("\nAssigning Treatments:");
        StaffMember assigned1 = roster.assignTreatment("P001", "Treatment A", "2024-06-01 10:00", Seniority.NURSE);
        System.out.println("Assigned to: " + assigned1);

        StaffMember assigned2 = roster.assignTreatment("P002", "Treatment B", "2024-06-01 11:00", Seniority.TECH);
        System.out.println("Assigned to: " + assigned2);

        // Displaying the roster after assignments
        System.out.println("\nRoster After Assignments:");
        roster.displayRoster();

        // Undoing the last assignment
        System.out.println("\nUndoing Last Assignment:");
        StaffMember undone = roster.undoLastAssignment();
        if (undone != null) {
            System.out.println("Undone assignment for: " + undone);
        } else {
            System.out.println("No assignment to undo.");
        }

        // Displaying the roster after undo
        System.out.println("\nRoster After Undo:");
        roster.displayRoster();

        // Releasing cases
        System.out.println("\nReleasing Cases:");
        roster.release(assigned1);
        System.out.println("Released: " + assigned1);

        // Displaying the final roster
        System.out.println("\nFinal Roster:");
        roster.displayRoster();
    }
}
