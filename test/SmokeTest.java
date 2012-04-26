
import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;
import org.junit.*;
import com.testingbot.*;

public class TestLogin extends TestingBotTestCase {

    @Override
    public void setUp() throws Exception {
        TestingBotSelenium selenium = new TestingBotSelenium(
                "hub.testingbot.com",
                4444,
                "firefox",
                "http://pp.myerp.com");
        selenium.start("version=10;platform=WINDOWS;screenshot=true;screenrecorder=false");
        this.selenium = selenium;
    }

    public void testLogin() throws Exception {
        // Opening Login :
        selenium.open("/index.jsp?locale=en_US");
        // Fill Username :
        selenium.type("//*[@id=\"userUsername\"]", "fxbilloir+2@gmail.com");
        selenium.fireEvent("//*[@id=\"userUsername\"]", "blur");
        //Fill Password :
        selenium.type("//*[@id=\"userPassword\"]", "fxbilloir");
        selenium.fireEvent("//*[@id=\"userPassword\"]", "blur");
        Thread.sleep(200);
        selenium.click("css=input[type=\"image\"]");
        selenium.waitForPageToLoad("30000");
    }

    @Override
    public void tearDown() throws Exception {
        this.selenium.stop();
    }
}
