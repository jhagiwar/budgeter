package budgeter;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static budgeter.BudgeterApplication.*;
import static budgeter.CategoryId.*;
import static org.junit.Assert.*;

public class BudgeterApplicationTest {
    BudgeterApplication budgeterApplication1 = new BudgeterApplication();
    BudgeterApplication budgeterApplication2 = new BudgeterApplication(2001, 9, 1);
    LocalDate defaultDate = LocalDate.of(2023, 1, 1);
    LocalDate customDate = LocalDate.of(2001, 9, 1);

    @Test
    public void budgeterConstructor() {
//        assertTrue(budgeterApplication1.getLastUpdated().isEqual(defaultDate));
//        assertTrue(budgeterApplication2.getLastUpdated().isEqual(customDate));
    }

    @Test
    public void capitalOneCSVTest() {
        ArrayList<Transaction> capOneList = parseCapitalOneTransactionCSV("/Users/jadeyhagiwara/CodingProjects/budgeter/data/capTestOne.csv", LocalDate.of(2001, 1, 1));
        assertEquals(6, capOneList.size());
//        ArrayList<Transaction> capOneList2 = parseCapitalOneTransactionCSV("/Users/jadeyhagiwara/CodingProjects/budgeter/data/capTestOne.csv", LocalDate.of(2023, 6, 12));
//        assertEquals(4, capOneList2.size());
        BigDecimal sum1 = BigDecimal.valueOf(0.0);
        for (int i = 0; i < 6; i++) {
            sum1 = sum1.add(capOneList.get(i).getTotal());
        }
        BigDecimal sum2 = BigDecimal.valueOf(0.0);
//        for (int j = 0; j < 4; j++) {
//            sum2 = sum2.add(capOneList.get(j).getTotal());
//        }
        assertEquals(BigDecimal.valueOf(-2758.31), sum1);
//        assertEquals(BigDecimal.valueOf(-3189.58), sum2);
    }

    @Test
    public void discoCSVTest() {
        ArrayList<Transaction> discoList = parseDiscoverTransactionsCSV("/Users/jadeyhagiwara/CodingProjects/budgeter/data/discoTestOne.csv", LocalDate.of(2001, 1, 1));
        assertEquals(11, discoList.size());
//        ArrayList<Transaction> discoList2 = parseDiscoverTransactionsCSV("/Users/jadeyhagiwara/CodingProjects/budgeter/data/discoTestOne.csv", LocalDate.of(2023, 6, 13));
//        assertEquals(10, discoList2.size());
        BigDecimal sum1 = BigDecimal.valueOf(0.0);
        for (int i = 0; i < 11; i++) {
            sum1 = sum1.add(discoList.get(i).getTotal());
        }
        BigDecimal sum2 = BigDecimal.valueOf(0.0);
        for (int j = 0; j < 10; j++) {
//            sum2 = sum2.add(discoList2.get(j).getTotal());
        }
        assertEquals(BigDecimal.valueOf(1239.59), sum1);
//        assertEquals(BigDecimal.valueOf(1175.63), sum2);
    }

    @Test
    public void parseCategoryCSVTest() {
        ArrayList<CategoryId> discoCatList = parseCategoryCSV("/Users/jadeyhagiwara/CodingProjects/budgeter/data/categories_for_discoTestOne.csv");
        ArrayList<CategoryId> discoCatListCorrect = new ArrayList<CategoryId>();
        discoCatListCorrect.add(SUBSCRIPTIONS);
        discoCatListCorrect.add(GROCERIES);
        discoCatListCorrect.add(COFFEE);
        discoCatListCorrect.add(TEA);
        discoCatListCorrect.add(FOOD_DELIVERY);
        discoCatListCorrect.add(DINING_OUT);
        discoCatListCorrect.add(TOILETRIES);
        discoCatListCorrect.add(ELECTRIC);
        discoCatListCorrect.add(FUN_AND_ACTIVITIES);
        discoCatListCorrect.add(PUBLIC_TRANSPORTATION);
        discoCatListCorrect.add(UBER_AND_LYFT);
        assertEquals(discoCatList.size(), discoCatListCorrect.size());
        assertEquals(discoCatList, discoCatListCorrect);


        ArrayList<CategoryId> capCatList = parseCategoryCSV("/Users/jadeyhagiwara/CodingProjects/budgeter/data/categories_for_capTestOne.csv");
        ArrayList<CategoryId> capCatListCorrect = new ArrayList<CategoryId>();
        capCatListCorrect.add(SUBSCRIPTIONS);
        capCatListCorrect.add(GROCERIES);
        capCatListCorrect.add(COFFEE);
        capCatListCorrect.add(TEA);
        capCatListCorrect.add(FOOD_DELIVERY);
        capCatListCorrect.add(DINING_OUT);
        assertEquals(capCatList.size(), capCatListCorrect.size());
        assertEquals(capCatList, capCatListCorrect);
    }


}


