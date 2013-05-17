package edu.SMtool.interfaces.dao;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Campaign;

public interface CampaignDAO extends Serializable {
	public Campaign getDefaultCampaign();
	public void addCampaign(Campaign campaign);
	public void deleteCampaign(Campaign campaign);
	public void editCampaign(Campaign campaign);
	public Campaign getCampaignById(int idCampaign);
	public List<Campaign> getAllCampaigns();

}
