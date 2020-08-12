package com.endava.Twitter;

import com.endava.Twitter.data.DataGenerator;
import com.endava.Twitter.models.Status;
import com.github.javafaker.Faker;

public class TestBaseClass {

    public DataGenerator dataGenerator = new DataGenerator();
    public Faker faker = new Faker();
    public Status status = new Status();
}
