package cdac.modelsp1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sturegister {

	@Id
	int prn;
	String gender;
	String dob;
	long phone;
	String email;
	String address;
	String city;
	String state;
	String country;
	String course;
	String batch;

	public Sturegister() {
		super();
	}

	public Sturegister(int prn, String gender, String dob, long phone, String email, String address, String city,
			String state, String country, String course, String batch) {
		super();
		this.prn = prn;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.course = course;
		this.batch = batch;
	}

	public int getPrn() {
		return prn;
	}

	public void setPrn(int prn) {
		this.prn = prn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "Sturegister [prn=" + prn + ", gender=" + gender + ", dob=" + dob + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", course=" + course + ", batch=" + batch + "]";
	}

}
