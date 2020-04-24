package eu.ensup.springbootjpaweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.ensup.springbootjpaweb.domaine.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

}