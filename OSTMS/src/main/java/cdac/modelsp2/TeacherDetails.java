package cdac.modelsp2;

public class TeacherDetails {

	private int tid;
	private String fullname;
	private String gender;
	private String email;
	private int yoe;
	private String desig;

	public TeacherDetails() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public TeacherDetails(int tid, String fullname, String gender, String email, int yoe, String desig) {
		super();
		this.tid = tid;
		this.fullname = fullname;
		this.gender = gender;
		this.email = email;
		this.yoe = yoe;
		this.desig = desig;
	}

	@Override
	public String toString() {
		return "TeacherDetails [tid=" + tid + ", fullname=" + fullname + ", gender=" + gender + ", email=" + email
				+ ", yoe=" + yoe + ", desig=" + desig + "]";
	}

}
