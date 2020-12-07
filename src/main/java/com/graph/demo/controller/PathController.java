/**
 * 
 */
package com.graph.demo.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.graph.demo.service.PathService;

/**
 * @author sravya.reddy
 *
 */
@RestController
public class PathController {


	@Autowired
	private PathService pathService;
	
	@GetMapping("/connected")
	public String doesPathExists(@Valid @RequestParam ("origin") String origin, @Valid @RequestParam ("destination") String destination) throws IOException {
		return pathService.doesPathExists(origin, destination);
	}
	
}
