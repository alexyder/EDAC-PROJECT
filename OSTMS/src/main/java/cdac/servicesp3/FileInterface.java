package cdac.servicesp3;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cdac.modelsp3.Myfiles;

public interface FileInterface {

	String uploadFile(MultipartFile file, String course); // saving file in database

	List<Myfiles> displayingAllFilesforTeacher(); // displaying files to student course wise

	List<Myfiles> displayingAllFilesforStudent(String course); // displaying all the files to teacher

	Myfiles downloadFile(int fileid); // checking file in database using file-id

}
