package com.pages.SearchPage;

import com.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//body/main[@id='main-content']/div[1]/section[2]/div[1]/div[3]/div[1]/ul[1]/li[1]")
    public List<WebElement> listOfSearchProducts;

    @FindBy(xpath = "//*[@id=\"quickSearch\"]/div/section/ul/li[*]/article/figure/figcaption/div/a")
    public List<WebElement> addToCart;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[1]/section[1]")
    public WebElement quickSearchResult;

    @FindBy(xpath = "//*[@id=\"quickSearch\"]/div/section/button")
    public WebElement quickSearchResultCloseBar;

    public SearchResultPage() throws IOException {
        super();
    }

    public boolean isQuickSearchResultDisplayed() {
        //app.explicitWait(driver,quickSearchResult, 30);
        return this.quickSearchResult.isDisplayed();
    }

    public boolean isQuickSearchResultCloseBarEnabled() {
        return this.quickSearchResultCloseBar.isEnabled();
    }

    public void clickQuickSearchResultCloseBar() {
       waitForWebElementAndClick(this.quickSearchResultCloseBar);
    }

    public void verifyListOfProductItemSearchResultAndClickOnProducts(String productsName) {
            List<WebElement> productsNames = listOfSearchProducts;
            Iterator<WebElement> itr = productsNames.iterator();
            while (itr.hasNext()) {
                WebElement c = itr.next();
                String text = c.getText().trim().toString();
                if (text.equals(productsName)) {
                    System.out.println("selecting date as: " + productsName);
                    c.click();
                    break;
                }
            }
        }

    }


/*        String [] itemsNeeded = {"Canvas Laundry Cart", "Laundry Detergent"};
        List<WebElement> products = getDriver().findElements(By.xpath("//body/main[@id='main-content']/div[1]/section[2]/div[1]/div[3]/div[1]/ul[1]/li"));
        //app.explicitWait(driver, quickSearchResult, 30);

        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();

            List itemNeededList = Arrays.asList(itemsNeeded);

            {
                if (itemNeededList.contains(name))
                    Thread.sleep(2000);

                    products.get(i).click();
                    Thread.sleep(10000);

            }
        }

    }
}*/











       /* for(WebElement j: products)
        {
            String name = j.getText();
            System.out.println("=====================");
            System.out.println(name);
            System.out.println("=====================");
            Thread.sleep(1000);
            if(name.contains("S Shaped Scrub Brush"))
            {
                app.JSClick(driver, j);
                Thread.sleep(5000);
                break;
            }
        }


   */




