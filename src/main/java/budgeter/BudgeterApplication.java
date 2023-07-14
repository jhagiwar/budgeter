package budgeter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;  // Import the Scanner class
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class BudgeterApplication {


    // WHEN U USE LAST UPDATED DO NOT ADD FOR THAT DATE
    private LocalDate lastUpdated;
    private String databasePath = "";

    public BudgeterApplication() {
        lastUpdated = LocalDate.of(2023, 1, 1);
    }

    public BudgeterApplication(Integer year, Integer month, Integer day) {
        lastUpdated = LocalDate.of(year, month, day);
        ;
    }

    public static void main(String[] args) {
//        System.out.println("Updating Everything");
        System.out.println("Ready to review");
        System.out.println(CategoryId.valueOf("DINING_OUT"));
        System.out.println(CategoryId.valueOf("DINING_OUT") == CategoryId.DINING_OUT);
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter username");
//        String userName = myObj.nextLine();  // Read user input
//        System.out.println("Username is: " + userName);  // Output user input

    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate newLastUpdated) {
//		ALL THE UPDATE FUNCTIONS
//		* add all transactions to database

//		* update all weekly categories that need updating/recalculating
//		* update all weekly reviews that need updating/recalculating
        this.lastUpdated = newLastUpdated;
    }

    public static ArrayList<Transaction> parseCapitalOneTransactionCSV(String fileName, LocalDate lastUpdated) {
        String line = "";
        String splitBy = ",";
        ArrayList<Transaction> transactionsToAdd = new ArrayList<Transaction>();
        try {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            // for table header
            br.readLine();
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                if (line.length() < 6) {
                    break;
                }
                String[] transactionLine = line.split(splitBy);    // use comma as separator
//                System.out.println(transactionLine);

                String[] date = transactionLine[0].split("-");
                String strPattern = "^0+(?!$)";
                int month = Integer.parseInt(date[1].replaceAll(strPattern, ""));
                int day = Integer.parseInt(date[2].replaceAll(strPattern, ""));
                BigDecimal total = BigDecimal.valueOf(0.0);
                if (transactionLine.length == 7) {
                    total = BigDecimal.valueOf(-1 * Double.valueOf(transactionLine[6]));
                } else {
                    total = BigDecimal.valueOf(Double.valueOf(transactionLine[5]));
                }
                Transaction transaction = new Transaction(Integer.parseInt(date[0]), month, day, total, "Capital One", transactionLine[3]);
                // WHEN U USE LAST UPDATED DO NOT ADD FOR THAT DATE
//                System.out.println(transaction.getTotal());
                if (!transaction.getDate().isBefore(lastUpdated) || transaction.getDate().isEqual(lastUpdated)) {
                    transactionsToAdd.add(transaction);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactionsToAdd;
    }

    public static ArrayList<Transaction> parseDiscoverTransactionsCSV(String fileName, LocalDate lastUpdated) {
        String line = "";
        String splitBy = ",";
        ArrayList<Transaction> transactionsToAdd = new ArrayList<Transaction>();
        try {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            // for table header
            br.readLine();
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {

                String[] transactionLine = line.split(splitBy);    // use comma as separator
                String[] date = transactionLine[0].split("/");
                String strPattern = "^0+(?!$)";
                int year = Integer.parseInt(date[2].replaceAll(strPattern, ""));
                int month = Integer.parseInt(date[0].replaceAll(strPattern, ""));
                int day = Integer.parseInt(date[1].replaceAll(strPattern, ""));
                BigDecimal total = BigDecimal.valueOf(Double.valueOf(transactionLine[3]));
                Transaction transaction = new Transaction(year, month, day, total, "Discover", transactionLine[3]);
                // WHEN U USE LAST UPDATED DO NOT ADD FOR THAT DATE
//                System.out.println(transaction.getTotal());
                if (!transaction.getDate().isBefore(lastUpdated) || transaction.getDate().isEqual(lastUpdated)) {
                    transactionsToAdd.add(transaction);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactionsToAdd;
    }
}
