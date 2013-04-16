package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.Brainstorm;

public interface BrainstormService {
	public void addBrainstorm();
	public void deleteBrainstorm();
	public void editBrainstorm(Brainstorm brainstorm);
	public Brainstorm getBrainstormById(int idBrainstorm);
	public List<Brainstorm> getAllBrainstorms();

}
