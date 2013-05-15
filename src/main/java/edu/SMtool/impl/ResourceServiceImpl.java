package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.SMtool.entity.Resource;
import edu.SMtool.interfaces.ResourceService;
import edu.SMtool.interfaces.dao.ResourceDAO;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	private static final long serialVersionUID = -533067826172354554L;
	
	@Autowired
	ResourceDAO resourceDAO;

	@Override
	public void addResource(Resource resource) {
		resourceDAO.addResource(resource);
	}

	@Override
	public void deleteResource(Resource resource) {
		resourceDAO.deleteResource(resource);
	}

	@Override
	public void editResource(Resource resource) {
		resourceDAO.editResource(resource);
	}

	@Override
	public Resource getResourceById(int idResource) {
		return resourceDAO.getResourceById(idResource);
	}

	@Override
	public List<Resource> getAllResources() {
		return resourceDAO.getAllResources();
	}

}
