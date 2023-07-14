package budgeter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap; // import the HashMap class

public class WeeklyReview {

    HashMap<CategoryId, WeeklyCategory> categoryIdToWeeklyCategory = new HashMap<CategoryId, WeeklyCategory>();
    private BigDecimal weeklyTotalBudget;
    private BigDecimal weeklyTotalActual;
    private LocalDate startDate;
    private LocalDate endDate;


    public WeeklyReview(LocalDate startDateArg) {
        startDate = startDateArg.minusDays(startDateArg.getDayOfWeek().getValue() - 1);
        endDate = startDate.plusDays(7);
        // search database and find all weeklyCategories with startDate = startDate
//            populate hashmap
//         based on hashmap calculate weekly totals
    }

    public void printWeeklySummary() {
        CategoryId[] categories = CategoryId.values();
        for (int i = 0; i < categories.length; i++) {
            String[] strings = categoryIdToWeeklyCategory.get(categories[i]).getWeeklyCategorySummary();
            System.out.printf("%-10s %-10s %-10s\n", strings[0] + ":", "$" + strings[1], "$" + strings[2]);
        }
        System.out.printf("%-10s %-10s %-10s\n", "TOTAL: ", "$" + weeklyTotalBudget, "$" + weeklyTotalActual);
    }
}
