package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;

public class FormTestWithPageObjectsAndFakerData extends TestBase {

        RegistrationPage registrationPage = new RegistrationPage();
        TestData testData = new TestData();

        @Test
        void successfulRegistrationTest() {

            registrationPage
                    .openPage("Student Registration Form")
                    .hideBanner()
                    .setFirstName(firstName)
                    .setSurname(lastName)
                    .setEmail(emailAddress)
                    .setGender(gender)
                    .setUserNumber(phoneNumber)
                    .setBirthDate(testData.randomDate[0], testData.randomDate[1], testData.randomDate[2])
                    .setSubject(subject)
                    .setHobby(hobby)
                    .picture()
                    .setAddress(address)
                    .setState(userState)
                    .setCity(testData.userCity(testData.userState))
                    .submit();

            registrationPage.verifyRegistrationResultsModalAppears()
                    .verifyResult("Student Name", fullname)
                    .verifyResult("Student Email", emailAddress)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", phoneNumber)
                    .verifyResult("Date of Birth", testData.birthDate)
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobby)
                    .verifyResult("Picture", "image.jpeg")
                    .verifyResult("Address", address)
                    .verifyResult("State and City", testData.fullAddress);

        }
    }