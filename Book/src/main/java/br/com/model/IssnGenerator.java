
package br.com.model;

import java.util.Random;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import br.com.util.log.Loggable;
import br.com.util.qualifiers.EightDigits;

@EightDigits
@Loggable
public class IssnGenerator implements NumberGenerator
{

   @Inject
   private Logger logger;

   public String generateNumber()
   {
      String issn = "8-" + Math.abs(new Random().nextInt());
      logger.info("Generated ISBN : " + issn);
      return issn;
   }

   @ExcludeClassInterceptors
   public void metodo()
   {

   }
}
