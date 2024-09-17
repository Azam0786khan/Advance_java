package in.com.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testFindByRollNo();
		//testReadAll();
		testSearch();

	}

	public static void testAdd() throws Exception {
		MarksheetModel md = new MarksheetModel();

		MarksheetBean bean = new MarksheetBean();
		bean.setId(7);
		bean.setRollNo(17);
		bean.setname("moon");
		bean.setPhysics(27);
		bean.setChemistry(66);
		bean.setMaths(68);

		md.add(bean);
	}

	public static void testUpdate() throws Exception {
		MarksheetModel md = new MarksheetModel();

		MarksheetBean bean = new MarksheetBean();
		bean.setId(6);
		bean.setRollNo(16);
		bean.setname("sonu");
		bean.setPhysics(27);
		bean.setChemistry(16);
		bean.setMaths(68);

		md.update(bean);
	}

	public static void testDelete() throws Exception {

		MarksheetModel md = new MarksheetModel();
		md.delete(6);
	}

	public static void testFindByPk() throws Exception {

		MarksheetModel md = new MarksheetModel();
		MarksheetBean bean = md.findByPk(5);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getname());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		} else {
			System.out.println("id not found");
		}

	}

	public static void testFindByRollNo() throws Exception {

		MarksheetModel md = new MarksheetModel();
		MarksheetBean bean = md.findByRollNo(14);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getname());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		} else {
			System.out.println("Roll No.not found");
		}

	}

	public static void testReadAll() throws Exception {

		MarksheetModel model = new MarksheetModel();

		List list = model.readAll();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			Object obj = it.next();

			MarksheetBean bean = (MarksheetBean) obj;

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getname());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}
	}

	public static void testSearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setname("k");

		bean.setRollNo(11);

		MarksheetModel model = new MarksheetModel();

		List list = model.search1(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();
			
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getname());
			System.out.print("\t"+bean.getPhysics());
			System.out.print("\t"+bean.getChemistry());
			System.out.println("\t"+bean.getMaths());
		}

	}
}
