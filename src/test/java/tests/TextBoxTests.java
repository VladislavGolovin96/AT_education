package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void successfulSearchTest() {
        open("text-box/");
        $("#userName").setValue("Vladislav");
        $("#userEmail").setValue("vlad@gmail.com");
        $("#currentAddress").setValue("Chistopolskaya99");
        $("#permanentAddress").setValue("Chistopolskaya91");
        $("#submit").click();

        $("#output #name").shouldHave(text("Vladislav"));
        $("#output #email").shouldHave(text("vlad@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Chistopolskaya99"));
        $("#output #permanentAddress").shouldHave(text("Chistopolskaya91"));

    }
}
