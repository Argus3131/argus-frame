package application.webTest.page.baidu;

import lombok.NoArgsConstructor;
import modules.webTestBase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Argus
 * @className BaiduPage
 * @description: Demo
 * @date 2020/11/22 3:55
 * @Version V1.0
 */
@NoArgsConstructor
public class BaiduPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"kw\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"su\"]")
    private WebElement searchButton;

    public BaiduPage(WebDriver driver) {
        super(driver);
    }

    public void search(String keyword) {
        if (keyword == null || keyword.equals("")) {
            searchInput.sendKeys("测试");
        }else {
            searchInput.sendKeys(keyword);
        }
        searchButton.click();
    }


}