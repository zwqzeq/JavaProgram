package model;


/**
 * JavaBean类
 */
public class User {
	private String student_id;
	private String name;
	private String faculty;
	private String sex;

	public User(String name, String faculty, String student_id, String sex) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.faculty = faculty;
		this.sex = sex;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public User(String name, String faculty) {
		super();
		this.name = name;
		this.faculty = faculty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
