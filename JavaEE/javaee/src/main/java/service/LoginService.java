package service;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import autenticacao.KeyGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginService {
	
	@Inject
	private KeyGenerator keyGenerator;

	@Context
	private UriInfo uriInfo;

	@POST
	@Path("jwt")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response autentica(@FormParam("login") String login, @FormParam("senha") String senha) {
		try {
			authenticate(login, senha);
			String token = issueToken(login);
			return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
		} catch (Exception e) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
	}

	private void authenticate(String login, String senha) {
		if(Objects.isNull(login) || Objects.isNull(senha))
			throw new SecurityException("Invalid user/password"); 
	}

	private String issueToken(String login) {
		Key key = keyGenerator.generateKey();
		return Jwts.builder()
				.setSubject(login)
				.setIssuer(uriInfo.getAbsolutePath().toString())
				.setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
	}
	
	private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
