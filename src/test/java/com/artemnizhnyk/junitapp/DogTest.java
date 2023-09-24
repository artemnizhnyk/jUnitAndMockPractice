package com.artemnizhnyk.junitapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    Dog dog;

    @BeforeEach
    void prepareData() {
        dog = new Dog("Albert", 2);
    }

    @Test
    void getName() {
        assertEquals("Albert", dog.getName());
    }

    @Test
    void testSetDogNameIfNotEmpty() {
        dog.setName("Roman");
        assertEquals("Albert", dog.getName());
    }

    @Test
    void testSetDogNameIfEmpty() {
        Dog dogWithEmptyName = new Dog("", 2);
        dogWithEmptyName.setName("Roman");
        assertEquals("Roman", dogWithEmptyName.getName());
    }

    @Test
    void getAge() {
    }

    @Test
    void setAge() {
    }
}