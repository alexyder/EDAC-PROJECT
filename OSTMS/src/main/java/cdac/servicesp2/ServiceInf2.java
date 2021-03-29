package cdac.servicesp2;

import java.util.List;

import cdac.courier.Status;
import cdac.modelsp1.Stlogindac;
import cdac.modelsp2.Cnoti;
import cdac.modelsp2.TeacherDetails;

public interface ServiceInf2 {

	List<TeacherDetails> teacherdet(); // student viewing teacher details

	Status addcnoti(Cnoti cobj); // teacher adding course notifications

	List<Cnoti> viewCnoti(int prn); // student viewing course notifications

	List<Stlogindac> getStd1All(String course); // fetching student details

}
