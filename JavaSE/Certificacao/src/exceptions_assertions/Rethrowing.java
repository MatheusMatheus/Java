package exceptions_assertions;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class Rethrowing {
	public void rethrowing() throws SQLException, IOException, DateTimeParseException{
		try {
			parseData();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	void parseData() throws IOException {
		throw new IOException("IO");
	}
	
	public static void main(String[] args) throws Exception{
		Rethrowing r = new Rethrowing();
		r.rethrowing();
	}
}
