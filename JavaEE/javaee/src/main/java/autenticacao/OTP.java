package autenticacao;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class OTP
{
   public static String generateToken(String secret)
   {
      long minutes = System.currentTimeMillis() / 1000 / 60;
      String concat = secret + minutes;
      MessageDigest digest = null;
      try
      {
         digest = MessageDigest.getInstance("MD5");
      }
      catch (NoSuchAlgorithmException e)
      {
         throw new IllegalArgumentException(e);
      }
      byte[] hash = digest.digest(concat.getBytes(Charset.forName("UTF-8")));
      Base64.Encoder encoder = Base64.getEncoder();
      return encoder.encodeToString(hash);
   }
}