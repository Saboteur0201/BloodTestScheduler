package bloodtestscheduler;

import javax.swing.JOptionPane;

/**
 *
 * @author saboteur
 */

public class Help {
    
    public static void showHelp() { // This makes it easy for anyone using this app to understand how it works
        String helpMessage = "Blood Test Scheduler Help\n\n"
                + "Adding Patients:\n"
                + "1. Enter the patient's Name, Age, and Gender.\n"
                + "2. Select the Priority Level (Urgent, Medium, Low).\n"
                + "3. Check the box if they are a Hospital Patient.\n"
                + "4. Assign a GP if needed.\n"
                + "5. Click 'Add Patient' to add them to the queue.\n\n"
                + "Processing Patients:\n"
                + "- Click 'Process Next' show the highest priority/next up patient.\n"
                + "- If a patient is not present, mark them as a No-Show (Yes).\n\n"
                + "Additional Features:\n"
                + "- Click 'Show GP Details' to view all doctors.\n"
                + "- Click 'Clear Patient Queue' to remove all patients.\n"
                + "- Click 'Quit' to close the application.";

        // Display the help message in a dialog box
        JOptionPane.showMessageDialog(null, helpMessage, "Help", JOptionPane.INFORMATION_MESSAGE);
    }
}