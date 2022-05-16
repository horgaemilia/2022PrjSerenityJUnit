package ssvv.features.search;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ssvv.steps.serenity.EmagUserSteps;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagTestData.csv")
public class EmagDDT {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.emag.ro/")
    public Pages pages;

    public String name;
    public String title;


    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Steps
    public EmagUserSteps endUser;


    public  void acceptCookies()
    {
        endUser.acceptCookies();
    }

    public  void closeCartPopup()
    {
        endUser.closeCartPopup();
    }

    @Issue("#WIKI-1")
    @Test
    public void searchWikiByKeywordTestDDT() {
        endUser.is_the_home_page();
        acceptCookies();
        closeCartPopup();
        endUser.looks_for(getName());
        endUser.should_see_title(getTitle());
    }

    @Test
    public void addElementToCartDDT() {
        endUser.is_the_home_page();
        acceptCookies();
        closeCartPopup();
        endUser.looks_for(getName());
        endUser.addToCart();
        endUser.goToCart();
        endUser.should_see_cart_title(getTitle());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void srtTitle(String definition) {
        this.title = definition;
    }
}
