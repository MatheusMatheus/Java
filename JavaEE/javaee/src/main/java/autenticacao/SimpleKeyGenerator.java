package autenticacao;

import java.security.AlgorithmConstraints;
import java.security.Key;
import java.security.Signature;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.crypto.AlgorithmMethod;

import io.jsonwebtoken.SignatureAlgorithm;

public class SimpleKeyGenerator implements KeyGenerator{

	public SimpleKeyGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Key generateKey() {
		String keyString = "simplekey";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, String.valueOf(SignatureAlgorithm.HS512));
        return key;
	}

}
