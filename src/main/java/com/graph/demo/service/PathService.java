/**
 * 
 */
package com.graph.demo.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import com.graph.demo.util.Graph;

/**
 * @author sravya.reddy
 *
 */
@Service
public class PathService {
	
	Map<String, Integer> pathData = new HashMap<String, Integer>();
	
	Graph graph;
	
	public static final String PATH_EXISTS = "yes";
	
	public static final String PATH_DOESNT_EXISTS = "no";
	
	public static final String FILE_PATH = "C:\\\\Users\\\\reddy\\\\Documents\\\\workspace-spring-tool-suite-4-4.6.0.RELEASE\\\\TwoCities\\\\twocities.txt";
	
	@PostConstruct
	public void init() throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(FILE_PATH), StandardCharsets.UTF_8);
		for (String s: lines)
        {
            String[] s_arr = s.split(",");
            for(int i=0; i<s_arr.length; i++)
            {
                if(!pathData.containsKey(s_arr[i]))
                {
                	pathData.put(s_arr[i], pathData.size());
                }
            }
        }
		graph = new Graph(pathData.size());
		for(String s: lines)
        {
            String[] s_arr = s.split(",");
            graph.addEdge(pathData.get(s_arr[0]), pathData.get(s_arr[1]));
            graph.addEdge(pathData.get(s_arr[1]), pathData.get(s_arr[0]));
        }  
	}

	public String doesPathExists(String origin, String destination) throws IOException {
		if (pathData.get(origin) != null && pathData.get(destination) != null) {
        	return graph.isReachable(pathData.get(origin), pathData.get(destination)) ? PATH_EXISTS:PATH_DOESNT_EXISTS;
        }
        else {
        	return PATH_DOESNT_EXISTS;
        }
	}
	
}
