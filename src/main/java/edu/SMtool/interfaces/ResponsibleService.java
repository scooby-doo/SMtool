package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.Responsible;

public interface ResponsibleService {
	public void addResponsible();
	public void deleteResponsible(int idResponsible);
	public void editResponsible(Responsible responsible);
	public Responsible getResponsibleById(int id);
	public List<Responsible> getAllResponsibles();

}
