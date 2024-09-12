package in.co.com.rays.user;

public class TestUser {

	public static void main(String[] args) throws Exception {

		// testAdd();
		testUpdate();
	}

	public static void testAdd() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(1);
		bean.setFirstName("azam");
		bean.setLastName("khan");
		bean.setLoginId("abc856487");
		bean.setPassword("12345678");
		bean.setAddress("indore");

		UserModel um = new UserModel();
		um.add(bean);

	}

	public static void testUpdate() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(1);
		bean.setFirstName("azaam");
		bean.setLastName("khan");
		bean.setLoginId("abc856487");
		bean.setPassword("12345678");
		bean.setAddress("indore");

		UserModel um = new UserModel();
		um.update(bean);
	}

	public static void testDelete() throws Exception {

		UserModel um = new UserModel();
		um.delete(1);
	}

}
