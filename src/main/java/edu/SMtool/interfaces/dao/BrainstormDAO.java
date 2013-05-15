package edu.SMtool.interfaces.dao;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Brainstorm;

public interface BrainstormDAO extends Serializable {
	public void addBrainstorm(Brainstorm brainstorm);
	public void deleteBrainstorm(Brainstorm brainstorm);
	public void editBrainstorm(Brainstorm brainstorm);
	public Brainstorm getBrainstormById(int idBrainstorm);
	public List<Brainstorm> getAllBrainstorms();
	
}
