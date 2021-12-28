package com.ditsov.school_diary.config.properties;

import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.application")
public class ApplicationProperties {

  private String name;
  @NestedConfigurationProperty private SecurityProperties security;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SecurityProperties getSecurity() {
    return security;
  }

  public void setSecurity(SecurityProperties security) {
    this.security = security;
  }

  public static class SecurityProperties {
    private JwtProperties jwt;

    public JwtProperties getJwt() {
      return jwt;
    }

    public void setJwt(JwtProperties jwt) {
      this.jwt = jwt;
    }
  }

  public static class JwtProperties {
    private Duration expiration;
    private SecretKeyProperties secretKey;

    public Duration getExpiration() {
      return expiration;
    }

    public void setExpiration(Duration expiration) {
      this.expiration = expiration;
    }

    public SecretKeyProperties getSecretKey() {
      return secretKey;
    }

    public void setSecretKey(SecretKeyProperties secretKey) {
      this.secretKey = secretKey;
    }
  }

  public static class SecretKeyProperties {
    private KeyStoreProperties keyStore;

    public KeyStoreProperties getKeyStore() {
      return keyStore;
    }

    public void setKeyStore(KeyStoreProperties keyStore) {
      this.keyStore = keyStore;
    }
  }

  public static class KeyStoreProperties {
    private String location;
    private String type;
    private String alias;
    private String password;

    public String getLocation() {
      return location;
    }

    public void setLocation(String location) {
      this.location = location;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getAlias() {
      return alias;
    }

    public void setAlias(String alias) {
      this.alias = alias;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }
}
