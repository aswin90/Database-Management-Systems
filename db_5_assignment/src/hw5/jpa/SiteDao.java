package hw5.jpa;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.persistence.*;
import javax.print.attribute.standard.Media;
import java.io.*;

@Path("/Site")
public class SiteDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_Assignment");
	EntityManager em = null;
	
	public SiteDao() {
		em = factory.createEntityManager();
	} 
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite(Site site) {
		em.getTransaction().begin();
		em.persist(site);
		Query query = em.createNamedQuery("Site.findAll");
		List<Site> sites = query.getResultList();
		em.getTransaction().commit();
		return sites;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id") int siteId) {
		em.getTransaction().begin();
		Site site = em.find(Site.class,siteId);
		em.getTransaction().commit();
		return site;
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites() {
		em.getTransaction().begin();
		Query query = em.createNamedQuery("Site.findAll");
		List<Site> sites = query.getResultList();
		em.getTransaction().commit();
		return sites;
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id") int siteId, Site site) {
		
		em.getTransaction().begin();
		Site s = em.find(Site.class,siteId);
		s.setName(site.getName());
		em.merge(s);
		Query query = em.createNamedQuery("Site.findAll");
		List<Site> sites = query.getResultList();
		em.getTransaction().commit();
		return sites;
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> removeSite(@PathParam("id") int siteId) {
		
		em.getTransaction().begin();
		Site site = em.find(Site.class, siteId);
		em.remove(site);
		Query query = em.createNamedQuery("Site.findAll");
		List<Site> sites = query.getResultList();
		em.getTransaction().commit();
		return sites;
	}
	
	
	
	public static void main(String[] args) {
		
		SiteDao dao = new SiteDao();

	    Site site = new Site();
	    site.setLatitude(80.5);
	    site.setLongitude(50.97);
	    site.setName("site name");
    
		Tower tower = new Tower();
		tower.setName("tower name");
		tower.setHeight(150);
		tower.setSlides(50);
		tower.setSite(site);

		Equipment equipment = new Equipment();
		equipment.setBrand("tetris");
		equipment.setDescription("this is the equipment description");
		equipment.setName("equipment name");
		equipment.setPrice(25.35);
		equipment.setTower(tower);

		List<Equipment> equipments = new ArrayList<Equipment>();
		equipments.add(equipment);
	
		tower.setEquipments(equipments);
		
		List<Tower> towers = new ArrayList<Tower>();
		towers.add(tower);
		
		site.setTowers(towers);
		
	    List<Site> sites = dao.findAllSites();
	    for (Site s : sites) {
	    	System.out.println(s.getId());
	    }
	    
	}

}
