package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String userName = "Alex Egorov";

        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue(userName);
        $("#userEmail").setValue("qaguru@qa.gu");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Other address 1");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave((text(userName)));
        $("#output #email").shouldHave((text("qaguru@qa.gu")));
        // todo check addresses
    }
}
