package com.demoqa.tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class TestData {
    static String[]
            genders = {"Male", "Female", "Other"},
            subjects = {"Accounting", "Maths", "Arts", "Physics", "English", "Chemistry",
                    "Computer Science", "Commerce", "Economics", "Social Studies", "Biology", "History", "Civics"},
            hobbies = {"Sports", "Reading", "Music"},
            state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            cityNCR = {"Delhi", "Gurgaon", "Noida"},
            cityUttarPradesh = {"Agra", "Lucknow", "Merrut"},
            cityHaryana = {"Karnal", "Panipat"},
            cityRajastan = {"Jaipur", "Jaiselmer"};


    static Faker faker = new Faker(new Locale("en"));
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            fullname = firstName + " " + lastName,
            emailAddress = faker.internet().emailAddress(),
            gender = faker.options().option(genders),
            address = faker.address().fullAddress(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            subject = faker.options().option(subjects),
            hobby = faker.options().option(hobbies),
            userState = faker.options().option(state);


    Date date = faker.date().birthday(18, 60);
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    public String[] randomDate = formatter.format(date).split(" ");
    public String birthDate = randomDate[0] + " " + randomDate[1] + "," + randomDate[2];


    public String userCity(String value) {
        String city = new String();
        if (Objects.equals(value, "NCR")) {
            city = faker.options().option(cityNCR);
        } else if (Objects.equals(value, "Uttar Pradesh")) {
            city = faker.options().option(cityUttarPradesh);
        } else if (Objects.equals(value, "Haryana")) {
            city = faker.options().option(cityHaryana);
        } else if (Objects.equals(value, "Rajasthan")) {
            city = faker.options().option(cityRajastan);
        }
        return city;
    }

    public String fullAddress = userState + " " + userCity(userState);





}





