package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.tests.FormTestWithFakerData.userEmail;
import static com.demoqa.tests.TestData.*;

public class FormTestWithTestData extends TestData {


        @Test
        void formTestWithTestData() {
            open("/automation-practice-form");

            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            $(byText("Submit")).scrollTo();

            $("#firstName").setValue(firstName); //first name
            $("#lastName").setValue(lastName);// last name
            $("#userEmail").setValue(userEmail); // email address
            $("#gender-radio-2").parent().click(); // gender radio button
            $("#userNumber").setValue("1234567890"); // phone number

            //date of birth
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").parent().click();
            $(byText("February")).click();
            $(".react-datepicker__year-select").click();
            $(byText("1993")).click();
            $(byText("18")).click();

            $("#subjectsInput").setValue("English").pressEnter(); //subject
            $("#hobbies-checkbox-1").parent().click(); // hobby checkbox checked
            $("#uploadPicture").uploadFromClasspath("image.jpeg"); //upload image
            $("#currentAddress").click(); // address field
            $("#currentAddress").setValue("Jean Marot street"); // fill in address
            $(byText("Select State")).click(); //state drop-down
            $("#react-select-3-option-1").click(); //select state
            $(byText("Select City")).click(); // city drop-down
            $("#react-select-4-option-0").click(); //select city
            $("#submit").click();

            $(".table").shouldHave(text(firstName), text(lastName), text(userEmail), text("1234567890"),
                    text("Female"), text("18 February,1993"), text("English"), text("Jean Marot street"));

        }
    }

