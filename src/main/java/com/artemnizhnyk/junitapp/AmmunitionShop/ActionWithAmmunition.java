package com.artemnizhnyk.junitapp.AmmunitionShop;

import com.artemnizhnyk.junitapp.Ammunition.MotorcycleAmmunition;

import java.util.*;


public class ActionWithAmmunition {

    private Shop shop;

    public ActionWithAmmunition(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void showItemsInfo(List<? extends MotorcycleAmmunition> list) {

        for (MotorcycleAmmunition motorcycleAmmunitions : list) {
            System.out.println(motorcycleAmmunitions);
        }
    }

    public boolean isAmmunitionListNotEmpty(List<? extends MotorcycleAmmunition> list) {

        return !list.isEmpty();
    }

    public String inputIndexValue(String message) {

        Scanner sc = new Scanner(System.in);

        String value = sc.nextLine();

        while (!(isInputIndexValidationTrue(value))) {
            System.out.println(message);
            value = sc.nextLine();
        }

        return value;

    }

    public boolean isInputIndexValidationTrue(String value) {

        return value.matches("^-?[0-9]+$");
    }

    public int parseValue(String value) {

        int number = Integer.parseInt(value);

        return number;
    }


    public String inputYesNoValue(String message) {
        Scanner sc = new Scanner(System.in);

        String value = sc.nextLine();

        while (!(isYesNoValidationTrue(value))) {
            System.out.println(message);
            value = sc.nextLine();
        }

        return value;

    }

    public boolean isYesNoValidationTrue(String value) {

        return value.matches("^(0|1)$");
    }

    public boolean isInputIndexNumberBeInRangeListSize(int number, List<? extends MotorcycleAmmunition> list) {

        return number < list.size() && number >= 0;
    }

    public boolean isDenial(int number) {
        int cancel = -1;

        return number == cancel;
    }

    public boolean isYesOrNo(int number) {

        int yes = 0;
        return number == yes;
    }

    public List<? extends MotorcycleAmmunition> selectAmmunition(List<? extends MotorcycleAmmunition> list) {

        List<MotorcycleAmmunition> selectedItems = new ArrayList<>();

        boolean valid = true;
        if (isAmmunitionListNotEmpty(list)) {

            while (valid) {
                System.out.println("Please make you choose");
                int enterIndexNumber = parseValue(inputIndexValue("Please,try again "));
                if (isDenial(enterIndexNumber)) {
                    break;
                }
                if (isInputIndexNumberBeInRangeListSize(enterIndexNumber, list)) {
                 //   for (int i = 0; i < list.size(); i++) {

                   //     if (i == enterIndexNumber) {
                            selectedItems.add(list.get(enterIndexNumber));
                            valid = false;
                            System.out.println("Do you want to choose more? - Yes(0)/No(1)");
                            int selectYesNo = parseValue(inputYesNoValue("Please,try again "));

                            if (isYesOrNo(selectYesNo)) {
                                valid = true;
                                break;
                            } else {
                                break;
                        //    }
                 //       }
                    }
            //    } else {
            //        System.out.println("Incorrect index number");
                }
            }

        } else {
            System.out.println("No items");
        }

        return selectedItems;
    }

    public List<? extends MotorcycleAmmunition> sortByWeight(List<? extends MotorcycleAmmunition> list) {
        Comparator<MotorcycleAmmunition> comparator = new ClassComparator();

        Collections.sort(list, comparator);

        return list;
    }

    public String inputMaxMinValue(String message) {
        Scanner sc = new Scanner(System.in);

        String value = sc.nextLine();

        while (!(isMaxMinValidationTrue(value))) {
            System.out.println(message);
            value = sc.nextLine();
        }

        return value;

    }

    public boolean isMaxMinValidationTrue(String value) {

        return value.matches("^[0-9]+\\.?[0-9]*$");
    }

    public void findAndShowItemsInRangePrice(List<? extends MotorcycleAmmunition> list) {

        boolean valid = true;

        double minPrice;
        double maxPrice;

        if (isAmmunitionListNotEmpty(list)) {
            while (valid) {
                minPrice = parseValue(inputMaxMinValue("Wrong min value, Please, try again"));
                maxPrice = parseValue(inputMaxMinValue("Wrong max value, Please, try again"));

                if (minPrice < maxPrice && minPrice > 0 && maxPrice > 0) {

                    for (MotorcycleAmmunition motorcycleAmmunition : list) {

                        if (motorcycleAmmunition.getPrice() >= minPrice && motorcycleAmmunition.getPrice() <= maxPrice) {
                            System.out.println(motorcycleAmmunition);
                            valid = false;

                        }
                    }
                    if (valid) {
                        System.out.println("Sorry, we don't have  items  in  this price range , please try again ");
                    }

                } else {
                    System.out.println("Sorry,incorrect values,  please try again ");
                }
            }
        } else {
            System.out.println("No items");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final ActionWithAmmunition that)) return false;
        return Objects.equals(getShop(), that.getShop());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShop());
    }
}
