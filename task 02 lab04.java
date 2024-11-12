// Runnable for printing roll number table
class RollNumberTable implements Runnable {
    private final int rollNumber;

    public RollNumberTable(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public void run() {
        System.out.println("\nTable for Roll Number: " + rollNumber);
        for (int i = 1; i <= 10; i++) {
            System.out.println(rollNumber + " x " + i + " = " + (rollNumber * i));
        }
    }
}

// Runnable for printing date of birth table
class DOBTable implements Runnable {
    private int dobNumber;

    public DOBTable(int dobNumber) {
        this.dobNumber = dobNumber;
    }

    @Override
    public void run() {
        System.out.println("\nTable for Date of Birth: " + dobNumber);
        for (int i = 1; i <= 10; i++) {
            System.out.println(dobNumber + " x " + i + " = " + (dobNumber * i));
        }
    }
}

// Main class to execute the program
public class Main {
    public static void main(String[] args) {
        // Extracting roll number and date of birth (day part) from provided strings
        int rollNumber = 225;  // Extracted from "2022f-bse-225"
        int dobNumber = 2;     // Extracted from "02-April" (day number)

        // Create Runnable tasks for each table
        RollNumberTable rollNumberTask = new RollNumberTable(rollNumber);
        DOBTable dobTableTask = new DOBTable(dobNumber);

        // Create threads for each task
        Thread rollNumberThread = new Thread(rollNumberTask);
        Thread dobTableThread = new Thread(dobTableTask);

        // Start both threads concurrently
        rollNumberThread.start();
        dobTableThread.start();

        // Wait for both threads to finish
        try {
            rollNumberThread.join();
            dobTableThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
