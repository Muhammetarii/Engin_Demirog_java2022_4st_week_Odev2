package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	void add(ProgrammingLanguage programmingLanguage);
	void delete(int id);
	void modify(ProgrammingLanguage programmingLanguage) throws Exception;
	
	List<ProgrammingLanguage> getList();
	ProgrammingLanguage getById(int id);
	void save(ProgrammingLanguage programmingLanguage);
	void save(ProgrammingLanguage programmingLanguage);
		

}
