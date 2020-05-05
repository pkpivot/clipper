package io.pivotal.example.clipper.clipperclient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	ClipperClient client;

	@Test
	void contextLoads() {
	}
	
	@Test
	void shouldNotThrowErrorOnCopyingToClipboard() {
		
		String str = "clipboard copy";
		ClipboardUtil.copyToClipboard(str);
		
		assertEquals(str, 	ClipboardUtil.getFromClipboard());
	}
	
	
	@Test
	void shouldReturnTrueForPushingDataToServer() {
		
		String str = "This is a test string";
		
		
		assertTrue(client.postTextToServer(str));
		
		
	}

}
