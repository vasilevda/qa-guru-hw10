package com.severstal.helpers;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/ServerConfig.properties")
public interface ServerConfig extends Config {
    @Key("https.server.host")
    String host();

    @Key("server.host.login")
    String login();

    @Key("server.host.password")
    String password();
}
