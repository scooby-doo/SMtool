package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Resource;
import edu.SMtool.interfaces.ResourceService;

@Component
public class ResourceBean implements Serializable {

	private static final long serialVersionUID = -6833158624117502311L;
	private List<Resource> resourceList;
	
	@Autowired
	ResourceService resourceService;
	
	@PostConstruct
	public void init(){
		resourceList = resourceService.getAllResources();
	}
	
	public void onEdit(RowEditEvent event){
		Resource newValue = (Resource) event.getObject();
		resourceService.editResource(newValue);
	}
	
	public void addNewResource(){
		Resource newResource = new Resource();
		resourceService.addResource(newResource);
		resourceList.add(newResource);
	}
	
	public void removeResource(Resource resource){
		resourceService.deleteResource(resource);
		resourceList.remove(resource);
	}

	public List<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}
}
