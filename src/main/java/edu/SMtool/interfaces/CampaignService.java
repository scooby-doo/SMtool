package edu.SMtool.interfaces;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Campaign;

public interface CampaignService extends Serializable {
	public void addCampaign(Campaign campaign);
	public void deleteCampaign(Campaign campaign);
	public void editCampaign(Campaign campaign);
	public Campaign getCampaignById(int idCampaign);
	public Campaign getDefaultCampaign();
	public List<Campaign> getAllCampaigns();

}
