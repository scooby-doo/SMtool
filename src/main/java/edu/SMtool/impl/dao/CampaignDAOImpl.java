package edu.SMtool.impl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Campaign;
import edu.SMtool.interfaces.dao.CampaignDAO;

@Repository
public class CampaignDAOImpl implements CampaignDAO {

	private static final long serialVersionUID = -4402266947790370911L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Campaign> getCampaignsByProjectId(int idProject){
		@SuppressWarnings("unchecked")
		List<Campaign> campaignList = sessionFactory.getCurrentSession().createCriteria(Campaign.class)
				.add(Restrictions.eq("idProject.id",idProject)).list();
		if(campaignList == null) {campaignList = new ArrayList<Campaign>(); } 
		return campaignList;
	}
	
	@Override
	@Transactional
	public Campaign getDefaultCampaign(){
		return getCampaignById(1);
	}

	@Override
	@Transactional
	public void addCampaign(Campaign campaign) {
		sessionFactory.getCurrentSession().saveOrUpdate(campaign);

	}

	@Override
	@Transactional
	public void deleteCampaign(Campaign campaign) {
		sessionFactory.getCurrentSession().delete(campaign);

	}

	@Override
	@Transactional
	public void editCampaign(Campaign campaign) {
		sessionFactory.getCurrentSession().update(campaign);

	}

	@Override
	@Transactional
	public Campaign getCampaignById(int idCampaign) {
		Campaign campaign = (Campaign) sessionFactory.getCurrentSession().get(Campaign.class, idCampaign);
		return campaign;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Campaign> getAllCampaigns() {
		List<Campaign> campaignList = sessionFactory.getCurrentSession().createQuery("from Campaign").list();
		return campaignList;
	}

}
