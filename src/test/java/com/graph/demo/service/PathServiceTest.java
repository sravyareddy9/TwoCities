/**
 * 
 */
package com.graph.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sravya.reddy
 *
 */
@SpringBootTest
public class PathServiceTest {

	@Spy
	public PathService pathService;
	
	
	@Test
	public void testPathBetweenCitiesValid() throws IOException {
		pathService.init();
		assertEquals("yes", pathService.doesPathExists("Boston", "Newark"));
		assertEquals("no", pathService.doesPathExists("Boston", "Reston"));
		assertEquals("no", pathService.doesPathExists("NaN", "Test"));
		assertEquals("no", pathService.doesPathExists("", ""));
	}
	
}

