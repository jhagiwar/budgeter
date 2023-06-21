package budgeter;

import jdk.vm.ci.meta.Local;
import org.junit.Test;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
public class BudgeterApplicationTest {
    private BudgeterApplication budgeterApplication1= new BudgeterApplication();
    private BudgeterApplication budgeterApplication2= new BudgeterApplication(2001,9,1);
    private LocalDate defaultDate = LocalDate.of(2023,1,1);
    private LocalDate customDate = LocalDate.of(2001,9,1);

    @Test

    public void budgeterConstructoro() {
        assertTrue(budgeterApplication1.getLastUpdated().isEqual(defaultDate));
        assertTrue(budgeterApplication2.getLastUpdated().isEqual(customDate));
    }

}


