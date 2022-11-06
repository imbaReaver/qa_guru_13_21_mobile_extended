package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:realCredentials.properties")
public interface RealCredentialsConfig extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

}
