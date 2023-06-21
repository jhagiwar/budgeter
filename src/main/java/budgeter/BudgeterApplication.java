package budgeter;

import java.time.LocalDate;

public class BudgeterApplication {

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
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
//		if getLastUpdated /= today call setLastUpdated
//		System.out.println("Updating Everything");
        System.out.println("Ready to review");
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate newLastUpdated) {
//		ALL OF THE UPDATE FUNCTIONS
//		* add all transactions to database
//		* update all weekly categories that need updating/recalculating
//		* update all weekly reviews that need updating/recalculating
        this.lastUpdated = newLastUpdated;
    }
}
