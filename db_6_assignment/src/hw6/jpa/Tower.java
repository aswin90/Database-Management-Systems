package hw6.jpa;

import hw6.jpa.Site;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Tower
 *
 */
@Entity
public class Tower implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int towerId;
	private String name;
	private int height;
	private int slides;
	@ManyToOne
	@JoinColumn(name="siteId")
	private Site site;
	
	@OneToMany(mappedBy="tower",cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Equipment> equipments;
	
	private static final long serialVersionUID = 1L;

	public Tower() {
		super();
	} 
	
	public List<Equipment> getEquipments() {
		return equipments;
	}
	@XmlElement(name="Equipment")
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}  
	public int getId() {
		return this.towerId;
	}
	@XmlAttribute(name="id")
	public void setId(int id) {
		this.towerId = id;
	}   
	public String getName() {
		return this.name;
	}
	@XmlAttribute(name="name")
	public void setName(String name) {
		this.name = name;
	}   
	public int getHeight() {
		return this.height;
	}
	@XmlAttribute(name="height")
	public void setHeight(int height) {
		this.height = height;
	}   
	public int getSlides() {
		return this.slides;
	}
	@XmlAttribute(name="slides")
	public void setSlides(int slides) {
		this.slides = slides;
	}   
	public Site getSite() {
		return this.site;
	}
	@XmlTransient
	public void setSite(Site site) {
		this.site = site;
	}
   
}
