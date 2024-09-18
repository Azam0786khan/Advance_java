package in.com.rays.task;

public class TaskTest {
	
	public static void main(String[] args) {
		
	}
	
	public void testadd() throws Exception{
		TaskModel model = new TaskModel();
		
		TaskBean bean = new TaskBean();
		
		bean.setId(1);
		bean.setTaskName("usecase");
		
		model.add(bean);
	}

}
