package pageobjects;

//Author: Paul Byrne

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WSAHomePO {

    private WebElement search;
    private WebElement submitsearch;

    public void enterSearch(String text){
        search.clear();
        search.sendKeys(text);
    }

    public void submitSearch(){
        submitsearch.submit();

    }
}
