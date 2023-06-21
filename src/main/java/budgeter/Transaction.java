package budgeter;

import java.time.LocalDate;

public class Transaction {
    private int transactionID;
    private LocalDate date;
    private double total;
    private int categoryID;
    private String type;
    private String title;
    private String vendor;
    private String notes;

    public Transaction(int year, int month, int day, int totalArg, String typeArg, String vendorArg) {
        date = LocalDate.of(year, month, day);
        total = totalArg;
        type = typeArg;
        vendor = vendorArg;
    }

    public static void main(String[] args) {
        System.out.println("Transaction Created!");
    }


}
