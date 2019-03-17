package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class DuckDuckGoResultsPage extends AbstractPage {

    public final static By resultsLink = By.cssSelector("div.result:not(.result--more) a.result__a");

    public DuckDuckGoResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultsLinkText() {
        // Wait for results to appear
        getWait().until(ExpectedConditions.titleContains("giant panda"));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.result:not(.result--more)")));

        // Make sure each result contains the word "panda"
        List<WebElement> resultLinks = getDriver().findElements(resultsLink);
        List<String> linkTexts = resultLinks.stream().map(WebElement::getText).collect(Collectors.toList());

        return linkTexts;
    }
}