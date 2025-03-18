package bloodtestscheduler;

import javax.swing.JOptionPane;

/**
 *
 * @author saboteur
 */

public class Help {
    
    public static void showHelp() { // This makes it easy for anyone using this app to understand how it works
        System.out.println("Help menu loaded"); // terminal system confirmation
        
        String helpMessage = "Blood Test Scheduler Help\n\n"
                + "Adding Patients:\n"
                + "1. Enter the patient's Name, Age, and Gender.\n"
                + "2. Select the Priority Level (Urgent, Medium, Low).\n"
                + "3. Check the box if they are a Hospital Patient.\n"
                + "4. Assign a GP if needed.\n"
                + "5. Click 'Add Patient' to add them to the queue.\n\n"
                
                + "Processing Patients:\n"
                + "- Click 'Process Next' to show the highest priority/next up patient.\n"
                + "- If a patient is not present, mark them as a No-Show (Yes).\n\n"
                
                + "No-Show List:\n"
                + "- Click 'No-Shows' to see the list of patients who are marked as absent or no show.\n"
                + "- The last no-show patient will be shown first.\n"
                + "- Only the last five no-show patients are stored.\n\n"

                + "Patient Log:\n"
                + "- Click 'Patients Log' to view the history of all processed patients.\n"
                + "- The log follows the first in, first out method, so older(very first) records appear first.\n"
                + "- The log can be cleared if needed, with an option to 'Clear All' or simply 'Close' the window.\n\n"

                + "Additional Features:\n"
                + "- Click 'Show GP Details' to view all doctors.\n"
                + "- Click 'Clear Patient Queue' to remove all patients.\n"
                + "- Click 'Quit' to close the application.\n\n"

                + "Understanding the 'Assigned GP' Feature:\n"
                + "- Different GPs refer patients for blood tests based on their specialization.\n"
                + "- For example, a **Cardiologist (Dr. Smith)** might refer a patient to check for heart-related issues.\n"
                + "- The blood test report will include the referring GP’s details, ensuring the correct doctor gets the results.\n"
                + "- This helps make sure that the patient's test results are properly analyzed by the right expert.\n\n"

                + "That's the end of this help section!";

        // Display the help message in a dialog box
        JOptionPane.showMessageDialog(null, helpMessage, "Help", JOptionPane.INFORMATION_MESSAGE);
    }
}