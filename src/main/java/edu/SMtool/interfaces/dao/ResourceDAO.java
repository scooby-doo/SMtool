package edu.SMtool.interfaces.dao;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Resource;

public interface ResourceDAO extends Serializable {
	public void addResource(Resource resource);
	public void deleteResource(Resource resource);
	public void editResource(Resource resource);
	public Resource getResourceById(int idResource);
	public List<Resource> getAllResources();

}
