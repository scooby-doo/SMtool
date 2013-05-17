package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.SMtool.entity.Campaign;
import edu.SMtool.interfaces.CampaignService;
import edu.SMtool.interfaces.dao.CampaignDAO;

@Service("campaignService")
public class CampaignServiceImpl implements CampaignService {

	private static final long serialVersionUID = 8077335953169920475L;
	
	@Autowired
	CampaignDAO campaignDAO;
	
	@Override
	public Campaign getDefaultCampaign(){
		return campaignDAO.getDefaultCampaign();
	}
	
	@Override
	public void addCampaign(Campaign campaign) {
		campaignDAO.addCampaign(campaign);
	}

	@Override
	public void deleteCampaign(Campaign campaign) {
		campaignDAO.deleteCampaign(campaign);
	}

	@Override
	public void editCampaign(Campaign campaign) {
		campaignDAO.editCampaign(campaign);
	}

	@Override
	public Campaign getCampaignById(int idCampaign) {
		return campaignDAO.getCampaignById(idCampaign);
	}

	@Override
	public List<Campaign> getAllCampaigns() {
		return campaignDAO.getAllCampaigns();
	}

}
