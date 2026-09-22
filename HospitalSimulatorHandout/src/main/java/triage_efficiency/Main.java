package triage_efficiency;

import patient_intake.Patient;
import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // TODO REQUIRED: Generate the patient data.
        // TODO REQUIRED: Sort the data by patientID when needed.
        // TODO REQUIRED: Run each search method and print a found and not-found example.
        // TODO OPTIONAL: Call timeDemo() to compare algorithm runtimes.
        
        Patient[] patients = generatePatients(100); //100 patient sample generation.
        patients = sortByPatientId(patients); //Sorts the patients by ID for when we need to use binary search.
        EfficiencyTester test = new EfficiencyTester(); //Creates an instance of the EfficiencyTester class to use the methods.
        String foundID = patients[50].getPatientID(); //Use of an existing patient ID for a successful search.
        String notFoundID = "P99999"; //Use of a non-existing patient ID for a search that will return null.
        
        
        Patient foundLinear = test.linearSearch(patients, foundID); //Linear search for an existing patient.
        if (foundLinear != null) {
            System.out.println("Linear Search: Found patient with ID " + foundID);
        } else {
            System.out.println("Linear Search: Patient with ID " + foundID + " not found.");
        }
        Patient linearNotFoundPatient = test.linearSearch(patients, notFoundID); //Linear search for a non-existing patient.
        if (linearNotFoundPatient != null) {
            System.out.println("Linear Search: Found patient with ID " + notFoundID);
        } else {
            System.out.println("Linear Search: Patient with ID " + notFoundID + " not found.");
        }
        

          Patient foundBinary = test.binarySearch(patients, foundID); //Binary search for an existing patient.
        if (foundBinary != null) {
            System.out.println("Binary Search: Found patient with ID " + foundID);
        } else {
            System.out.println("Binary Search: Patient with ID " + foundID + " not found.");
        }
        Patient binaryNotFoundPatient = test.binarySearch(patients, notFoundID); //Binary search for a non-existing patient.
        if (binaryNotFoundPatient != null) {
            System.out.println("Binary Search: Found patient with ID " + notFoundID);
        } else {
            System.out.println("Binary Search: Patient with ID " + notFoundID + " not found.");
        }

        test.timeDemo(); //Optional method to compare the runtimes of the search algorithms.
    }

    /**
     * REQUIRED (80%): Generate sample patient data for testing.
     *
     * Build an array of Patient objects with realistic IDs, names, complaints,
     * and triage information so you can test each search method.
     */
    public static Patient[] generatePatients(int count) {
        // TODO REQUIRED: Create the patient array and fill it with sample data.
        Random random = new Random();
        Patient[] patients = new Patient[count];
        String[] firstNames = {"John", "Jane", "Alex", "Emily", "Chris", "Katie", "Michael", "Sarah", "David", "Laura", "Daniel", "Emma", "James", "Olivia", "Matthew", "Sophia", "Andrew", "Isabella", "Joseph", "Mia", "William", "Bart", "Ethan", "Charlotte", "Benjamin", "Amelia", "Samuel", "Harper", "Alexander", "Evelyn", "Jacob", "Abigail", "Ryan", "Ella", "Nathan", "Avery", "Joshua", "Scarlett", "Caleb", "Grace"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Wells", "Anderson", "Taylor", "Thomas", "Hernandez", "Moore", "Martin", "Jackson", "Thompson", "White", "Lopez", "Lee", "Gonzalez", "Harris", "Clark", "Lewis", "Robinson", "Walker", "Perez", "Hall", "Young", "Allen", "Sanchez", "Wright", "King", "Scott"};
        String[] complaints = {"Headache", "Fever", "Cough", "Stomach Pain", "Back Pain", "Allergy", "Injury", "Fatigue", "Dizziness", "Nausea"};
        for (int i = 0; i < count; i++) {
            int randID = i + random.nextInt(80000); // Generate a random patient ID.
            String pid = String.format("P%05d", randID); // Format the patient ID to be 5 digits with leading zeros.
            String name = firstNames[i % firstNames.length] + " " + lastNames[i % lastNames.length]; // Generate a name using an array of first and last names to create a random number of names.
            String chiefComplaint = complaints[i % complaints.length]; // Use an array of complaints to give a random complaint to each patient.
            int triageLevel = (i % 5) + 1; // Assigns a random triage level between 1 and 5.
            // Create a new Patient object with realistic data.
            // Example: new Patient(patientID, name, complaint, triageLevel);
            patients[i] = new Patient(pid, name, chiefComplaint, triageLevel);
        }
        return patients; // Replace this with your implementation.
    }

    /**
     * REQUIRED (80%): Sort patients by patientID before binary search.
     *
     * The binary-search version only works on an array sorted by patientID.
     */
    public static Patient[] sortByPatientId(Patient[] patients) {

        // TODO REQUIRED: Sort the array by patientID before testing binary search.
        Arrays.sort(patients, Comparator.comparing(Patient::getPatientID));
        System.out.println(Arrays.toString(patients)); // (Test) See if they are sorted correctly.
        return patients; // Replace this with your implementation.
    }
}
