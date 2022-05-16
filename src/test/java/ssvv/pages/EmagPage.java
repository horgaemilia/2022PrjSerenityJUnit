package ssvv.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("https://www.emag.ro/")
public class EmagPage extends PageObject {

    @FindBy(id = "searchboxTrigger")
    WebElementFacade searchInput;

    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div/div[2]/div/form/div[1]/div[2]/button[2]")
    WebElementFacade searchButton;

    @FindBy(xpath = "//*[@id=\"main-container\"]/section[1]/div/div[3]/div[2]/div[1]/div[1]/div[1]/span[2]")
    WebElementFacade searchPageTitle;

    @FindBy(xpath = "//*[@id=\"card_grid\"]/div[1]/div/div/div[4]/div[2]/form/button")
    WebElementFacade addToCartFirstElementButton;

    String acceptCookiesButtonSelector = "body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.pad-sep-xs.pad-hrz-none.show > div > div.col-xs-12.col-sm-5.col-md-4.col-lg-3.cookie-banner-buttons > button.btn.btn-primary.js-accept.gtm_h76e8zjgoo.btn-block";

    String closeCartPopupSelector = "body > div.gdpr-cookie-banner.js-gdpr-cookie-banner.pad-sep-xs.pad-hrz-none.login-view.login-view-ro.show > div > button > i";

    String cartPopupElementNameSelector = "body > div.ph-modal.modal.fade.product-purchased-modal.modal-version-.in > div > div > div.modal-body.modal-content-extra-padding.pad-sep-xs.hidden-xs > div > div.table-cell.col-xs-12.col-sm-12.col-md-9 > div > div.table-cell.col-xs-8.col-sm-8 > span";

    public void enter_keywords(String keyword) {
        searchInput.type(keyword);
    }

    public void lookup_terms() {
        searchButton.click();
    }

    public void acceptCookies()
    {
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(acceptCookiesButtonSelector)));
        cookieButton.click();
    }

    public void clickCloseCartPopupSelector()
    {
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        WebElement cartPopup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(closeCartPopupSelector)));
        cartPopup.click();
    }

    public String getTitleFromSearchPage()
    {
        return searchPageTitle.getText();
    }

    public void addFirstElementToCart()
    {
        addToCartFirstElementButton.click();
    }

    public String getTitleFromCartPopup()
    {
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        WebElement cartTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(cartPopupElementNameSelector)));
        return cartTitle.getText();
    }
}
