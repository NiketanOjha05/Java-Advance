package in.co.rays.preparedstatement.user;

public class TestCreateUser {

	public static void main(String[] args) throws Exception {

		testCreateTable();

	}

	public static void testCreateTable() throws Exception {

		CreateUser cu = new CreateUser();

		cu.createTable();
	}

}
