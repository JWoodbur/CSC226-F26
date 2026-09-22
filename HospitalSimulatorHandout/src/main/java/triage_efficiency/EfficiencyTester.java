package triage_efficiency;

import java.util.*;
import patient_intake.Patient;

public class EfficiencyTester {

    /**
     * REQUIRED (80%): Implement linear search.
     *
     * Search through the patient array one element at a time until the matching
     * patientID is found. Return the Patient if it exists; otherwise return null.
     *
     * This method must run in O(n) time.
     */
    
    public Patient linearSearch(Patient[] patients, String pid) {
        // TODO REQUIRED: Implement linear search.
        // Search the entire array in order and return the matching Patient.
        for (Patient patient : patients){
            if (patient.getPatientID().equals(pid)){
                return patient;
            }
        }
        return null; // Will return null if the patientID is not found in the array.
    }

    /**
     * REQUIRED (80%): Implement binary search.
     *
     * This method works only on an array that is sorted by patientID.
     * Repeatedly divide the search range in half until the target is found.
     *
     * This method must run in O(log n) time.
     */


    public Patient binarySearch(Patient[] patients, String pid) {
        // TODO REQUIRED: Implement iterative binary search.
        // The array must be sorted by patientID before calling this method.
        int low = 0;
        int high = patients.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = patients[mid].getPatientID().compareTo(pid);
            if (comparison == 0) {
                return patients[mid]; // Found the target patient
            } else if (comparison < 0) {
                low = mid + 1; // Search in the higher end of the array
            } else {
                high = mid - 1; // Search in the lower end of the array
            }
        }
        return null; // Patient not found so we will explode(return null).
    }

    /**
     * OPTIONAL (+5%): Implement a different O(log n) search algorithm.
     *
     * Pick one of the following approaches and implement it:
     * - Exponential search
     * - Jump search
     * - Ternary search
     *
     * Add a short comment above the method explaining:
     * - which algorithm you chose
     * - where you learned about it
     * - why it works
     */
    public Patient logNSearch(Patient[] patients, String pid) {
        // TODO OPTIONAL: Research and implement a second O(log n) algorithm.
        // Cite your source and explain the approach in a comment before the logic.
        if (patients.length == 0) {
            return null; // Return null if the array is empty.
        }
        if (patients[0].getPatientID().equals(pid)) {
            return patients[0]; // Return the first patient if it matches the target.
        }
        int i = 1;

        while (i < patients.length && patients[i].getPatientID().compareTo(pid) <= 0) {
            i = i*2; // Exponentially increase the index to find the range.
        }

        int low = i / 2;
        int high = Math.min(i, patients.length - 1);

        while(low<=high){
            int mid = low + (high - low) / 2;
            int comparison = patients[mid].getPatientID().compareTo(pid);
            if (comparison == 0) {
                return patients[mid]; // Found the target patient
            } else if (comparison < 0) {
                low = mid + 1; // Search in the higher end of the array
            } else {
                high = mid - 1; // Search in the lower end of the array
            }
        }
        return null; // Remove this line and implement the method.
    }

    public void timeDemo() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 + 5;
        }
        long endTime = System.nanoTime();

        System.out.println("The example addition took: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 * 5;
        }
        endTime = System.nanoTime();
        System.out.println("The example multiplication took: " + (endTime - startTime) + " ns");
    }
}