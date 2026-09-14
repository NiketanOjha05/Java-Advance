package in.co.rays.preparedstatement.service;

public class TestCreateService {

	public static void main(String[] args) throws Exception {

		createTable();

	}

	public static void createTable() throws Exception {

		CreateService cs = new CreateService();

		cs.createTable();

	}

}
