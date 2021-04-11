package cdac.modelsp1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gnoti { // GENERAL NOTIFICATIONS => HOME PAGE , AVAILABLE FOR ALL THE USERS

	@Id
	private int id; // auto-increment
	private String uptime;
	private String msg;

	public Gnoti() {
		super();
	}

	public Gnoti(String ld2, String msg) {
		super();
		this.uptime = ld2;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "[" + uptime + " - " + msg + "]";
	}

}
