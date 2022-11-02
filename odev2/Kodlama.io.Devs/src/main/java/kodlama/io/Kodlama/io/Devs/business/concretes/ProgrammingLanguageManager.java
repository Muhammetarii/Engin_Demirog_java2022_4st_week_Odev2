package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
		private ProgrammingLanguageRepository programmingLanguageRepository;
		

	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
			//super();
			this.programmingLanguageRepository = programmingLanguageRepository;
		}
	
	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		
		if (programmingLanguage.getName().isBlank()) {
			throw new Exception("Programlama dili boş geçilemez!");
		}
		
		for (ProgrammingLanguage inDbLanguage : programmingLanguageRepository.getList()) {
			if (inDbLanguage.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Bu isimli programlama dili zaten mevcut!");
			}
			if (inDbLanguage.getId() == programmingLanguage.getId()) {
				throw new Exception("İd tekrar edemez!");
			}
		}
		
		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(int id) throws Exception {
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguageRepository.getList()) {
			if (programmingLanguage.getId() == id ) {
				programmingLanguageRepository.delete(id);
			}
		}
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		
		if (programmingLanguage.getName().isBlank()) {
			throw new Exception("Programlama dili boş geçilemez!");
		}
		
		for (ProgrammingLanguage inDbLanguage : programmingLanguageRepository.getList()) {
			if (inDbLanguage.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Bu isimli programlama dili zaten mevcut!");
			}
		}
		
			programmingLanguageRepository.modify(programmingLanguage);
	
	


	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguageRepository.getList();
	}

	@Override
	public ProgrammingLanguage getProgrammingLanguageById(int id) {
		
		return programmingLanguageRepository.getById(id);
	}

}
