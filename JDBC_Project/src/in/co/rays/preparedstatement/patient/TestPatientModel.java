package in.co.rays.preparedstatement.patient;

public class TestPatientModel {

	public static void main(String[] args) throws Exception {

//		testadd();
//		testupdate();

	}

	public static void testadd() throws Exception {

		PatientModel model = new PatientModel();
		PatientBean bean = new PatientBean();

		bean.setPatientId(2);
		bean.setPatientName("Suman Tomar");
		bean.setAge(26);
		bean.setDisease("Fever");

		model.add(bean);

	}

	public static void testupdate() throws Exception {

		PatientModel model = new PatientModel();
		PatientBean bean = new PatientBean();
		
		
		bean.setPatientId(1);
		bean.setPatientName("Kartik Shukla");
		bean.setAge(26);
		bean.setDisease("Cancer");

		model.update(bean);

	}

}
