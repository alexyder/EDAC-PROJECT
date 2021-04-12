package cdac.servicesp3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import cdac.modelsp3.Myfiles;
import cdac.reposp3.Myfilesrepo;

@Service
public class FileService implements FileInterface {

	@Autowired
	Myfilesrepo mfr;

	@Override
	public String uploadFile(MultipartFile file, String course) {
		try {

			String filename = StringUtils.cleanPath(file.getOriginalFilename());
			Myfiles m = new Myfiles(filename, file.getContentType(), file.getBytes(), course);
			mfr.save(m);
			return "success";
		} catch (Exception e) {
			return "failed";
		}
	}

	@Override
	public List<Myfiles> displayingAllFilesforTeacher() {
		return mfr.findAll();
	}

	@Override
	public List<Myfiles> displayingAllFilesforStudent(String course) {
		return mfr.findByCourse(course);
	}

	@Override
	public Myfiles downloadFile(int fileid) {
		Optional<Myfiles> t = mfr.findById(fileid);
		if (t.isPresent()) {
			Myfiles mobj = t.get();
			return mobj;
		}
		return null;
	}
}
