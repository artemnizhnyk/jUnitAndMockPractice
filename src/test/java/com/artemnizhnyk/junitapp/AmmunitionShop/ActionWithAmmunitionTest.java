package com.artemnizhnyk.junitapp.AmmunitionShop;

import com.artemnizhnyk.junitapp.Ammunition.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActionWithAmmunitionTest {

    Shop getNotEmptyShop(){
        return new Shop(List.of(new MotorcycleHelmet("AnyHelmet", "AnyBrand", 10.1, 1.1, "leather", "leather"))
                , List.of(new MotorcycleGloves("AnyGloves", "AnyBrand", 10.1, 1.1, "S", "leather"))
                , List.of(new MotorcycleJacket("AnyJacket", "AnyBrand", 10.1, 1.1, "M", "black", "leather"))
                , List.of(new MotorcycleTrousers("AnyTrousers", "AnyBrand", 10.1, 1.1, "M", "black", "leather"))
                , List.of(new MotorcycleBoots("AnyBoots", "AnyBrand", 10.1, 1.1, 35, "eir", "red")));
    }
    Shop getEmptyShop(){
        return new Shop(new ArrayList<MotorcycleHelmet>(), new ArrayList<MotorcycleGloves>(), new ArrayList<MotorcycleJacket>(),
                new ArrayList<MotorcycleTrousers>(), new ArrayList<MotorcycleBoots>());
    }

    @Test
    void getEmptyShopTest() {

        ActionWithAmmunition actionWithAmmunition = new ActionWithAmmunition(getEmptyShop());
        assertEquals(getEmptyShop(), actionWithAmmunition.getShop());
    }
    @Test
    void getNotEmptyShopTest(){
        ActionWithAmmunition actionWithAmmunition = new ActionWithAmmunition(getNotEmptyShop());
        assertEquals(getNotEmptyShop(), actionWithAmmunition.getShop());
    }
    @Test
    void setShopTest() {
        ActionWithAmmunition actionWithAmmunition = new ActionWithAmmunition(getEmptyShop());
        Shop notEmptyShop = getNotEmptyShop();
        actionWithAmmunition.setShop(notEmptyShop);
        assertEquals(getNotEmptyShop(), actionWithAmmunition.getShop());
    }

    @Test
    void showItemsInfoTest() {
        String consoleOutput = null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            ActionWithAmmunition action = new ActionWithAmmunition(getNotEmptyShop());
            action.showItemsInfo(action.getShop().getMotorcycleBootsList());
            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        }catch (Exception e){
            e.printStackTrace();
        }
        assertEquals( "AnyBoots- AnyBrand: Price: " + 10.1 + " Weight: " + 1.1 + " BootsSize: " + 35 + " Lacing: eir Color: red\r\n", consoleOutput);
    }

    @Test
    void isAmmunitionListNotEmpty() {
    }

    @Test
    void inputIndexValue() {
    }

    @Test
    void isInputIndexValidationTrue() {
    }

    @Test
    void parseValue() {
    }

    @Test
    void inputYesNoValue() {
    }

    @Test
    void isYesNoValidationTrue() {
    }

    @Test
    void isInputIndexNumberBeInRangeListSize() {
    }

    @Test
    void isDenial() {
    }

    @Test
    void isYesOrNo() {
    }

    @Test
    void selectAmmunition() {
    }

    @Test
    void sortByWeight() {
    }

    @Test
    void inputMaxMinValue() {
    }

    @Test
    void isMaxMinValidationTrue() {
    }

    @Test
    void findAndShowItemsInRangePrice() {
    }


}