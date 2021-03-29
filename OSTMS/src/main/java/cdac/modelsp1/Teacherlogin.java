package cdac.modelsp1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacherlogin {

	@Id
	int tid;
	String fullname;
	String pwd;

	public Teacherlogin(int tid, String fullname, String pwd) {
		super();
		this.tid = tid;
		this.fullname = fullname;
		this.pwd = pwd;
	}

	public Teacherlogin() {
		super();
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Teacherlogin [tid=" + tid + ", fullname=" + fullname + ", pwd=" + pwd + "]";
	}

}
