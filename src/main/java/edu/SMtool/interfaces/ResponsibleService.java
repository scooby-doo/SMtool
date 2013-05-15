package edu.SMtool.interfaces;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Responsible;

public interface ResponsibleService extends Serializable {
	public void addResponsible(Responsible responsible);
	public void deleteResponsible(Responsible responsible);
	public void editResponsible(Responsible responsible);
	public Responsible getResponsibleById(int idResponsible);
	public List<Responsible> getAllResponsibles();

}
