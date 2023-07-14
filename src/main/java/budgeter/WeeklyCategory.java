package budgeter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class WeeklyCategory {
    private CategoryId categoryID;
    private BigDecimal weeklyBudget;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    private ArrayList<Transaction> transactions;

    private BigDecimal transactionsTotal;

    public WeeklyCategory(int year, int month, int day, CategoryId categoryIDArg) {
        startDate = LocalDate.of(year, month, day);
        endDate = startDate.plusDays(7);
        categoryID = categoryIDArg;
        switch (categoryIDArg) {
            case SUBSCRIPTIONS:
                weeklyBudget = BigDecimal.valueOf(10.46);
                name = "Subscriptions";
            case GROCERIES:
                weeklyBudget = BigDecimal.valueOf(80.00);
                name = "Groceries";
            case COFFEE:
                weeklyBudget = BigDecimal.valueOf(10.00);
                name = "Coffee";
            case TEA:
                weeklyBudget = BigDecimal.valueOf(5.00);
                name = "Tea";
            case FOOD_DELIVERY:
                weeklyBudget = BigDecimal.valueOf(0.00);
                name = "Food Delivery";
            case DINING_OUT:
                weeklyBudget = BigDecimal.valueOf(20.00);
                name = "Dining Out";
            case TOILETRIES:
                weeklyBudget = BigDecimal.valueOf(20.00);
                name = "Toiletries";
            case ELECTRIC:
                weeklyBudget = BigDecimal.valueOf(25.00);
                name = "Electricity Bill";
            case FUN_AND_ACTIVITIES:
                weeklyBudget = BigDecimal.valueOf(20.00);
                name = "Fun/Activities";
            case PUBLIC_TRANSPORTATION:
                weeklyBudget = BigDecimal.valueOf(28.75);
                name = "Public Transportation";
            case UBER_AND_LYFT:
                weeklyBudget = BigDecimal.valueOf(20.00);
                name = "Uber/Lyft/Other";
            case CLOTHES:
                weeklyBudget = BigDecimal.valueOf(15.99);
                name = "Clothes";
            case MEDICAL:
                weeklyBudget = BigDecimal.valueOf(11.00);
                name = "Medical";
            case HOME:
                weeklyBudget = BigDecimal.valueOf(10.00);
                name = "Home";
            case OTHER:
                weeklyBudget = BigDecimal.valueOf(5.00);
                name = "Other";
        }
    }

    public WeeklyCategory(int year, int month, int day, CategoryId categoryIDArg, BigDecimal weeklyBudgetArg) {
        startDate = LocalDate.of(year, month, day);
        endDate = startDate.plusDays(7);
        categoryID = categoryIDArg;
        weeklyBudget = weeklyBudgetArg;
        switch (categoryIDArg) {
            case SUBSCRIPTIONS:
                name = "Subscriptions";
            case GROCERIES:
                name = "Groceries";
            case COFFEE:
                name = "Coffee";
            case TEA:
                name = "Tea";
            case FOOD_DELIVERY:
                name = "Food Delivery";
            case DINING_OUT:
                name = "Dining Out";
            case TOILETRIES:
                name = "Toiletries";
            case ELECTRIC:
                name = "Electricity Bill";
            case FUN_AND_ACTIVITIES:
                name = "Fun/Activities";
            case PUBLIC_TRANSPORTATION:
                name = "Public Transportation";
            case UBER_AND_LYFT:
                name = "Uber/Lyft/Other";
            case CLOTHES:
                name = "Clothes";
            case MEDICAL:
                name = "Medical";
            case HOME:
                name = "Home";
            case OTHER:
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
