package cdac.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cdac.courier.Status;
import cdac.modelsp1.Gnoti;
import cdac.modelsp1.Queries;
import cdac.modelsp1.Stlogindac;
import cdac.modelsp1.Sturegister;
import cdac.modelsp1.Teacherlogin;
import cdac.modelsp1.Teacherregister;
import cdac.modelsp2.Cnoti;
import cdac.modelsp2.TeacherDetails;
import cdac.modelsp3.Myfiles;
import cdac.servicesp1.Service;
import cdac.servicesp2.ServiceInf2;
import cdac.servicesp3.FileService;
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

	/////////////////////////////// SPRINT-3 ///////////////////////////////

	// FILE - UPLOAD

	@Autowired
	FileService s3;

	@PostMapping("/upload/{course}")
	public String upload(@RequestParam("file") MultipartFile file, @PathVariable String course) {
		return s3.uploadFile(file, course);
	}

	// FILE - DISPLAYING

	@GetMapping("/getallfilesforteacher")
	public List<Myfiles> getteacher() {
		return s3.displayingAllFilesforTeacher();
	}

	@GetMapping("/getallfilesforstudent/{course}")
	public List<Myfiles> getstudent(@PathVariable String course) {
		System.out.println(course);
		List<Myfiles> a = s3.displayingAllFilesforStudent(course);
		System.out.println(a);
		return s3.displayingAllFilesforStudent(course);
	}

	// FILE - DOWNLOAD

	@GetMapping("/downloadfile/{fileid}")
	ResponseEntity<byte[]> download(@PathVariable int fileid, HttpServletRequest request) {

		Myfiles mobj = s3.downloadFile(fileid);

		if (mobj != null) {
			String mimeType = request.getServletContext().getMimeType(mobj.getFilename());
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=" + mobj.getFilename())
					.body(mobj.getData());
		}
		return null;
	}
}
