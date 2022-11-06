package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:emulationCredentials.properties")
public interface EmulationCredentialsConfig extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

}
