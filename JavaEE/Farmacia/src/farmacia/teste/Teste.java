package farmacia.teste;

import java.sql.Connection;

import farmacia.model.Cidade;
import farmacia.model.dao.CidadeDAO;
import farmacia.model.dao.ConnectionFactory;
import farmacia.model.dao.DAO;

public class Teste {
	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getConnection();
	}

	
}


