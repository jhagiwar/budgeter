package budgeter;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeeklyCategory {
    private CategoryId categoryID;
    private Double weeklyBudget;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    private ArrayList<Transaction> transactions;

    private Double transactionsTotal;

    public WeeklyCategory(int year, int month, int day, CategoryId categoryIDArg) {
        startDate = LocalDate.of(year, month, day);
        endDate = startDate.plusDays(7);
        categoryID = categoryIDArg;
        switch (categoryIDArg) {
            case SUBSCRIPTIONS:
                weeklyBudget = 10.46;
                name = "Subscriptions";
            case GROCERIES:
                weeklyBudget = 80.00;
                name = "Groceries";
            case COFFEE:
                weeklyBudget = 10.00;
                name = "Coffee";
            case TEA:
                weeklyBudget = 5.00;
                name = "Tea";
            case FOOD_DELIVERY:
                weeklyBudget = 0.00;
                name = "Food Delivery";
            case DINING_OUT:
                weeklyBudget = 20.00;
                name = "Dining Out";
            case TOILETRIES:
                weeklyBudget = 20.00;
                name = "Toiletries";
            case ELECTRIC:
                weeklyBudget = 25.00;
                name = "Electricity Bill";
            case FUN_AND_ACTIVITIES:
                weeklyBudget = 20.00;
                name = "Fun/Activities";
            case PUBLIC_TRANSPORTATION:
                weeklyBudget = 28.75;
                name = "Public Transportation";
            case UBER_AND_LYFT:
                weeklyBudget = 20.00;
                name = "Uber/Lyft/Other";
            case CLOTHES:
                weeklyBudget = 15.99;
                name = "Clothes";
            case MEDICAL:
                weeklyBudget = 11.00;
                name = "Medical";
            case HOME:
                weeklyBudget = 10.00;
                name = "Home";
            case OTHER:
                weeklyBudget = 5.00;
                name = "Other";
        }
    }

    public void updateTransactions() {
        System.out.println("Updating Transactions for week of " + startDate.toString() + " Category: " + name);
        //        check current date against start and end
        //  update transaction total
    }

    public String[] getWeeklyCategorySummary() {
        String[] ret = new String[]{name, weeklyBudget.toString(), transactionsTotal.toString()};
        return ret;
    }
}
