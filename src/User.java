public class User {

	private int idusers;
	private String username;
	private int password;
	
	
	public User(Integer idusers, String username, Integer password){
		this.idusers = idusers;
		this.username = username;
		this.password = password;	
	}
	
	public void setIdusers(Integer idusers){
		this.idusers = idusers;
	}
	
	public Integer getIdusers(){
		return idusers;
	}
	
	public void setUsername(String username){
		this.username = username;
	}	
	public String getUsername(){
		return this.username;
	}
	
	public void setPassword(Integer password){
		this.password = password;
	}
	
	public Integer getPassword(){
		return this.password;
	}
	

}