package edu.SMtool.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
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
