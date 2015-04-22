package hw6.xslt;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import hw6.jpa.*;

@XmlRootElement(name="Sites")
public class SiteList {

	private List<Site> sites;

	public List<Site> getSites() {
		return sites;
	}
    @XmlElement(name="Site")	
	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
}
