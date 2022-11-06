package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackCredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        BrowserstackCredentialsConfig config = ConfigFactory.create(BrowserstackCredentialsConfig.class, System.getProperties());
        String login = config.login();
        String password = config.password();
        String app = config.app();
        String device = config.device();
        String osVersion = config.osVersion();
        String project = config.project();
        String build = config.build();
        String name = config.name();

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", login);
        mutableCapabilities.setCapability("browserstack.key", password);
        mutableCapabilities.setCapability("app", app);
        mutableCapabilities.setCapability("device", device);
        mutableCapabilities.setCapability("os_version", osVersion);
        mutableCapabilities.setCapability("project", project);
        mutableCapabilities.setCapability("build", build);
        mutableCapabilities.setCapability("name", name);

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
