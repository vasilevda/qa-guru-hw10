package com.severstal.helpers;

import org.aeonbits.owner.Config;

public interface ServerConfig extends Config {
    @Key("https.server.host")
    String hostname();

    @Key("server.host.login")
    String login();

    @Key("server.host.password")
    String password();
}
