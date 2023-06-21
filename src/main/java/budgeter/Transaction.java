package budgeter;

import java.time.LocalDate;

public class Transaction {
    private int transactionID;
    private LocalDate date;
    private LocalDate weekStartDate;
    private Double total;
    private int categoryID;
    private String type;
    private String title;
    private String vendor;

    public Transaction(int year, int month, int day, Double totalArg, String typeArg, String vendorArg) {
        date = LocalDate.of(year, month, day);
        weekStartDate = date.minusDays(date.getDayOfWeek().getValue() - 1);
        total = totalArg;
        type = typeArg;
        vendor = vendorArg;
    }

    public static void main(String[] args) {
        System.out.println("Transaction Created!");
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
