package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class FormTestWithPageObjectsTest extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage("Student Registration Form")
                        .hideBanner()
                        .setFirstName("John")
                        .setSurname("Doe")
                        .setEmail("test@test.com")
                        .setGender("Other")
                        .setUserNumber("1234567890")
                        .setBirthDate("18", "July", "2000")
                        .setSubject("English")
                        .setHobby("Sports")
                        .picture()
                        .setAddress("Jean Marot street")
                        .setState("Uttar Pradesh")
                        .setCity("Agra")
                        .submit();


        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", "John Doe")
                .verifyResult("Student Email", "test@test.com")
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "18 July,2000")
                .verifyResult("Subjects", "English")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "image.jpeg")
                .verifyResult("Address", "Jean Marot street")
                .verifyResult("State and City", "Uttar Pradesh Agra");

    }
}

