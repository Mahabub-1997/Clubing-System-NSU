package project;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	Date dateobj = new Date();
	String date = df.format(dateobj);

	private String name;
	private String id;
	private String dept;

	public Student(String name, String id, String dept) {
		this.name = name;
		this.id = id;
		this.dept = dept;
	}

	public Student(String name, String id, String dept, String date) {
		this.name = name;
		this.id = id;
		this.dept = dept;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public String getid() {
		return id;
	}

	public void setName(String name) {
		this.name = name;

	}

	public void setid(String id) {
		this.id = id;
	}

	public String getDateobj() {
		return date;
	}

	public void setdept(String dept) {
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + dept + "\t" + date;
	}
}
