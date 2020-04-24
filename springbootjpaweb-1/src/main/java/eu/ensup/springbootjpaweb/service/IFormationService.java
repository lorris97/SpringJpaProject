package eu.ensup.springbootjpaweb.service;

import java.util.List;

import eu.ensup.springbootjpaweb.domaine.Formation;

public interface IFormationService {

	List<Formation> findByName(String theme);

	Formation save(Formation formation);

	List<Formation> findAll();

}