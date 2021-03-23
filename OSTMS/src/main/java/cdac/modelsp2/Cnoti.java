package cdac.modelsp2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cnoti {

	@Id
	int id;
	String uptime;
	String course;
	String msg;

	public Cnoti() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cnoti(String uptime, String course, String msg) {
		super();

		this.uptime = uptime;
		this.course = course;
		this.msg = msg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Cnoti [id=" + id + ", uptime=" + uptime + ", course=" + course + ", msg=" + msg + "]";
	}

}
