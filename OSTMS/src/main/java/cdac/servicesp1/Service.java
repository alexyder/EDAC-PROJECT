package cdac.servicesp1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import cdac.courier.Status;
import cdac.modelsp1.Gnoti;
import cdac.modelsp1.Queries;
import cdac.modelsp1.Stloginai;
import cdac.modelsp1.Stlogindac;
import cdac.modelsp1.Stlogindbda;
import cdac.modelsp1.Sturegister;
import cdac.modelsp1.Teacherlogin;
import cdac.modelsp1.Teacherregister;
import cdac.reposp1.Gnotirepo;
import cdac.reposp1.LoginAirepo;
import cdac.reposp1.LoginDacrepo;
import cdac.reposp1.LoginDbdarepo;
import cdac.reposp1.Loginteacherrepo;
import cdac.reposp1.Queriesrepo;
import cdac.reposp1.RegStrepo;
import cdac.reposp1.RegTerepo;

@org.springframework.stereotype.Service
public class Service implements ServiceInf {

	@Autowired
	Gnotirepo g1;

	@Autowired
	LoginDacrepo st1;
	@Autowired
	LoginDbdarepo st2;
	@Autowired
	LoginAirepo st3;

	@Autowired
	Loginteacherrepo t1;

	@Autowired
	Queriesrepo q1;

	@Autowired
	RegStrepo rs;
	@Autowired
	RegTerepo rt;

	@Override // fetching public notifications
	public List<Gnoti> gnotifetch() {
		List<Gnoti> gobjlist1 = g1.findAll();
		List<Gnoti> gobjlist2 = new ArrayList<>();
		for (int i = gobjlist1.size() - 1; i >= 0; i--) {
			gobjlist2.add(gobjlist1.get(i));
		}
//		System.out.println(gobjlist2);
//		System.out.println(gobjlist2.size() == gobjlist1.size());
		return gobjlist2;
	}

	@Override // teacher -> adding public notifications
	public boolean addgnoti(String msg) {
		boolean sss = false;
		LocalDate ld = LocalDate.now();
		String ld2 = ld.toString();
		Gnoti gobj = new Gnoti(ld2, msg);
		try {
			g1.save(gobj);
			sss = true;
		} catch (Exception e) {
			System.out.println("null message");
		}
		return sss;
	}

	@Override // student login check
	public Status login(int prn, String pwd) {
		Status b = new Status(0, false, "");
		int course = prn / 10000000;
		if (course == 101) { // DAC
			if (st1.existsById(prn)) {
				Optional<Stlogindac> obj = st1.findById(prn);
				if (obj.get().getPwd().equals(pwd)) {
					b.setCode(1);
					b.setBobo(true);
					b.setMsg(obj.get().getFullname());
				}
			}
		} else if (course == 102) { // DBDA
			if (st2.existsById(prn)) {
				Optional<Stlogindbda> obj = st2.findById(prn);
				if (obj.get().getPwd().equals(pwd)) {
					b.setCode(1);
					b.setBobo(true);
					b.setMsg(obj.get().getFullname());
				}
			}
		} else if (course == 103) { // AI
			if (st3.existsById(prn)) {
				Optional<Stloginai> obj = st3.findById(prn);
				if (obj.get().getPwd().equals(pwd)) {
					b.setCode(1);
					b.setBobo(true);
					b.setMsg(obj.get().getFullname());
				}
			}
		}
//		System.out.println(course);
		return b;
	}

	@Override // teacher login check
	public Status loginte(int tid, String pwd) {
		Status b = new Status(0, false, "");
		if (t1.existsById(tid)) {
			Optional<Teacherlogin> obj = t1.findById(tid);
			if (obj.get().getPwd().equals(pwd)) {
				b.setBobo(true);
				b.setMsg(obj.get().getFullname());
			}
		}
		return b;
	}

	@Override // student -> ask queries
	public boolean askquery(int prn, String module, String que) {
		boolean b = false;
		Queries qobj = new Queries(prn, module, que, null);
		try {
			if (que.length() != 0) {
				q1.save(qobj);
				b = true;
			}
		} catch (Exception e) {
		}
		return b;
	}

	@Override // student viewing his queries
	public List<Queries> viewquery(int prn) {
		List<Queries> qobjlist1 = q1.findmyquery(prn);
		List<Queries> qobjlist2 = new ArrayList<>();
		for (int i = qobjlist1.size() - 1; i >= 0; i--) {
			qobjlist2.add(qobjlist1.get(i));
		}

		return qobjlist2;
	}

	@Override // teacher viewing queries
	public List<Queries> viewqueryte(String course, String module) {

		List<Queries> qall = q1.findAll();
		List<Queries> qreq = new ArrayList<>();

		int cid = 0;
		if (course.equals("DAC"))
			cid = 101;
		else if (course.equals("DBDA"))
			cid = 102;
		else if (course.equals("AI"))
			cid = 103;

		for (Queries q : qall) {
			if ((q.getPrn() / 10000000) == cid) {
				if (q.getModule().equals(module)) {
					qreq.add(q);
				}
			}
		}
		return qreq;
	}

	@Override // teacher replying queries
	public boolean replyquery(int qid, String reply) {
		boolean b = false;
		if (q1.existsById(qid)) {
			int x = q1.replydone(qid, reply);
			if (x != 0) {
				b = true;
			}
		}
		return b;
	}

	@Override // student registration
	public Status stuReg(int prn, Sturegister stuobj) {
		Status sss = new Status(0, false, "Duplicate Entry");
		stuobj.setPrn(prn);
		if (!rs.existsById(prn)) {
			try {
				rs.save(stuobj);
				sss.setCode(1);
				sss.setBobo(true);
				sss.setMsg("Success");
			} catch (Exception e) {
			}
		}
		return sss;
	}

	@Override // student viewing profile // return null for guest user
	public Sturegister viewprofst(int prn) {
		Sturegister x = null;
		try {
			if (prn != 0) {
				Optional<Sturegister> y = rs.findById(prn);
				x = y.get();
			}
		} catch (Exception e) {
		}
		return x;
	}

	@Override // student updating profile
	public Status updatestu(int prn, Sturegister stuobj) {
		Status sss = new Status(0, false, null);
		stuobj.setPrn(prn);
		if (rs.existsById(prn)) {
			try {
				rs.save(stuobj);
				sss.setCode(1);
				sss.setBobo(true);
				sss.setMsg("Success");
			} catch (Exception e) {
			}
		}
		return sss;
	}

	@Override // teacher registration
	public Status teaReg(int tid, Teacherregister teobj) {
		Status sss = new Status(0, false, "Duplicate Entry");
		teobj.setTid(tid);
		if (!rt.existsById(tid)) {
			try {
				rt.save(teobj);
				sss.setCode(1);
				sss.setBobo(true);
				sss.setMsg("Success");
			} catch (Exception e) {
			}
		}
		return sss;
	}

	@Override // teacher viewing his profile
	public Teacherregister viewprofte(int tid) {
		Teacherregister x = null;
		try {
			if (tid != 0) {
				Optional<Teacherregister> y = rt.findById(tid);
				x = y.get();
			}
		} catch (Exception e) {
		}
		return x;
	}

	@Override // teacher updating profile
	public Status updatetea(int tid, Teacherregister teobj) {
		Status sss = new Status(0, false, null);
		teobj.setTid(tid);
		if (rt.existsById(tid)) {
			try {
				rt.save(teobj);
				sss.setCode(1);
				sss.setBobo(true);
				sss.setMsg("Success");
			} catch (Exception e) {
			}
		}
		return sss;
	}
}
