package cdac.modelsp3;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Myfiles {

	@Id
	private int id;
	private String filename;
	private String filetype;

	@Lob
	private byte[] data;
	private String course;

	public Myfiles() {
		super();
	}

	public Myfiles(String filename, String filetype, byte[] data, String course) {
		super();
		this.filename = filename;
		this.filetype = filetype;
		this.data = data;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Myfiles [id=" + id + ", filename=" + filename + ", filetype=" + filetype + ", data="
				+ Arrays.toString(data) + ", course=" + course + "]";
	}

}