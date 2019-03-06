package autenticacao;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.SignatureAlgorithm;

public class SimpleKeyGenerator implements KeyGenerator{
	
	private static String key = "BD2B1AAF7EF4F09BE9F52CE2D8D599674D81AA9D6A4421696DC4D93DD0619D682CE56B4D64A9EF097761CED99E0F67265B5F76085E5B0EE7CA4696B2AD6FE2B2";

	public SimpleKeyGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Key generateKey() {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
		String base64Key = DatatypeConverter.printBase64Binary(key.getBytes());
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Key);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
	}
	
}
