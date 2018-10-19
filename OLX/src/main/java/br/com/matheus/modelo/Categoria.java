
package br.com.matheus.modelo;

import java.io.Serializable;

public class Categoria implements Autenticadora, Serializable
{

   /**
    * 
    */
   private static final long serialVersionUID = 5927510540677001267L;
   private long id;
   private String nome;

   @Override
   public long getId()
   {
      return id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

}
