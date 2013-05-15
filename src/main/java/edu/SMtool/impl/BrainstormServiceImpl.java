package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.SMtool.entity.Brainstorm;
import edu.SMtool.interfaces.BrainstormService;
import edu.SMtool.interfaces.dao.BrainstormDAO;

@Service("brainstormService")
public class BrainstormServiceImpl implements BrainstormService {

	private static final long serialVersionUID = 888356187279953020L;

	@Autowired
	BrainstormDAO brainstormDAO;
	
	@Override
	public void addBrainstorm(Brainstorm brainstorm) {
		brainstormDAO.addBrainstorm(brainstorm);

	}

	@Override
	public void deleteBrainstorm(Brainstorm brainstorm) {
		brainstormDAO.deleteBrainstorm(brainstorm);

	}

	@Override
	public void editBrainstorm(Brainstorm brainstorm) {
		brainstormDAO.editBrainstorm(brainstorm);

	}

	@Override
	public Brainstorm getBrainstormById(int idBrainstorm) {
		return brainstormDAO.getBrainstormById(idBrainstorm);
	}

	@Override
	public List<Brainstorm> getAllBrainstorms() {
		return brainstormDAO.getAllBrainstorms();
	}

}
