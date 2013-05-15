package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Campaign;
import edu.SMtool.interfaces.CampaignService;

@Component
public class CampaignBean implements Serializable {

	private static final long serialVersionUID = -6048827510340045259L;
	private List<Campaign> campaignList;
	
	@Autowired
	private CampaignService campaignService;
	
	@PostConstruct
	public void init(){
		campaignList = campaignService.getAllCampaigns();
	}
	
	public void onEdit(RowEditEvent event){
		Campaign newValue = (Campaign) event.getObject();
		campaignService.editCampaign(newValue);
	}
	
	public void addNewCampaign(){
		Campaign newCampaign = new Campaign();
		campaignService.addCampaign(newCampaign);
		campaignList.add(newCampaign);
	}
	
	public void removeCampaign(Campaign campaign){
		campaignService.deleteCampaign(campaign);
		campaignList.remove(campaign);
	}

	public List<Campaign> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(List<Campaign> campaignList) {
		this.campaignList = campaignList;
	}
	
	

}
