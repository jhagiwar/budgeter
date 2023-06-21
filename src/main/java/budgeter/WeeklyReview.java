package budgeter;

import java.time.LocalDate;
import java.util.HashMap; // import the HashMap class

public class WeeklyReview {

    HashMap<CategoryId, Double> capitalCities = new HashMap<CategoryId, Double>();
    private Double weeklyTotalBudget;
    private Double weeklyTotalActual;
    private LocalDate startDate;
    private LocalDate endDate;


    public WeeklyReview(LocalDate startDateArg) {
        startDate = startDateArg.minusDays(startDateArg.getDayOfWeek().getValue() - 1);
        endDate = startDate.plusDays(7);
        // search database and find all transactions with weekstart date start date

    }
}
