package com.artemnizhnyk.junitapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarTest {
    Car car;
    @Mock
    Car newCar;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    void createCar() {
        car = new Car("Audi", "A4253N", 2020, "Artem");
    }

    @Test
    void createCarMockito(){
        assertEquals(null, newCar.getBrand());

    }

    @Test
    void remoteServiceReturnValue(){
        when(newCar.testInt(4)).thenReturn(10);
        assertEquals(10, newCar.testInt(4));
    }
    @Test
    void getOwnerMockito(){
        when(newCar.getOwner()).thenReturn("Daniel");
        assertEquals("Daniel", newCar.getOwner());
    }

    @Test
    void verificationTest(){
        newCar.testInt(4);
        verify(newCar, times(1)).testInt(4);
    }

    @Test
    void getBrand() {
        assertEquals("Audi", car.getBrand());
    }

    @Test
    void getIdentificationNumber() {
        assertEquals("A4253N", car.getIdentificationNumber());
    }

    @Test
    void setIdentificationNumber() {
        car.setIdentificationNumber("N3524A");
        assertEquals("N3524A", car.getIdentificationNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC-123", "DEF-546", "DFG-434"})
    @NullSource
    @EmptySource
    void setIdentificationNumberMultiplyValuesTest(String number) {
        car.setIdentificationNumber(number);
        assertEquals(number, car.getIdentificationNumber());
    }

    @ParameterizedTest
    @CsvSource({"1,5", "6,10", "32,36"})
    void csvTest(int input, int output) {
        assertEquals(output, car.testInt(input));
    }

    @Test
    void getYearTest1() {
        assertEquals(2020, car.getYear());
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @EnabledOnJre(JRE.JAVA_17)
    void getYearTest2() {
        assertEquals(2020, car.getYear());
    }

    @Test
    void getOwner() {
        assertEquals("Artem", car.getOwner());
    }

    @Test
    void setOwner() {
        car.setOwner("Daniel");
        assertEquals("Daniel", car.getOwner());
    }

    @Test
    void getOwnersConstructorTest() {
        assertArrayEquals(new String[]{"Artem"}, car.getOwners().toArray());
    }

    @Test
    void getOwnersAfterSetMethodTest() {
        car.setOwner("Daniel");
        assertArrayEquals(new String[]{"Artem", "Daniel"}, car.getOwners().toArray());
    }

    @Test
    void testPrivateMethod() {

        try {
            Method method = Car.class.getDeclaredMethod("testPrivateMethod", null);
            method.setAccessible(true);
            assertEquals(method.invoke(car).toString(), "abc");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @ParameterizedTest
    @DisplayName("Test demonstrates how test data could be loaded from file")
    @CsvFileSource(resources = "/test-data.csv", delimiter = '|', numLinesToSkip = 1)
    void testNumbers(String input, String expected) {
        car.setIdentificationNumber(input);
        assertEquals(expected, car.getIdentificationNumber());
    }

    @Test
    void getTestData() {
        assertThrows(Exception.class, () -> {
            car.getDataFromRemoteServer();
        });
    }
}