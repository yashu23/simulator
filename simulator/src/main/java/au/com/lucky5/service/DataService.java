package au.com.lucky5.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.lucky5.data.ApiRepository;
import au.com.lucky5.data.RequestResponseRepository;
import au.com.lucky5.data.entity.Api;
import au.com.lucky5.data.entity.RequestResponse;

@Service
public class DataService {
	@Autowired
	private RequestResponseRepository requestResponseRepository;
	
	@Autowired
	private ApiRepository apiRepository;
	
	private Map<String,String> cache = new HashMap<String,String>();
	
	/*
	 * Method to locate response xml for the input xml
	 */
	public String getResponse(String requestXML){
		if(cache.size() == 0) {
			load();
		}
		return cache.get(requestXML);
	}
	
	public void load(){
		cache.clear();
		Iterator<RequestResponse> ie = requestResponseRepository.findAll().iterator();
		while(ie.hasNext()) {
			RequestResponse reqResp = ie.next();
			cache.put(reqResp.getRequestXML(),reqResp.getResponseXML());
		}
	}
	
	public void refreshCache(){
		load();
	}
	
	public void saveRequestResponse(RequestResponse reqResp){
		requestResponseRepository.save(reqResp);
	}
	
	public void deleteRequestResponse(RequestResponse reqResp){
		requestResponseRepository.delete(reqResp);
	}
	
	public List<String> getAVCList(){
		return requestResponseRepository.findDistinctAVC();
	}
	
	public Iterable<Api> getApiList(){
		return apiRepository.findAll();
	}
	
	public void saveApi(Api api){
		apiRepository.save(api);
	}
	
	public void deleteApi(Api api){
		apiRepository.delete(api);
	}
	
	@PostConstruct
	public void loadApiData(){
		Api api1 = new Api();
		api1.setName("testApi1");
		
		Api api2 = new Api();
		api2.setName("testApi2");
		
		apiRepository.save(api1);
		apiRepository.save(api2);
	}
}
