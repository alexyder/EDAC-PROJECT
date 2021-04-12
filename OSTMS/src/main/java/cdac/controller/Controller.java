package cdac.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cdac.courier.Status;
import cdac.modelsp1.Gnoti;
import cdac.modelsp1.Queries;
import cdac.modelsp1.Stlogindac;
import cdac.modelsp1.Teacherlogin;
import cdac.modelsp2.Cnoti;
import cdac.modelsp2.TeacherDetails;
import cdac.modelsp3.Myfiles;
import cdac.servicesp1.Service;
import cdac.servicesp2.ServiceInf2;
import cdac.servicesp3.FileService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Controller {

	// ----- testing ----- //

//	@Autowired
//	TestRepo trtr;
//
//	@RequestMapping("/mytest") // URL => http://localhost:3000/mytest
//	public String xyz() {
//		return "Connected to Backend";
//	}

	// ----- testing ----- //

	/////////////////////////////// SPRINT-1 ///////////////////////////////

	@Autowired
	Service s;

	// General Notifications - showing in home page
	@GetMapping("/gnoti")
	public ResponseEntity<List<Gnoti>> gnf() {
		List<Gnoti> gobj = s.gnotifetch();
		if (gobj.size() > 0)
			return ResponseEntity.ok(gobj);
		else
			return ResponseEntity.notFound().build();

	}

	// General Notifications - teacher is adding new notification
	@PostMapping("/gnoti")
	public ResponseEntity<Object> gnf2(@RequestBody Status sobj) {

		boolean a = s.addgnoti(sobj.getMsg());
		if (a)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	// Student login
	// content of all the 3 class is same thats why stlogindac can store other
	// class's data
	// advantage => only one login function
	@PostMapping("/loginst")
	public ResponseEntity<String> loginchkst(@RequestBody Stlogindac stdacobj) {
		Status a = s.login(stdacobj.getPrn(), stdacobj.getPwd());
		if (a.isBobo())
			return ResponseEntity.ok(a.getMsg());
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// Teacher login
	@PostMapping("/loginte")
	public ResponseEntity<String> loginchkte(@RequestBody Teacherlogin tobj) {
		Status a = s.loginte(tobj.getTid(), tobj.getPwd());
		if (a.isBobo())
			return ResponseEntity.ok(a.getMsg());
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// Student -> asking query
	@PostMapping("/dashboard/askquery")
	public ResponseEntity<String> ask(@RequestBody Queries qobj) {
		boolean a = s.askquery(qobj.getPrn(), qobj.getModule(), qobj.getQue());
		if (a)
			return ResponseEntity.ok("Query Sent");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	// Student viewing his query
	@GetMapping("/dashboard/viewqueryst/{prn}") // URL => http://localhost:3000/viewqueryst/10
	public ResponseEntity<List<Queries>> view(@PathVariable int prn) {
		List<Queries> a = s.viewquery(prn);
		if (a.size() > 0)
			return ResponseEntity.ok(a);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// Teacher -> viewing query
	@GetMapping("/viewqueryte/{course}/{module}") // URL => http://localhost:3000/viewqueryst/DAC/m2
	public ResponseEntity<List<Queries>> viewte(@PathVariable String course, @PathVariable String module) {
		List<Queries> aa = s.viewqueryte(course, module);
		if (aa.size() > 0)
			return ResponseEntity.ok(aa);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// Teacher -> replying query
	@PostMapping("/replyquery/{qid}")
	public ResponseEntity<Object> reply(@PathVariable int qid, @RequestBody Queries qobj) {
		boolean a = s.replyquery(qid, qobj.getReply());
		if (a)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	// Registration and profile part is excluded
	// --------------------------------------------------------------------------------------------
//
//	// Student Registration
//	@PostMapping("/stureg/{prn}")
//	public Status str(@PathVariable int prn, @RequestBody Sturegister stuobj) {
//		return s.stuReg(prn, stuobj);
//	}
//
//	// Student viewing his profile // prn = 0 for guest user
//	@GetMapping("/viewprofilest/{prn}")
//	public Sturegister viewprof(@PathVariable int prn) {
//		return s.viewprofst(prn);
//	}
//
//	// Student updating profile
//	@PutMapping("/stureg/{prn}")
//	public Status stup(@PathVariable int prn, @RequestBody Sturegister stuobj) {
//		return s.updatestu(prn, stuobj);
//	}
//
//	// Teacher Registration
//	@PostMapping("/teareg/{tid}")
//	public Status ter(@PathVariable int tid, @RequestBody Teacherregister teobj) {
//		return s.teaReg(tid, teobj);
//	}
//
//	// Teacher viewing his profile // tid = 0 for guest user
//	@GetMapping("/viewprofilete/{tid}")
//	public Teacherregister viewproft(@PathVariable int tid) {
//		return s.viewprofte(tid);
//	}
//
//	// Teacher updating profile
//	@PutMapping("/teareg/{tid}")
//	public Status teup(@PathVariable int tid, @RequestBody Teacherregister teobj) {
//		return s.updatetea(tid, teobj);
//	}

	/////////////////////////////// SPRINT-2 ///////////////////////////////

	@Autowired
	ServiceInf2 s2;

	// student viewing teacher details
	@GetMapping("/dashboard/viewteacherdetails")
	public ResponseEntity<List<TeacherDetails>> viewte() {
		List<TeacherDetails> tdobj = s2.teacherdet();
		if (tdobj.size() > 0)
			return ResponseEntity.ok(tdobj);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// teacher adding course notifications
	@PostMapping("/dashboard/coursenotifications/{course}")
	public ResponseEntity<Object> cnadd(@PathVariable String course, @RequestBody Cnoti cobj) {
		cobj.setCourse(course);
		boolean a = s2.addcnoti(cobj);
		if (a)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	// student viewing course notification
	@GetMapping("/dashboard/viewcoursenotifications/{prn}")
	public ResponseEntity<List<Cnoti>> viewcnoti(@PathVariable int prn) {
		List<Cnoti> cobj = s2.viewCnoti(prn);
		if (cobj.size() > 0)
			return ResponseEntity.ok(cobj);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// teacher viewing student details course wise
	@SuppressWarnings("rawtypes")
	@GetMapping("/dashboard/viewstudents/{course}")
	public ResponseEntity<List> viewStudents(@PathVariable String course) {
		List<Stlogindac> a = s2.getStd1All(course);
		if (a.size() > 0)
			return ResponseEntity.ok(a);
		else
			return ResponseEntity.notFound().build();
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
