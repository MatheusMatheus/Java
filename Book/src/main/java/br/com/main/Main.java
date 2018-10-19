
package br.com.main;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import br.com.model.Book;
import br.com.service.BookService;

public class Main
{

   public static void main(String[] args)
   {
      /*  
      Main main = new Main();
      BookService service = main.getService();
      Book book = service.createBook("Matheus Lindo", preco, "Excelente livro");
      System.out.println(book);*/
      
      float preco = 100000;
      Weld weld = new Weld();
      WeldContainer container = weld.initialize();
      BookService service = container.instance().select(BookService.class).get();
      Book book = service.createBook("Matheus Lindo", preco, "Excelente livro");
      System.out.println(book);
      weld.shutdown();
   }

   public BookService getService()
   {
      Instance<BookService> service = CDI.current().select(BookService.class, new AnnotationLiteral()
      {
      });
      if (!(service.isUnsatisfied() || service.isAmbiguous()))
         return service.get();
      else
         return null;
   }
}
