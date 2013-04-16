package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.Resource;

public interface ResourceService {
	public void addResource();
	public void deleteResource();
	public void editResource(Resource resource);
	public Resource getResourceById(int idResource);
	public List<Resource> getAllResources();

}
