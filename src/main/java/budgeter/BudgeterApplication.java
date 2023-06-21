package budgeter;

import java.time.LocalDate;

public class BudgeterApplication {

	private LocalDate lastUpdated;
	private String databasePath = "";

	public BudgeterApplication() {
		lastUpdated = LocalDate.of(2023,1,1);
	}

	public BudgeterApplication(Integer year, Integer month,Integer day) {
		lastUpdated = LocalDate.of(year,month,day);;
	}

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());
		System.out.println(LocalDate.now());
	}

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDate newLastUpdated){
		this.lastUpdated = newLastUpdated;
	}
}
