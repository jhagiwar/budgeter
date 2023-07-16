package budgeter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class WeeklyCategory {
    private int weeklyCatID;
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
        name = categoryIDArg.CatIdtoString();
        switch (categoryIDArg) {
            case SUBSCRIPTIONS:
                weeklyBudget = BigDecimal.valueOf(10.46);
            case GROCERIES:
                weeklyBudget = BigDecimal.valueOf(80.00);
            case COFFEE:
                weeklyBudget = BigDecimal.valueOf(10.00);
            case TEA:
                weeklyBudget = BigDecimal.valueOf(5.00);
            case FOOD_DELIVERY:
                weeklyBudget = BigDecimal.valueOf(0.00);
            case DINING_OUT:
                weeklyBudget = BigDecimal.valueOf(20.00);
            case TOILETRIES:
                weeklyBudget = BigDecimal.valueOf(20.00);
            case ELECTRIC:
                weeklyBudget = BigDecimal.valueOf(25.00);
            case FUN_AND_ACTIVITIES:
                weeklyBudget = BigDecimal.valueOf(20.00);
            case PUBLIC_TRANSPORTATION:
                weeklyBudget = BigDecimal.valueOf(28.75);
            case UBER_AND_LYFT:
                weeklyBudget = BigDecimal.valueOf(20.00);
            case CLOTHES:
                weeklyBudget = BigDecimal.valueOf(15.99);
            case MEDICAL:
                weeklyBudget = BigDecimal.valueOf(11.00);
            case HOME:
                weeklyBudget = BigDecimal.valueOf(10.00);
            case OTHER:
                weeklyBudget = BigDecimal.valueOf(5.00);
        }
    }

    public WeeklyCategory(int year, int month, int day, CategoryId categoryIDArg, BigDecimal weeklyBudgetArg) {
        startDate = LocalDate.of(year, month, day);
        endDate = startDate.plusDays(7);
        categoryID = categoryIDArg;
        weeklyBudget = weeklyBudgetArg;
        name = categoryIDArg.CatIdtoString();
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
