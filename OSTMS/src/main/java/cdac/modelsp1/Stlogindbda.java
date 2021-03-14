package cdac.modelsp1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stlogindbda {

	@Id
	int prn;
	String fullname;
	String pwd;

	public int getPrn() {
		return prn;
	}

	public void setPrn(int prn) {
		this.prn = prn;
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

	public Stlogindbda() {
		super();
	}

	public Stlogindbda(int prn, String fullname, String pwd) {
		super();
		this.prn = prn;
		this.fullname = fullname;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Stlogindbda [prn=" + prn + ", fullname=" + fullname + ", pwd=" + pwd + "]";
	}

}
