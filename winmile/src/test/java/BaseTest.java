import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class BaseTest {




    @Test
    public  void search() {
        System.setProperty("webdriver.chrome.driver", "D:/Projects/Automation/Yashaka/App/winmile/chromedriver.exe");
        Configuration.browser = "chrome";
        open("http://todomvc.com/examples/emberjs/");                      // открываем браузер и загружаем страницу
        $("#new-todo").setValue("a").pressEnter();
        $("#new-todo").setValue("b").pressEnter();
        $("#new-todo").setValue("c").pressEnter();

        $$("#todo-list>li").shouldHaveSize(3);
        $$("#todo-list>li").findBy(exactText("b")).find(".toggle").click();
        $$("todo-list>li").filterBy(cssClass("completed")).shouldHave(texts("b"));
    }
}