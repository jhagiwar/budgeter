package budgeter;

import javax.management.RuntimeErrorException;

public enum CategoryId {
    SUBSCRIPTIONS,
    GROCERIES,
    COFFEE,
    TEA,
    FOOD_DELIVERY,
    DINING_OUT,
    TOILETRIES,
    ELECTRIC,
    FUN_AND_ACTIVITIES,
    PUBLIC_TRANSPORTATION,
    UBER_AND_LYFT,
    CLOTHES,
    MEDICAL,
    HOME,
    OTHER;

    public Integer catIdToIntVal() {
        switch (this) {
            case SUBSCRIPTIONS:
                return 0;
            case GROCERIES:
                return 1;
            case COFFEE:
                return 2;
            case TEA:
                return 3;
            case FOOD_DELIVERY:
                return 4;
            case DINING_OUT:
                return 5;
            case TOILETRIES:
                return 6;
            case ELECTRIC:
                return 7;
            case FUN_AND_ACTIVITIES:
                return 8;
            case PUBLIC_TRANSPORTATION:
                return 9;
            case UBER_AND_LYFT:
                return 10;
            case CLOTHES:
                return 11;
            case MEDICAL:
                return 12;
            case HOME:
                return 13;
            case OTHER:
                return 14;
        }
        return -1;
    }

    public CategoryId intValToCatId(Integer intVal) {
        switch (intVal) {
            case 0:
                return SUBSCRIPTIONS;
            case 1:
                return GROCERIES;
            case 2:
                return COFFEE;
            case 3:
                return TEA;
            case 4:
                return FOOD_DELIVERY;
            case 5:
                return DINING_OUT;
            case 6:
                return TOILETRIES;
            case 7:
                return ELECTRIC;
            case 8:
                return FUN_AND_ACTIVITIES;
            case 9:
                return PUBLIC_TRANSPORTATION;
            case 10:
                return UBER_AND_LYFT;
            case 11:
                return CLOTHES;
            case 12:
                return MEDICAL;
            case 13:
                return HOME;
            case 14:
                return OTHER;
        }
        throw new RuntimeException("not a valid category id");
    }

    public String CatIdtoString() {
        switch (this) {
            case SUBSCRIPTIONS:
                return "Subscriptions";
            case GROCERIES:
                return "Groceries";
            case COFFEE:
                return "Coffee";
            case TEA:
                return "Tea";
            case FOOD_DELIVERY:
                return "Food Delivery";
            case DINING_OUT:
                return "Dining Out";
            case TOILETRIES:
                return "Toiletries";
            case ELECTRIC:
                return "Electricity Bill";
            case FUN_AND_ACTIVITIES:
                return "Fun/Activities";
            case PUBLIC_TRANSPORTATION:
                return "Public Transportation";
            case UBER_AND_LYFT:
                return "Uber/Lyft/Other";
            case CLOTHES:
                return "Clothes";
            case MEDICAL:
                return "Medical";
            case HOME:
                return "Home";
            case OTHER:
                return "Other";
        }
        throw new RuntimeException("not a valid categoryId");
    }

    public CategoryId stringToCatId(String str) {

        switch (str) {
            case "Subscriptions":
                return SUBSCRIPTIONS;
            case "Groceries":
                return GROCERIES;
            case "Coffee":
                return COFFEE;
            case "Tea":
                return TEA;
            case "Food Delivery":
                return FOOD_DELIVERY;
            case "Dining Out":
                return DINING_OUT;
            case "Toiletries":
                return TOILETRIES;
            case "Electricity Bill":
                return ELECTRIC;
            case "Fun/Activities":
                return FUN_AND_ACTIVITIES;
            case "Public Transportation":
                return PUBLIC_TRANSPORTATION;
            case "Uber/Lyft/Other":
                return UBER_AND_LYFT;
            case "Clothes":
                return CLOTHES;
            case "Medical":
                return MEDICAL;
            case "Home":
                return HOME;
            case "Other":
                return OTHER;
        }
        throw new RuntimeException("not a valid categoryId");
    }


}

