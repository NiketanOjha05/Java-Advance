package in.co.rays.preparedstatement;

public class TestCreatePatient {

	public static void main(String[] args) throws Exception {

		testCreateTable();

	}

	public static void testCreateTable() throws Exception {

		CreatePatient cp = new CreatePatient();

		cp.createTable();
	}

}
