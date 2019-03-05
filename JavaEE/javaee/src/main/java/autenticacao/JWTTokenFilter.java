package autenticacao;

import java.io.IOException;
import java.security.Key;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Jwts;
import qualifiers.JWTTokenNeeded;

@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenFilter implements ContainerRequestFilter {

	@Inject
	private KeyGenerator keyGenerator;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		try {
			String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

			// Extract the token from the HTTP Authorization header
			String token = authorizationHeader.substring("Bearer".length()).trim();

			// Validate the token
			Key key = keyGenerator.generateKey();
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);

		} catch (Exception e) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}
}
