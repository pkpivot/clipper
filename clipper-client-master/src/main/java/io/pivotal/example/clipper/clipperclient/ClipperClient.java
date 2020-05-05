

package io.pivotal.example.clipper.clipperclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClipperClient {
	
	@Value("${clipper.host}")
	private String host; 
	
	@Value("${clipper.port}")
	private String port; 
	
	@Autowired
	private RestTemplate restTemplate; 
	public boolean  postTextToServer(String text ) 
	{
		HttpEntity<String> request = new HttpEntity<>(text);
        ResponseEntity<String> response = restTemplate.postForEntity(String.format("https://%s:%s/api/clip", host, port),request, String.class);
		return response.getStatusCodeValue() == 200; 
	}

	public String fetchTextFromServer() {
		return ""; 
	}
}