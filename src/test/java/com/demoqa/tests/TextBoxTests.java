package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase{

    @Test
        void successfulFillFormTest(){
            open("/text-box");

            $("#userName").setValue("John");
            $("#userEmail").setValue("test@email.com");
            $("#currentAddress").setValue("Nowhere");
            $("#permanentAddress").setValue("Here");
            $(byText("Submit")).scrollTo();
            $("#submit").click();

            $("#output").shouldHave(text("John"), text("test@email.com"), text("Nowhere"), text("Here"));

    }

}
