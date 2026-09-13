package in.co.rays.preparedstatement.product;

public class TestProductModel {

	public static void main(String[] args) throws Exception {

		//testAdd();
		testUpdate();

	}

	public static void testAdd() throws Exception {

		ProductModel pm = new ProductModel();
		ProductBean pb = new ProductBean();

		pb.setProductName("USB Cable");
		pb.setPrice(700.00);
		pb.setQuantity(25);
		pb.setCategory("Accessories");

		pm.add(pb);

	}

	public static void testUpdate() throws Exception {
		
		ProductModel pm = new ProductModel();
		ProductBean pb = new ProductBean();
		
		pb.setProductId(10);
		pb.setProductName("Digital Camera");
		pb.setPrice(253000.00);
		pb.setQuantity(2);
		pb.setCategory("Electronic");

		pm.update(pb);


	}

}
