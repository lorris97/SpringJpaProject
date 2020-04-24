package eu.ensup.springbootjpaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import eu.ensup.springbootjpaweb.dao.FormationRepository;
import eu.ensup.springbootjpaweb.domaine.Formation;

public class FormationService implements IFormationService {

	@Autowired
	private FormationRepository iFr;

	public FormationService(FormationRepository iFr) {
		super();
		this.iFr = iFr;
	}

	public FormationService() {
		super();
	}

	@Override
	public List<Formation> findByName(String theme) {
		return iFr.findByTheme(theme);
	}

	@Override
	public Formation save(Formation formation) {
		return iFr.save(formation);
	}

	@Override
	public List<Formation> findAll() {
		return iFr.findAll();
	}
}
