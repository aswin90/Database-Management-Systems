package hw6.jpa;
import hw6.xslt.*;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
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
	
	public void exportSiteDatabaseToXmlFile(SiteList sites, String xmlFileName) {
		File xmlFile = new File(xmlFileName);
		try {
			JAXBContext jaxb = JAXBContext.newInstance(SiteList.class);
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(sites, xmlFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void convertXmlFileToOutputFile(
			String sitesXmlFileName,
			String outputFileName,
			String xsltFileName)
	{
		File inputXmlFile = new File(sitesXmlFileName);
		File outputXmlFile = new File(outputFileName);
		File xsltFile = new File(xsltFileName);
		
		StreamSource source = new StreamSource(inputXmlFile);
		StreamSource xslt    = new StreamSource(xsltFile);
		StreamResult output = new StreamResult(outputXmlFile);
		
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer transformer = factory.newTransformer(xslt);
			transformer.transform(source, output);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		SiteDao dao = new SiteDao();

	    Site site = new Site();
	    site.setLatitude(80.5);
	    site.setLongitude(50.97);
	    site.setName("site name");
	    
	    Site site2 = new Site();
	    site2.setLatitude(60.5);
	    site2.setLongitude(10.97);
	    site2.setName("site 2 name");
	   
	    
		Tower tower = new Tower();
		tower.setName("tower name");
		tower.setHeight(150);
		tower.setSlides(50);
		tower.setSite(site);
		
		Tower tower2 = new Tower();
		tower2.setName("tower 2 name");
		tower2.setHeight(77);
		tower2.setSlides(57);
		tower2.setSite(site);
		
		Tower tower3 = new Tower();
		tower3.setName("tower 3 name");
		tower3.setHeight(97);
		tower3.setSlides(16);
		tower3.setSite(site);
		tower3.setSite(site2);
		
		Equipment equipment = new Equipment();
		equipment.setBrand("tetris");
		equipment.setDescription("this is the equipment description");
		equipment.setName("equipment name");
		equipment.setPrice(25.35);
		equipment.setTower(tower);
		
		Equipment equipment2 = new Equipment();
		equipment2.setBrand("equip brand 2");
		equipment2.setDescription("this is the equipment two description");
		equipment2.setName("equipment name 2");
		equipment2.setPrice(37.35);
		equipment2.setTower(tower);
		
		Equipment equipment3 = new Equipment();
		equipment3.setBrand("equip brand 3");
		equipment3.setDescription("this is the equipment three description");
		equipment3.setName("equipment name 3");
		equipment3.setPrice(47.35);
		equipment3.setTower(tower2);
		
		List<Equipment> equipments = new ArrayList<Equipment>();
		equipments.add(equipment);
		equipments.add(equipment2);
		
		List<Equipment> equipmentsfor3 = new ArrayList<Equipment>();
		equipmentsfor3.add(equipment3);
		
		tower.setEquipments(equipments);
		tower3.setEquipments(equipmentsfor3);
		
		List<Tower> towers = new ArrayList<Tower>();
		towers.add(tower);
		
		
		List<Tower> towersfor3 = new ArrayList<Tower>();
		towersfor3.add(tower2);
		towersfor3.add(tower3);
		
		 site.setTowers(towers);
		 site2.setTowers(towersfor3);
		//dao.removeSite(6);
 	   // dao.createSite(site);
 	   //dao.createSite(site2);
	    List<Site> sites = dao.findAllSites();
	    for (Site s : sites) {
	    	System.out.println(s.getId());
	    }
	    
	    SiteList siteList = new SiteList();
	    siteList.setSites(sites);
	    dao.exportSiteDatabaseToXmlFile(siteList, "src/sites.xml");
	   /* List<Site> sites = dao.createSite(site);
	    for (Site s : sites) {
	    	System.out.println(s.getId() + "-" + s.getName());
	    }*/
	   
	    dao.convertXmlFileToOutputFile("src/sites.xml", "src/sites2html-out.html", "src/sites2html.xsl");
	    dao.convertXmlFileToOutputFile("src/sites.xml", "src/sites2equipment-out.html", "src/sites2equipment.xsl");
	}

}
