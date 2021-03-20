package cdac.servicesp1;

import java.util.List;	

import cdac.courier.Status;
import cdac.modelsp1.Gnoti;
import cdac.modelsp1.Queries;
import cdac.modelsp1.Stloginai;
import cdac.modelsp1.Stlogindac;
import cdac.modelsp1.Stlogindbda;
import cdac.modelsp1.Sturegister;
import cdac.modelsp1.Teacherregister;


public interface ServiceInf {

	List<Gnoti> gnotifetch(); // gnotification fetching

	Status addgnoti(String msg); // gnotification adding

	Status login(int prn, String pwd); // student login

	Status loginte(int tid, String pwd); // teacher login

	Status askquery(int prn, String module, String text); // student asking query

	List<Queries> viewquery(int prn); // student viewing his query

	List<Queries> viewqueryte(String course, String module); // teacher viewing queries

	Status replyquery(int qid, String reply); // teacher replying query

	Status stuReg(int prn, Sturegister stuobj); // student registration

	Sturegister viewprofst(int prn); // student viewing profile

	Status updatestu(int prn, Sturegister stuobj); // student updating profile

	Status teaReg(int tid, Teacherregister teobj); // teacher registration

	Teacherregister viewprofte(int tid); // teacher viewing his profile

	Status updatetea(int prn, Teacherregister teobj); // teacher updating profile
	
	List<Stlogindac>getStd1All(String course); // fetching student details
	
	
	
	
	

}
