package com.devonfw.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capgemini.mrchecker.selenium.core.BasePage;
import com.capgemini.mrchecker.test.core.logger.BFLogger;
import com.devonfw.mts.common.utils.Utils;

/**
 * @author Juan Andrés Ambuludi Olmedo
 * @author Jorge Dacal Cantos
 * @author Carlos Micó Egea
 */
public class ThaiLoginPage extends BasePage {

  /* Search criteria */
  private static final By usernameSearch = By.name("username");

  private static final By passwordSearch = By.name("password");

  private static final By accessButtonSearch = By.name("submitLogin");

  @Override
  public boolean isLoaded() {

    WebElement usernameTextBox = getDriver().findElementDynamic(passwordSearch);
    return usernameTextBox.isDisplayed();
  }

  @Override
  public void load() {

    BFLogger.logError("MyThaiStar login page was not loaded.");
  }

  @Override
  public String pageTitle() {

    return "";
  }

  /**
   * Seek for username and password text fields and writes an username and a password then the accept button is clicked
   *
   * @param username an username to log in
   * @param password the password for the username
   */
  public void enterCredentials(String username, String password) {

    WebDriverWait driverWait = new WebDriverWait(getDriver(), 10);
    WebElement usernameTextBox = getDriver().findElementDynamic(usernameSearch);
    WebElement passwordTextBox = getDriver().findElementDynamic(passwordSearch);
    WebElement accessButton;

    Utils.sendKeysWithCheck(username, usernameSearch, getDriver(), getWebDriverWait());
    Utils.sendKeysWithCheck(password, passwordSearch, getDriver(), getWebDriverWait());

    // Wait until all the password has been written
    // driverWait
    // .until((driver) -> driver.findElement(passwordSearch).getAttribute("value").length() == password.length());
    accessButton = getDriver().findElementDynamic(accessButtonSearch);
    accessButton.click();
  }
}
