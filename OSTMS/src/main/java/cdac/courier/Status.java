package cdac.courier;

public class Status {

	int code;
	boolean bobo;
	String msg;

	public Status(int code, boolean bobo, String msg) {
		super();
		this.code = code;
		this.bobo = bobo;
		this.msg = msg;
	}

	public Status() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isBobo() {
		return bobo;
	}

	public void setBobo(boolean bobo) {
		this.bobo = bobo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Status [code=" + code + ", bobo=" + bobo + ", msg=" + msg + "]";
	}

}
