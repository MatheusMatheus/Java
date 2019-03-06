package autenticacao;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.SignatureAlgorithm;

public class SimpleKeyGenerator implements KeyGenerator{
	
	private static String SECRET_KEY = "CHAVE";

	public SimpleKeyGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Key generateKey() {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
	}

}
