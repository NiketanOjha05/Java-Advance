package in.co.rays.preparedstatement.user;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		testAdd();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("Ritik");
		bean.setLastName("Jadon");
		bean.setLoginId("ritik@gmail.com");
		bean.setPassword("ritik123");
		bean.setDob(sdf.parse("1997-12-30"));

		model.add(bean);

	}

}
