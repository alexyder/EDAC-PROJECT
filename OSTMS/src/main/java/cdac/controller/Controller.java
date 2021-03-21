package cdac.controller;

import java.util.List;	
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import cdac.modelsp1.Stloginai;
import cdac.modelsp1.Stlogindac;
import cdac.modelsp1.Stlogindbda;
import cdac.modelsp1.Sturegister;
import cdac.modelsp1.Teacherlogin;
import cdac.modelsp1.Teacherregister;
import cdac.reposp1.LoginDacrepo;
import cdac.servicesp1.Service;
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
	@Autowired
	LoginDacrepo cccc;

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
	@GetMapping("/loginst")
	public Status loginchkst(@RequestBody Stlogindac stdacobj) {
		return s.login(stdacobj.getPrn(), stdacobj.getPwd());
	}

	// Teacher login
	@GetMapping("/loginte")
	public Status loginchkte(@RequestBody Teacherlogin tobj) {
		return s.loginte(tobj.getTid(), tobj.getPwd());
	}

	// Student -> asking query
	@PostMapping("/askquery")
	public Status ask(@RequestBody Queries qobj) {
		return s.askquery(qobj.getPrn(), qobj.getModule(), qobj.getQue());
	}

//	// Student viewing his query
//	@GetMapping("/viewqueryst/{prn}") // URL => http://localhost:3000/viewqueryst/10
//	public List<Queries> view(@PathVariable int prn) {
//		return s.viewquery(prn);
//	}
	
	
	// Student viewing his query
		@GetMapping("/viewqueryst/{prn}") // URL => http://localhost:3000/viewqueryst/10
		public ResponseEntity<List<Queries>> view(@PathVariable int prn) {
			
			List l =  s.viewquery(prn);
			if(l.size()<=0)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			else
				return ResponseEntity.of(Optional.of(l));
			
		
		}
	

//	// Teacher -> viewing query
//	@GetMapping("/viewqueryte/{course}/{module}") // URL => http://localhost:3000/viewqueryst/DAC/m2
//	public List<Queries> viewte(@PathVariable String course, @PathVariable String module) { // module and course ->
//		return s.viewqueryte(course, module);
//	}
	
	
	
	// Teacher -> viewing query
		@GetMapping("/viewqueryte/{course}/{module}") // URL => http://localhost:3000/viewqueryst/DAC/m2
		public ResponseEntity<List<Queries>> viewte(@PathVariable String course, @PathVariable String module) { // module and course ->
			List l =  s.viewqueryte(course, module);
			if(l.size()<=0)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			else
				return ResponseEntity.of(Optional.of(l));
		}
	

	// Teacher -> replying query
	@PostMapping("/replyquery/{qid}")
	public ResponseEntity reply(@PathVariable int qid, @RequestBody Queries qobj) {
		boolean b = s.replyquery(qid, qobj.getReply());
		if(b)
			return ResponseEntity.status(HttpStatus.OK).build(); //200 updated
		else
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build(); // 304 not modified
		
	}

//	// Student Registration
//	@PostMapping("/stureg/{prn}")
//	public Status str(@PathVariable int prn, @RequestBody Sturegister stuobj) {
//		return s.stuReg(prn, stuobj);
//	}
	
	
	// Student Registration
		@PostMapping("/stureg/{prn}")
		public ResponseEntity str(@PathVariable int prn, @RequestBody Sturegister stuobj) {
			boolean b = s.stuReg(prn, stuobj);
			if(b)
				return ResponseEntity.status(HttpStatus.OK).build(); //200 updated
			else
				return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build(); // 304 not modified
		}
	
	

//	// Student viewing his profile // prn = 0 for guest user
//	@GetMapping("/viewprofilest/{prn}")
//	public Sturegister viewprof(@PathVariable int prn) {
//		return s.viewprofst(prn);
//	}
	
	
	// Student viewing his profile // prn = 0 for guest user
	@GetMapping("/viewprofilest/{prn}")
	public ResponseEntity<Sturegister> viewprof(@PathVariable int prn) {
		
		Sturegister str = s.viewprofst(prn);
		if(str==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.of(Optional.of(str));
		
	}
	
	

//	// Student updating profile
//	@PutMapping("/stureg/{prn}")
//	public Status stup(@PathVariable int prn, @RequestBody Sturegister stuobj) {
//		return s.updatestu(prn, stuobj);
//	}
	
	
	// Student updating profile
	@PutMapping("/stureg/{prn}")
	public ResponseEntity stup(@PathVariable int prn, @RequestBody Sturegister stuobj) {
		boolean b = s.updatestu(prn, stuobj);
		if(b)
			return ResponseEntity.status(HttpStatus.OK).build(); //200 updated
		else
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build(); // 304 not modified
	}
	
	

//	// Teacher Registration
//	@PostMapping("/teareg/{tid}")
//	public Status ter(@PathVariable int tid, @RequestBody Teacherregister teobj) {
//		return s.teaReg(tid, teobj);
//	}
	
	
	// Teacher Registration
		@PostMapping("/teareg/{tid}")
		public ResponseEntity ter(@PathVariable int tid, @RequestBody Teacherregister teobj) {
			boolean b =  s.teaReg(tid, teobj);
			if(b)
				return ResponseEntity.status(HttpStatus.ACCEPTED).build(); //202 accepted
			else 
				return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build(); // 304 not accepted
			
			
		}
	
	

//	// Teacher viewing his profile // tid = 0 for guest user
//	@GetMapping("/viewprofilete/{tid}")
//	public Teacherregister viewproft(@PathVariable int tid) {
//		return s.viewprofte(tid);
//	}
	
	
	// Teacher viewing his profile // tid = 0 for guest user
		@GetMapping("/viewprofilete/{tid}")
		public ResponseEntity<Teacherregister> viewproft(@PathVariable int tid) {
			Teacherregister tr = s.viewprofte(tid);
			if(tr==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			else
				return ResponseEntity.of(Optional.of(tr));
		}
	

	// Teacher updating profile
//	@PutMapping("/teareg/{tid}")
//	public Status teup(@PathVariable int tid, @RequestBody Teacherregister teobj) {
//		
//		return s.updatetea(tid, teobj);
//	}
	
	
	// Teacher updating profile
	@PutMapping("/teareg/{tid}")
	public ResponseEntity teup(@PathVariable int tid, @RequestBody Teacherregister teobj) {
		boolean b = s.updatetea(tid, teobj);
		if(b)
				return ResponseEntity.status(HttpStatus.OK).build(); //200  modified
		else 
				return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();//304 not modified

	}
	/////////////////////////////// SPRINT-2 ///////////////////////////////

	

	
	
	@GetMapping("studentdetails/{course}")
	public ResponseEntity<List> Studentdetails1(@PathVariable String course) {
		List list=null;
		try {
			list = s.getStd1All(course);
			return ResponseEntity.of(Optional.of(list));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
	
	
	
	
	
}
