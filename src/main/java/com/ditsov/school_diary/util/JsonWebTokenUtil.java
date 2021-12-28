package com.ditsov.school_diary.util;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.util.ResourceUtils;
import com.ditsov.school_diary.core.entity.role.RoleName;
import com.ditsov.school_diary.core.entity.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class JsonWebTokenUtil {

  private static final String ILLEGAL_KEY_STORE_TYPE_EXCEPTION_MESSAGE =
      "The passed as argument key store type is null.";
  private static final String ILLEGAL_KEY_STORE_PASSWORD_EXCEPTION_MESSAGE =
      "The passed as argument key store password is null.";
  private static final String ROLES_CLAIM = "rol";

  public static Key generateKey(
      final String keyStoreLocation,
      final String keyStoreType,
      final String keyStoreAlias,
      final String keyStorePassword)
      throws Exception {
    if (keyStoreType == null) {
      throw new IllegalArgumentException(ILLEGAL_KEY_STORE_TYPE_EXCEPTION_MESSAGE);
    }
    if (keyStorePassword == null) {
      throw new IllegalArgumentException(ILLEGAL_KEY_STORE_PASSWORD_EXCEPTION_MESSAGE);
    }

    KeyStore keyStore = KeyStore.getInstance(keyStoreType);
    keyStore.load(
        new FileInputStream(ResourceUtils.getFile(keyStoreLocation)),
        keyStorePassword.toCharArray());

    return keyStore.getKey(keyStoreAlias, keyStorePassword.toCharArray());
  }

  public static String generateToken(
      final User user, final String issuer, final Duration expiration, final Key key) {
    Calendar calendar = Calendar.getInstance();
    Date currentDate = calendar.getTime();
    calendar.add(Calendar.SECOND, (int) expiration.getSeconds());
    Date expirationDate = calendar.getTime();

    return Jwts.builder()
        .setIssuer(issuer)
        .setIssuedAt(currentDate)
        .setExpiration(expirationDate)
        .setSubject(user.getUsername())
        .claim(ROLES_CLAIM, user.getAuthorities())
        .signWith(key, SignatureAlgorithm.RS256)
        .compact();
  }

  public static Claims extractClaims(final String token, final Key secretKey) {
    return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
  }

  public static String extractUsername(final Claims claims) {
    return extractClaim(claims, Claims::getSubject);
  }

  private static <T> T extractClaim(final Claims claims, final Function<Claims, T> claimsResolver) {
    return claimsResolver.apply(claims);
  }

  public static List<RoleName> extractRoles(final Claims claims) {
    return ((List<String>) claims.get(ROLES_CLAIM))
        .stream()
        .map(RoleName::valueOf)
        .collect(Collectors.toList());
  }
}
