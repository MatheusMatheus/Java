package farmacia.util;

public interface Leitor {
   String lerString();
   String lerString(String titulo, String msgErro);
   int lerInt();
   int lerInt(String titulo, String msgErro);
   int lerInt(String titulo, String msgErro, int min, int max);
   void mostrarMensagem(String msg);
}
