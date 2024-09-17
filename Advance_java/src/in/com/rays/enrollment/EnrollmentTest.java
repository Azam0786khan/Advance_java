package in.com.rays.enrollment;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.com.rays.marksheet.MarksheetModel;

public class EnrollmentTest {

	public static void main(String[] args) throws Exception {

		 testadd();
		// testupdate();
		// testdelete();
		// testfindbypk();
		//testSearch();
	}

	public static void testadd() throws Exception {

		EnrollmentModel model = new EnrollmentModel();

		EnrollmentBean bean = new EnrollmentBean();

		bean.setStudentId(11);
		bean.setCourseId(123);
		bean.setEnrollmentDate(new Date());
		bean.setGrade("B");
		bean.setStatus("enrolled");

		model.add(bean);
	}

	public static void testupdate() throws Exception {

		EnrollmentModel model = new EnrollmentModel();
		EnrollmentBean bean = new EnrollmentBean();

		bean.setId(1);
		bean.setStudentId(11);
		bean.setCourseId(123);
		bean.setEnrollmentDate(new Date());
		bean.setGrade("B");
		bean.setStatus(" not enrolled");

		model.update(bean);

	}

	public static void testdelete() throws Exception {

		EnrollmentModel model = new EnrollmentModel();
		model.delete(1);

	}

	public static void testfindbypk() throws Exception {

		EnrollmentModel model = new EnrollmentModel();
		EnrollmentBean bean = model.findbypk(1);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getEnrollmentDate());
			System.out.print("\t" + bean.getGrade());
			System.out.println("\t" + bean.getStatus());

		}

	}

	public static void testSearch() throws Exception {

		EnrollmentModel model = new EnrollmentModel();
		EnrollmentBean bean = new EnrollmentBean();
		bean.setStudentId(11);

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			EnrollmentBean object = (EnrollmentBean) it.next();
			if (object != null) {
				System.out.print(object.getId());
				System.out.print("\t" + object.getStudentId());
				System.out.print("\t" + object.getCourseId());
				System.out.print("\t" + object.getEnrollmentDate());
				System.out.print("\t" + object.getGrade());
				System.out.println("\t" + object.getStatus());

			}

		}
		
		
	}

}
