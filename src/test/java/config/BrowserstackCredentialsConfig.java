package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:browserstackCredentials.properties")
public interface BrowserstackCredentialsConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("osVersion")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();

}
