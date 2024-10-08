package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;

    By pageTitle = By.xpath("//h1[1]");

    //radio buttons
    By radioBtnLabel = By.xpath("//div[@id='radio-btn-example']/fieldset/legend");
    By radioBtn1 = By.cssSelector("input[value='radio1']");
    By radioBtn2 = By.cssSelector("input[value='radio2']");
    By radioBtn3 = By.cssSelector("input[value='radio3']");

    //suggestion country elements
    By selectSuggestionLabel = By.xpath("//div[@id='select-class-example']/fieldset/legend");
    By inputSelectSuggestion = By.cssSelector("input[placeholder='Type to Select Countries']");
    By suggestedCountry = By.cssSelector("div[class='ui-menu-item-wrapper']");

    //dropdown menu elements
    By dropDownLabel = By.xpath("//legend[contains(normalize-space(.), \"Dropdown Example\")]");
    By btnDropdown = By.cssSelector("select[id='dropdown-class-example']");
    By dropdownOption1 = By.cssSelector("option[value='option1']");
    By dropdownOption2 = By.cssSelector("option[value='option2']");
    By dropdownOption3 = By.cssSelector("option[value='option3']");

    //checkbox elements
    By checkBoxLabel = By.cssSelector("div[id='checkbox-example'] > fieldset > legend");
    By option1Label = By.xpath("//div[@id='checkbox-example']/fieldset/label[@for='bmw']");
    By option2Label = By.xpath("//div[@id='checkbox-example']/fieldset/label[@for='benz']");
    By option3Label = By.xpath("//div[@id='checkbox-example']/fieldset/label[@for='honda']");
    By checkBox1 = By.cssSelector("input[id='checkBoxOption1']");
    By checkBox2 = By.cssSelector("input[id='checkBoxOption2']");
    By checkBox3 = By.cssSelector("input[id='checkBoxOption3']");

    //switch window elements
    By switchWindowLabel = By.xpath("//div[@class='left-align']/fieldset/legend[contains(text(),'Switch Window Example')]");
    By switchWindowBtn = By.cssSelector("button[id='openwindow']");

    //switch tab elements
    By switchTabBtn = By.cssSelector("a[id='opentab']");

    //Alert elements
    By alertInputBox = By.cssSelector("input[name='enter-name']");
    By btnAlert = By.cssSelector("input[id='alertbtn']");
    By confirmAlert = By.cssSelector("input[id='confirmbtn']");

    //table
    By tableProduct = By.xpath("(//table[@id='product'])[1]");
    By  courseList = By.xpath("(//table[@id='product'])[1]//td[3]");

    //hide & show
    By btnHide = By.cssSelector("input[id='hide-textbox']");
    By btnShow = By.cssSelector("input[id='show-textbox']");
    By inputBoxShowHide = By.cssSelector("input[id='displayed-text']");

    //tableFixHead
    By tableFix = By.xpath("//div[@class='tableFixHead']");

    //mouse hover
    By btnMouseHover = By.cssSelector("button[id='mousehover']");
    By panelMouseHover = By.cssSelector("div[class=\"mouse-hover-content\"]");
    By btnAnchorChild1 = By.cssSelector("div[class=\"mouse-hover-content\"] > a:nth-child(1)");
    By btnAnchorChild2 = By.cssSelector("div[class=\"mouse-hover-content\"] > a:nth-child(2)");

    // iframe
    By iframeCourses = By.cssSelector("iframe[id='courses-iframe']");
    By priceTitle = By.cssSelector("div[class='price-title'] h2");

    public HomePage(WebDriver driver) {
        // TODO Auto-generated constructor stub

        this.driver=driver;

    }

    public WebElement getTitle()
    {
        return driver.findElement(pageTitle);
    }

    public WebElement getRadioBtn1()
    {
        return driver.findElement(radioBtn1);
    }

    public WebElement getRadioBtn2()
    {
        return driver.findElement(radioBtn2);
    }

    public WebElement getRadioBtn3()
    {
        return driver.findElement(radioBtn3);
    }

    public WebElement getRadioBtnLabel()
    {
        return driver.findElement(radioBtnLabel);
    }

    public WebElement getSelectSuggestionLabel()
    {
        return driver.findElement(selectSuggestionLabel);
    }

    public WebElement getInputSelectSuggestion()
    {
        return driver.findElement(inputSelectSuggestion);
    }

    public WebElement getSuggestedCountry()
    {
        return driver.findElement(suggestedCountry);
    }

    public WebElement getDropDownLabel()
    {
        return driver.findElement(dropDownLabel);
    }

    public WebElement getBtnDropdown() { return driver.findElement(btnDropdown); }

    public WebElement getDropdownOption1()
    {
        return driver.findElement(dropdownOption1);
    }

    public WebElement getDropdownOption2()
    {
        return driver.findElement(dropdownOption2);
    }

    public WebElement getDropdownOption3() { return driver.findElement(dropdownOption3); }

    public WebElement getCheckBoxLabel() { return driver.findElement(checkBoxLabel); }

    public WebElement getOption1Label() { return driver.findElement(option1Label); }

    public WebElement getOption2Label() { return driver.findElement(option2Label); }

    public WebElement getOption3Label() { return driver.findElement(option3Label); }

    public WebElement getCheckBox1() { return driver.findElement(checkBox1); }

    public WebElement getCheckBox2() { return driver.findElement(checkBox2); }

    public WebElement getCheckBox3() { return driver.findElement(checkBox3); }

    public WebElement getSwitchWindowLabel() { return driver.findElement(switchWindowLabel); }

    public WebElement getSwitchWindowBtn() { return driver.findElement(switchWindowBtn); }

    public WebElement getSwitchTabBtn() { return driver.findElement(switchTabBtn); }

    public WebElement getAlertInputBox() { return driver.findElement(alertInputBox); }

    public WebElement getBtnAlert() { return driver.findElement(btnAlert); }

    public WebElement getConfirmAlert() { return driver.findElement(confirmAlert); }

    public WebElement getTableProduct() { return driver.findElement(tableProduct); }

    public WebElement getCourseList() { return (WebElement) driver.findElements(courseList); }

    public WebElement getBtnHide() { return driver.findElement(btnHide); }

    public WebElement getBtnShow() { return driver.findElement(btnShow); }

    public WebElement getInputBoxShowHide() { return driver.findElement(inputBoxShowHide); }

    public WebElement getTableFix() { return  driver.findElement(tableFix); }

    public WebElement getBtnMouseHover() { return  driver.findElement(btnMouseHover); }

    public WebElement getPanelMouseHover() { return  driver.findElement(panelMouseHover); }

    public WebElement getBtnAnchorChild1() { return  driver.findElement(btnAnchorChild1); }

    public WebElement getBtnAnchorChild2() { return  driver.findElement(btnAnchorChild2); }

    public WebElement getIframeCourses() { return  driver.findElement(iframeCourses); }

    public WebElement getPriceTitle() { return  driver.findElement(priceTitle); }
}
