package cdac.servicesp2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.courier.Status;
import cdac.modelsp1.Stloginai;
import cdac.modelsp1.Stlogindac;
import cdac.modelsp1.Stlogindbda;
import cdac.modelsp1.Teacherlogin;
import cdac.modelsp1.Teacherregister;
import cdac.modelsp2.Cnoti;
import cdac.modelsp2.TeacherDetails;
import cdac.reposp1.LoginAirepo;
import cdac.reposp1.LoginDacrepo;
import cdac.reposp1.LoginDbdarepo;
import cdac.reposp1.Loginteacherrepo;
import cdac.reposp1.RegTerepo;
import cdac.reposp2.Cnotirepo;

@Service
public class Service2 implements ServiceInf2 {

	@Autowired
	Loginteacherrepo tl;

	@Autowired
	RegTerepo tr;

	@Autowired
	Cnotirepo cn;

	@Autowired
	LoginDacrepo l1;
	@Autowired
	LoginDbdarepo l2;
	@Autowired
	LoginAirepo l3;

	@Override // student viewing teacher details
	public List<TeacherDetails> teacherdet() {

		List<TeacherDetails> tdobjlist = new ArrayList<>();
		List<Teacherlogin> tlobjlist = tl.findAll();

		for (Teacherlogin tlobj : tlobjlist) {

			Optional<Teacherregister> trobj = tr.findById(tlobj.getTid());
			TeacherDetails tdobj = new TeacherDetails();

			if (trobj.isPresent()) {

				tdobj.setTid(tlobj.getTid());
				tdobj.setFullname(tlobj.getFullname());
				tdobj.setGender(trobj.get().getGender());
				tdobj.setEmail(trobj.get().getEmail());
				tdobj.setYoe(trobj.get().getYoe());
				tdobj.setDesig(trobj.get().getDesig());

				tdobjlist.add(tdobj);
			}
		}
		return tdobjlist;
	}

	@Override // teacher adding course notifications
	public Status addcnoti(Cnoti cobj) {
		LocalDate ld = LocalDate.now();
		String ld2 = ld.toString();
		cobj.setUptime(ld2);
		Status sss = new Status(0, false, "");
		try {
			cn.save(cobj);
			sss.setCode(1);
			sss.setBobo(true);
			sss.setMsg("Success");
		} catch (Exception e) {
		}

		return sss;
	}

	@Override // student viewing course notifications
	public List<Cnoti> viewCnoti(int prn) {
		String course;
		if (prn / 10000000 == 101)
			course = "DAC";
		else if (prn / 10000000 == 102)
			course = "DBDA";
		else
			course = "AI";

		List<Cnoti> cobjlist = new ArrayList<>();
		cobjlist = cn.findbycourse(course);

		List<Cnoti> cobjlist2 = new ArrayList<>();
		for (int i = cobjlist.size() - 1; i >= 0; i--) {
			cobjlist2.add(cobjlist.get(i));
		}
		return cobjlist2;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override // fetching student details
	public List getStd1All(String course) {
		if (course.equals("DAC")) {
			List<Stlogindac> a = l1.findAll();
			return a;
		} else if (course.equals("DBDA")) {
			List<Stlogindbda> b = l2.findAll();
			return b;
		} else if (course.equals("AI")) {
			List<Stloginai> c = l3.findAll();
			return c;
		} else
			return null;
	}

}
