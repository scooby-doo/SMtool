package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Responsible;
import edu.SMtool.interfaces.ResponsibleService;
import edu.SMtool.interfaces.dao.ResponsibleDAO;

@Service("responsibleService")
public class ResponsibleServiceImpl implements ResponsibleService {

	private static final long serialVersionUID = -8609856193880005442L;
	
	@Autowired
	ResponsibleDAO responsibleDAO;
	
	@Override
	@Transactional
	public Responsible getDefaultResponsible(){
		return responsibleDAO.getDefaultResponsible();
	}

	@Override
	public void addResponsible(Responsible responsible) {
		responsibleDAO.addResponsible(responsible);
	}

	@Override
	public void deleteResponsible(Responsible responsible) {
		responsibleDAO.deleteResponsible(responsible);
	}

	@Override
	public void editResponsible(Responsible responsible) {
		responsibleDAO.editResponsible(responsible);
	}

	@Override
	public Responsible getResponsibleById(int idResponsible) {
		return responsibleDAO.getResponsibleById(idResponsible);
	}

	@Override
	public List<Responsible> getAllResponsibles() {
		return responsibleDAO.getAllResponsibles();
	}

}
