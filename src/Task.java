public class Task {
	
	private int idtask;
	private int user_id;
	private String desc;
	
	
	public Task(Integer idtask, Integer user_id, String desc){
		this.idtask = idtask;
		this.user_id = user_id;
		this.desc = desc;
	}


	public int getIdtask() {
		return idtask;
	}


	public void setIdtask(int idtask) {
		this.idtask = idtask;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}

	

}