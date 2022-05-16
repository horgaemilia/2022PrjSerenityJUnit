package ssvv.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import ssvv.pages.EmagPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EmagUserSteps {

    EmagPage emagPage;

    @Step
    public void enters(String keyword) {
        emagPage.enter_keywords(keyword);
    }

    @Step
    public void is_the_home_page() {
        emagPage.open();
    }

    @Step
    public void starts_search() {
        emagPage.lookup_terms();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void acceptCookies()
    {
        emagPage.acceptCookies();
    }

    @Step
    public void closeCartPopup()
    {
        emagPage.clickCloseCartPopupSelector();
    }

    @Step
    public void addToCart()
    {
        emagPage.addFirstElementToCart();
    }

    @Step
    public void should_see_title(String title) {
        assertThat(emagPage.getTitleFromSearchPage(), containsString(title));
    }

    @Step
    public void should_see_cart_title(String title)
    {
        assertThat(emagPage.getTitleFromCartPopup(),containsString(title));
    }
}
