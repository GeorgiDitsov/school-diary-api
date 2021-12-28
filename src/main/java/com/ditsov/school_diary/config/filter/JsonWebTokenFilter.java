package com.ditsov.school_diary.config.filter;

import static com.ditsov.school_diary.util.JsonWebTokenUtil.extractClaims;
import static com.ditsov.school_diary.util.JsonWebTokenUtil.extractRoles;
import static com.ditsov.school_diary.util.JsonWebTokenUtil.extractUsername;
import static com.ditsov.school_diary.util.JsonWebTokenUtil.generateKey;
import java.io.IOException;
import java.security.Key;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.ditsov.school_diary.config.properties.ApplicationProperties;
import com.ditsov.school_diary.core.entity.role.RoleName;
import io.jsonwebtoken.Claims;

@Component
public class JsonWebTokenFilter extends OncePerRequestFilter {

  private static final String TOKEN_REGEX = "^Bearer ([a-zA-Z0-9-._~+/]+=*)$";
  private static final String SPACE = " ";

  @Autowired private ApplicationProperties applicationProperties;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
    String token = null;
    String username = null;
    List<RoleName> roles = null;

    if (authorization != null && authorization.matches(TOKEN_REGEX)) {
      token = authorization.split(SPACE)[1];
      try {
        Claims claims = extractClaims(token, getSecretKey());

        username = extractUsername(claims);
        roles = extractRoles(claims);
      } catch (Exception e) {
        this.logger.error(e.getMessage());
      }
    }

    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UsernamePasswordAuthenticationToken authentication =
          new UsernamePasswordAuthenticationToken(username, null, roles);

      authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }

  private Key getSecretKey() throws Exception {
    return generateKey(
        applicationProperties.getSecurity().getJwt().getSecretKey().getKeyStore().getLocation(),
        applicationProperties.getSecurity().getJwt().getSecretKey().getKeyStore().getType(),
        applicationProperties.getSecurity().getJwt().getSecretKey().getKeyStore().getAlias(),
        applicationProperties.getSecurity().getJwt().getSecretKey().getKeyStore().getPassword());
  }
}
