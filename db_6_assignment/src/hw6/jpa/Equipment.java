package hw6.jpa;

import hw6.jpa.Tower;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Equipment
 *
 */
@Entity
public class Equipment implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int equipmentId;
	private String name;
	private String brand;
	private String description;
	private double price;
	@ManyToOne
	@JoinColumn(name="towerId")
	private Tower tower;
	private static final long serialVersionUID = 1L;

	public Equipment() {
		super();
	}   
	public int getId() {
		return this.equipmentId;
	}
	@XmlAttribute(name="id")
	public void setId(int id) {
		this.equipmentId = id;
	}   
	public String getName() {
		return this.name;
	}
	@XmlAttribute(name="name")
	public void setName(String name) {
		this.name = name;
	}   
	public String getBrand() {
		return this.brand;
	}
	@XmlAttribute(name="brand")
	public void setBrand(String brand) {
		this.brand = brand;
	}   
	public String getDescription() {
		return this.description;
	}
	@XmlAttribute(name="description")
	public void setDescription(String description) {
		this.description = description;
	}   
	public double getPrice() {
		return this.price;
	}
	@XmlAttribute(name="price")
	public void setPrice(double price) {
		this.price = price;
	}   
	public Tower getTower() {
		return this.tower;
	}
	@XmlTransient
    public void setTower(Tower tower) {
		this.tower = tower;
	}
   
}
