package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.Campaign;

public interface CampaignService {
	public void addCampaign();
	public void deleteCampaign();
	public void editCampaign(Campaign campaign);
	public Campaign getCampaignById(int idCampaign);
	public List<Campaign> getAllCampaigns();

}
