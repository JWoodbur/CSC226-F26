package patient_intake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      String filePath = "src/main/java/patient_intake/patients.csv";
      PatientRegistry patients = new PatientRegistry();

      try (Scanner fileReader = new Scanner(new File(filePath))) {
         if (fileReader.hasNextLine()) {
            fileReader.nextLine(); // Skip the CSV header.
         }

         while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] parts = line.split(",");
            parts[0] = parts[0].trim(); // patientID
            parts[1] = parts[1].trim(); // fullName
            parts[2] = parts[2].trim(); // age
            parts[3] = parts[3].trim(); // chiefComplaint
            parts[4] = parts[4].trim(); // triageLevel
            parts[5] = parts[5].trim(); // currentStage
            parts[6] = parts[6].trim(); // assignedRoom
            parts[7] = parts[7].trim(); // arrivalHour
            parts[8] = parts[8].trim(); // insuranceID

            String patientID = parts[0];

            String[] nameParts = parts[1].split(" ");
            String firstName = nameParts[0].trim();
            String lastName = nameParts[1].trim();
            //split first name and last name from full name

            int age = Integer.parseInt(parts[2]);
            String chiefComplaint = parts[3];
            int triageLevel = Integer.parseInt(parts[4]);
            String currentStage = parts[5];
            String assignedRoom = parts[6];
            int arrivalHour = Integer.parseInt(parts[7]);
            String insuranceID = parts[8];

            Patient patient = new Patient(patientID, firstName, lastName, age, chiefComplaint, triageLevel, currentStage, assignedRoom, arrivalHour, insuranceID);
            patients.addPatient(patient);


            // TODO REQUIRED: Parse the fields from parts.
            // TODO REQUIRED: Split the full name into firstName and lastName.
            // TODO REQUIRED: Create a Patient and add it to patients.
         }
         System.out.println(patients); // Displays the completed registry.

         // TODO REQUIRED: Display the completed registry.
      } catch (FileNotFoundException exception) {
         // TODO REQUIRED: Report a missing input file.
         System.err.println("Error: File not found - " + filePath); // Shows an error message if the file is not found.
      }
   }
}