
public class User {
	
	private String username;
	private int password;
	
	
	public User(String username, Integer password){
		this.username = username;
		this.password = password;	
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