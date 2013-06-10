package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Campaign;
import edu.SMtool.entity.Event;
import edu.SMtool.entity.Goal;
import edu.SMtool.interfaces.CampaignService;
import edu.SMtool.interfaces.EventService;
import edu.SMtool.interfaces.GoalService;

@Component
public class CampaignBean implements Serializable {

	private static final long serialVersionUID = -6048827510340045259L;
	private List<Campaign> campaignList;
	private List<Event> eventList;
	private List<Goal> goalList;

	private Campaign campaign;

	@Autowired
	private ServiceUtils serviceUtils;

	@Autowired
	private CampaignService campaignService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private GoalService goalService;

	@PostConstruct
	public void init() {
		campaignList = campaignService.getAllCampaigns();
	}

	public String details() {
		System.out.println("in campaign detail");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext()
				.getRequestParameterMap();
		String id = params.get("idCampaign");
		int idInt = Integer.parseInt(id);

		campaign = campaignService.getCampaignById(idInt);
		setCampaign(campaign);
		
		eventList = eventService.getEventByCampaignId(idInt);
		setEventList(eventList);
		
		goalList = goalService.getCampaignGoalsById(idInt);
		setGoalList(goalList);

		return "/campaign/campaignDetailHome";
	}

	public void onEdit(RowEditEvent event) {
		Campaign newValue = (Campaign) event.getObject();
		campaignService.editCampaign(newValue);
	}

	public void addNewCampaign() {
		Campaign newCampaign = new Campaign();
		newCampaign.setIdProject(serviceUtils.getDefaultProject());
		campaignService.addCampaign(newCampaign);
		campaignList.add(newCampaign);
	}

	public void removeCampaign(Campaign campaign) {
		campaignService.deleteCampaign(campaign);
		campaignList.remove(campaign);
	}

	public List<Campaign> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(List<Campaign> campaignList) {
		this.campaignList = campaignList;
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public List<Goal> getGoalList() {
		return goalList;
	}

	public void setGoalList(List<Goal> goalList) {
		this.goalList = goalList;
	}
	
	
	

}
