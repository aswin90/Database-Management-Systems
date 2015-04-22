package hw6.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Entity implementation class for Entity: Site
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name="Site.findAll", query="select s from Site s")})

public class Site implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int siteId;
	private String name;
	private double latitude;
	private double longitude;
	
	@OneToMany(mappedBy="site", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Tower> towers;
	private static final long serialVersionUID = 1L;
	
	public Site() {
		super();
	}
	
	public List<Tower> getTowers() {
		return towers;
	}
	@XmlElement(name="Tower")
	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}
   
	public int getId() {
		return this.siteId;
	}
	@XmlAttribute(name="id")
	public void setId(int id) {
		this.siteId = id;
	}   
	public String getName() {
		return this.name;
	}
	@XmlAttribute(name="name")
	public void setName(String name) {
		this.name = name;
	}   
	public double getLatitude() {
		return this.latitude;
	}
	@XmlAttribute(name="latitude")
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}   
	public double getLongitude() {
		return this.longitude;
	}
	@XmlAttribute(name="longitude")
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
   
}
