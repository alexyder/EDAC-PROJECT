package cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdac.courier.Status;
import cdac.modelsp1.Gnoti;
import cdac.modelsp1.Queries;
import cdac.modelsp1.Stlogindac;
import cdac.modelsp1.Sturegister;
import cdac.modelsp1.Teacherlogin;
import cdac.modelsp1.Teacherregister;
import cdac.modelsp2.Cnoti;
import cdac.modelsp2.TeacherDetails;
import cdac.servicesp1.Service;
import cdac.servicesp2.ServiceInf2;
import cdac.testanshul.TestRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {

	// ----- testing ----- //

	@Autowired
	TestRepo trtr;

	@RequestMapping("/mytest") // URL => http://localhost:3000/mytest
	public String xyz() {
		return "Connected to Backend";
	}

	// ----- testing ----- //

	/////////////////////////////// SPRINT-1 ///////////////////////////////

	@Autowired
	Service s;

	// General Notifications - showing in home page
	@GetMapping("/gnoti")
	public List<Gnoti> gnf() {
		return s.gnotifetch();
	}

	// General Notifications - teacher is adding new notification
	@PostMapping("/gnoti")
	public Status gnf2(@RequestBody Status sobj) {
		return s.addgnoti(sobj.getMsg());
	}

	// Student login
	// content of all the 3 class is same thats why stlogindac can store other
	// class's data
	// advantage => only one login function
	@PostMapping("/loginst")
	public Status loginchkst(@RequestBody Stlogindac stdacobj) {
		System.out.println(stdacobj);
		return s.login(stdacobj.getPrn(), stdacobj.getPwd());
	}

	// Teacher login
	@PostMapping("/loginte")
	public Status loginchkte(@RequestBody Teacherlogin tobj) {
		return s.loginte(tobj.getTid(), tobj.getPwd());
	}

	// Student -> asking query
	@PostMapping("/dashboard/askquery")
	public Status ask(@RequestBody Queries qobj) {
		return s.askquery(qobj.getPrn(), qobj.getModule(), qobj.getQue());
	}

	// Student viewing his query
	@GetMapping("/dashboard/viewqueryst/{prn}") // URL => http://localhost:3000/viewqueryst/10
	public List<Queries> view(@PathVariable int prn) {
		return s.viewquery(prn);
	}

	// Teacher -> viewing query
	@GetMapping("/viewqueryte/{course}/{module}") // URL => http://localhost:3000/viewqueryst/DAC/m2
	public List<Queries> viewte(@PathVariable String course, @PathVariable String module) { // module and course ->
		return s.viewqueryte(course, module);
	}

	// Teacher -> replying query
	@PostMapping("/replyquery/{qid}")
	public Status reply(@PathVariable int qid, @RequestBody Queries qobj) {
		return s.replyquery(qid, qobj.getReply());
	}

	// Student Registration
	@PostMapping("/stureg/{prn}")
	public Status str(@PathVariable int prn, @RequestBody Sturegister stuobj) {
		return s.stuReg(prn, stuobj);
	}

	// Student viewing his profile // prn = 0 for guest user
	@GetMapping("/viewprofilest/{prn}")
	public Sturegister viewprof(@PathVariable int prn) {
		return s.viewprofst(prn);
	}

	// Student updating profile
	@PutMapping("/stureg/{prn}")
	public Status stup(@PathVariable int prn, @RequestBody Sturegister stuobj) {
		return s.updatestu(prn, stuobj);
	}

	// Teacher Registration
	@PostMapping("/teareg/{tid}")
	public Status ter(@PathVariable int tid, @RequestBody Teacherregister teobj) {
		return s.teaReg(tid, teobj);
	}

	// Teacher viewing his profile // tid = 0 for guest user
	@GetMapping("/viewprofilete/{tid}")
	public Teacherregister viewproft(@PathVariable int tid) {
		return s.viewprofte(tid);
	}

	// Teacher updating profile
	@PutMapping("/teareg/{tid}")
	public Status teup(@PathVariable int tid, @RequestBody Teacherregister teobj) {
		return s.updatetea(tid, teobj);
	}

	/////////////////////////////// SPRINT-2 ///////////////////////////////

	@Autowired
	ServiceInf2 s2;

	// student viewing teacher details
	@GetMapping("/dashboard/viewteacherdetails")
	public List<TeacherDetails> viewte() {
		return s2.teacherdet();
	}

	// teacher adding course notifications
	@PostMapping("/dashboard/coursenotifications/{course}")
	public Status cnadd(@PathVariable String course, @RequestBody Cnoti cobj) {
		cobj.setCourse(course);
		return s2.addcnoti(cobj);
	}

	// student viewing course notification
	@GetMapping("/dashboard/viewcoursenotifications/{prn}")
	public List<Cnoti> viewcnoti(@PathVariable int prn) {
		return s2.viewCnoti(prn);
	}

	// teacher viewing student details course wise
	@SuppressWarnings("rawtypes")
	@GetMapping("/dashboard/viewstudents/{course}")
	public List viewStudents(@PathVariable String course) {
		return s2.getStd1All(course);
	}
}
