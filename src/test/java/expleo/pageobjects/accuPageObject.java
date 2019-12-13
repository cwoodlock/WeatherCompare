package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class accuPageObject {

    @FindBy(how = How.XPATH, using = "html/body/div[1]/div[1]/div[2]/div[1]/form/input")
    private WebElement SearchBar;
    @FindBy(how = How.XPATH, using = "html/body/div[1]/div[1]/div[2]/div[1]/svg[1]")
    private WebElement SearchBtn;

    public void enterCity(String text){
        SearchBar.clear();
        SearchBar.sendKeys(text);
    }

    public void ClickSearchBtn(){
        SearchBtn.click();

    }
}
