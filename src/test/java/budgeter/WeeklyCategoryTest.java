package budgeter;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeeklyCategoryTest {

    private Transaction transaction1 = new Transaction(2023, 6, 18, BigDecimal.valueOf(5.00), "Capital One", "Goma Tei");
    private Transaction transaction2 = new Transaction(2023, 6, 19, BigDecimal.valueOf(10.00), "Capital One", "Longs");
    private Transaction transaction3 = new Transaction(2023, 6, 21, BigDecimal.valueOf(1.00), "Capital One", "Safeway");
    private Transaction transaction4 = new Transaction(2023, 6, 25, BigDecimal.valueOf(100.00), "Capital One", "ManiPedi");
    
}
