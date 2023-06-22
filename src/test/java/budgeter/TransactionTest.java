package budgeter;

import java.time.LocalDate;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {

    private Transaction transaction1 = new Transaction(2023, 6, 21, 20.59, "Capital One", "Goma Tei");
    private Transaction transaction2 = new Transaction(2023, 5, 1, 5.99, "Discover", "Taste Tea");

    @Test
    public void settingCategoryId() {
        assertNull(transaction1.getCategoryID());
        transaction1.setCategoryID(CategoryId.DINING_OUT);
        assertTrue(transaction1.getCategoryID() == CategoryId.DINING_OUT);
    }

    @Test
    public void weekOfStartDate() {
        assertTrue(transaction1.getWeekStartDate().isEqual(LocalDate.of(2023, 6, 19)));
        assertTrue(transaction2.getWeekStartDate().isEqual(LocalDate.of(2023, 5, 1)));
    }
}
