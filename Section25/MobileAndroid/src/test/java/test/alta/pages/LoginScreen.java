package test.alta.pages;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import test.alta.pageobject.BasePageObject;

public class LoginScreen extends BasePageObject {
    private By emailField() {
        return MobileBy.id("textInputEditTextEmail");
    }
    private By passwordField() {
        return MobileBy.id("textInputEditTextPassword");
    }
    private By loginButton() {
        return MobileBy.id("appCompatButtonLogin");
    }
    private By snackbarError() {
        return MobileBy.id("snackbar_text");
    }

    @Step
    public boolean isOnLoginPage() {
        return waitUntilPresence(loginButton()).isDisplayed();
    }
    @Step
    public void inputEmail(String email) {
        onType(emailField(), email);
    }
    @Step
    public void inputPassword(String password) {
        onType(passwordField(), password);
    }
    @Step
    public void clickLoginButton(){
        onClick(loginButton());
    }
    @Step
    public String getErrorMessage() {
        return waitUntilVisible(snackbarError()).getText();
    }
}
