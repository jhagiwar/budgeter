package budgeter;

import java.time.LocalDate;

public class Transaction {
    private int transactionID;
    private LocalDate date;
    private LocalDate weekStartDate;
    private Double total;
    private CategoryId categoryID;
    private String paymentType;
    private String title;
    private String vendor;

    public Transaction(int year, int month, int day, Double totalArg, String paymentTypeArg, String vendorArg) {
        date = LocalDate.of(year, month, day);
        weekStartDate = date.minusDays(date.getDayOfWeek().getValue() - 1);
        total = totalArg;
        paymentType = paymentTypeArg;
        vendor = vendorArg;
    }

    public static void main(String[] args) {
        System.out.println("Transaction Created!");
    }

    public void setCategoryID(CategoryId categoryID) {
        this.categoryID = categoryID;
    }

    public CategoryId getCategoryID() {
        return categoryID;
    }

    public LocalDate getWeekStartDate() {
        return weekStartDate;
    }
}
