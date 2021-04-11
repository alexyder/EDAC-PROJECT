package cdac.testpoc;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test1 {

	@Id
	int memberid;
	String membername;

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public Test1(int memberid, String membername) {
		super();
		this.memberid = memberid;
		this.membername = membername;
	}

	public Test1() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Test1 [memberid=" + memberid + ", membername=" + membername + "]";
	}

}
