package cdac.modelsp1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacherregister {

	@Id
	int tid;
	String gender;
	long phone;
	String email;
	int yoe;
	String desig;

	public Teacherregister() {
		super();
	}

	public Teacherregister(int tid, String gender, long phone, String email, int yoe, String desig) {
		super();
		this.tid = tid;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.yoe = yoe;
		this.desig = desig;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getYoe() {
		return yoe;
	}

	public void setYoe(int yoe) {
		this.yoe = yoe;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	@Override
	public String toString() {
		return "Teacherregister [tid=" + tid + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", yoe="
				+ yoe + ", desig=" + desig + "]";
	}

}
