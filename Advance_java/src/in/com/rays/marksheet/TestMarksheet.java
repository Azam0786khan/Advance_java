package in.com.rays.marksheet;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {
		 testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		//testFindByRollNo();

	}

	public static void testAdd() throws Exception {
		MarksheetModel md = new MarksheetModel();

		MarksheetBean bean = new MarksheetBean();
		bean.setId(7);
		bean.setRollNo(17);
		bean.setName("moon");
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
		bean.setName("sonu");
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
			System.out.print("\t" + bean.getName());
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
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		} else {
			System.out.println("Roll No.not found");
		}

	}
}
