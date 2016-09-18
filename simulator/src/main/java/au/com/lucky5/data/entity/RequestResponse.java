package au.com.lucky5.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


/**
 * Entity class to store all request response xml files 
 * 
 * @author yashpalrawat
 *
 */

@Entity
public class RequestResponse {
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Lob
	public String getRequestXML() {
		return requestXML;
	}
	public void setRequestXML(String requestXML) {
		this.requestXML = requestXML;
	}
	@Lob
	public String getResponseXML() {
		return responseXML;
	}
	public void setResponseXML(String responseXML) {
		this.responseXML = responseXML;
	}
	
	@ManyToOne
	public Api getApi() {
		return api;
	}
	public void setApi(Api api) {
		this.api = api;
	}
	public String getAvc() {
		return avc;
	}
	public void setAvc(String avc) {
		this.avc = avc;
	}
	private long id;
	private Api api;
	private String avc;
	private String requestXML;
	private String responseXML;
}
