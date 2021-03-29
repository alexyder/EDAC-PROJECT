package cdac.modelsp1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Courses {

	@Id
	int cid;
	String cname;

	public Courses() {
		super();
	}

	public Courses(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Courses [cid=" + cid + ", cname=" + cname + "]";
	}

}
