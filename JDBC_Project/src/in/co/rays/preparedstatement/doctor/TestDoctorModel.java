package in.co.rays.preparedstatement.doctor;

public class TestDoctorModel {

	public static void main(String[] args) throws Exception {

		// testadd();
		//testdelete();
		testupdate();
	}

	public static void testadd() throws Exception {

		DoctorModel model = new DoctorModel();

		model.add(1006, "Naina Pandit", "Dentist", 2, "7566393242");

	}

	public static void testdelete() throws Exception {

		DoctorModel model = new DoctorModel();
		model.delete(1006);
	}
	
	public static void testupdate()throws Exception{
		
		DoctorModel model = new DoctorModel();
		
		model.update(1001,"Rishabh Pant");
	}

}
