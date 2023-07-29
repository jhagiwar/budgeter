package budgeter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


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


    public static void addToDatabase() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Transaction CSV Filename");
        String filename = myObj.nextLine();  // Read user input
        System.out.println("Is this Discover or Capital One? D/C");
        Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
        String ttype = myObj2.nextLine();  // Read user input
        ArrayList<Transaction> transactions = new ArrayList<>();
        if (ttype.equals("D")) {
            transactions = parseDiscoverTransactionsCSV(filename, LocalDate.now());
        } else if (ttype.equals("C")) {
            transactions = parseCapitalOneTransactionCSV(filename, LocalDate.now());
        } else {
            System.out.println("Error please quit and restart");
        }
        System.out.println("Enter Categories CSV Filename");
        Scanner myObj3 = new Scanner(System.in);  // Create a Scanner object
        String catfilename = myObj3.nextLine();  // Read user input
        ArrayList<CategoryId> categories = parseCategoryCSV(catfilename);


        for (int i = 0; i < transactions.size(); i++) {
            Database.insert_transaction(transactions.get(i).getTransactionValuesDatabaseString(categories.get(i)));
        }
    }

    public static void main(String[] args) {
        addToDatabase();

    }

//    public LocalDate getLastUpdated() {
//        return lastUpdated;
//    }

    public void setLastUpdated(LocalDate newLastUpdated) {
//		ALL THE UPDATE FUNCTIONS
//		* add all transactions to database

//		* update all weekly categories that need updating/recalculating
//		* update all weekly reviews that need updating/recalculating
//        this.lastUpdated = newLastUpdated;
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
//                if (!transaction.getDate().isBefore(lastUpdated) || transaction.getDate().isEqual(lastUpdated)) {
                transactionsToAdd.add(transaction);
//                }
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
                Transaction transaction = new Transaction(year, month, day, total, "Discover", transactionLine[2]);
                // WHEN U USE LAST UPDATED DO NOT ADD FOR THAT DATE
//                System.out.println(transaction.getTotal());
//                if (!transaction.getDate().isBefore(lastUpdated) || transaction.getDate().isEqual(lastUpdated)) {
                transactionsToAdd.add(transaction);
//                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactionsToAdd;
    }

    public static ArrayList<CategoryId> parseCategoryCSV(String fileName) {
        String line = "";
        String splitBy = ",";
        ArrayList<CategoryId> categoryIds = new ArrayList<CategoryId>();

        try {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            // for table header
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] catLine = line.split(splitBy);    // use comma as separator
                for (int i = 0; i < catLine.length; i++) {
                    categoryIds.add(CategoryId.stringToCatId(catLine[i]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return categoryIds;
    }


}
