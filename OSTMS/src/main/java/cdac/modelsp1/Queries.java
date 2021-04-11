package cdac.modelsp1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Queries {

	@Id
	private int qid; // auto-increment
	private int prn;
	private String module;
	private String que;
	private String reply;

	public Queries() {
		super();
	}

	public Queries(int prn, String module, String que, String reply) {
		super();
		this.prn = prn;
		this.module = module;
		this.que = que;
		this.reply = reply;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getPrn() {
		return prn;
	}

	public void setPrn(int prn) {
		this.prn = prn;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "Queries [" + qid + "," + prn + "," + module + "," + que + "," + reply + "]";
	}

}
