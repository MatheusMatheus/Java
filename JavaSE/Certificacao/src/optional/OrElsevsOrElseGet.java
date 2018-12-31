package optional;

import java.util.Optional;

public class OrElsevsOrElseGet {
	public static void main(String[] args) {
		OrElsevsOrElseGet a = new OrElsevsOrElseGet();
		a.metodo();
	}
	
	public void metodo() {
		String text = "Text present";
		 
	    System.out.println("Using orElseGet:");
	    String defaultText 
	      = Optional.ofNullable(text).orElseGet(this::getMyDefault);
	 
	    System.out.println("Using orElse:");
	    defaultText = Optional.ofNullable(text).orElse(getMyDefault());
	}
	
	public String getMyDefault() {
	    System.out.println("Getting Default Value");
	    return "Default Value";
	}
}
