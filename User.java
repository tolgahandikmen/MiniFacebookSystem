import java.util.ArrayList;
import java.util.Date;

public class User {

	private String name, username, password, graduatedSchool, relationshipStatus;
	private Date birthday;
	private ArrayList<User> contact = new ArrayList<User>();
	private ArrayList<Post> posts = new ArrayList<Post>();
	private ArrayList<User> blocked = new ArrayList<User>();
	
	public ArrayList<User> getBlocked() {
		return blocked;
	}

	public void setBlocked(ArrayList<User> blocked) {
		this.blocked = blocked;
	}

	public User(String name, String username, String password, String graduatedSchool, String relationshipStatus,
			Date birthday) {
		
		this.setName(name);
		this.setUsername(username);
		this.setPassword(password);
		this.setGraduatedSchool(graduatedSchool);
		this.setRelationshipStatus(relationshipStatus);
		this.setBirthday(birthday);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGraduatedSchool() {
		return graduatedSchool;
	}

	public void setGraduatedSchool(String graduatedSchool) {
		this.graduatedSchool = graduatedSchool;
	}

	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public ArrayList<User> getContact() {
		return contact;
	}

	public void setContact(ArrayList<User> contact) {
		this.contact = contact;
	}

	public ArrayList<Post> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}



}