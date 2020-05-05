package io.pivotal.example.clipper.clipperclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	ClipperClient client;

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		String text = ClipboardUtil.getFromClipboard();
		
		System.out.println("Clipboard Text: "+text);
		
		if (text != null || text.trim().length() > 0) {
			System.out.println(client.postTextToServer(text));
		}
		
	}
	
	@Bean
	public RestTemplate configureRestTemplate() { 
		return new RestTemplate() ; 
 	}
}
