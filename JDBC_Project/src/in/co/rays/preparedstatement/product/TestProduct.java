package in.co.rays.preparedstatement.product;

public class TestProduct {

	public static void main(String[] args) throws Exception {

		createTable();

	}

	public static void createTable() throws Exception {

		CreateProduct cp = new CreateProduct();

		cp.createTable();
	}

}
