# TwoCities

1) This solution determines if two cites are connected based on the roads available to travel from one city to another.

2) This solution is a Spring boot application that is written in java 1.8

3) Test cases are written using JUnit 

4) This solution has a rest controller with a GET end point that accepts two query parameters which are 'origin & destination'. 
   The end point would respond with a string that says either 'yes' or 'no'.

5) There is a validation on the controller layer to check if query parameters are present or not. If they are absent we throw 
   a HTTP 400 level error saying bad request.

6) If two cities are connected the end point responds with 'yes' and if not connected the end point gives 'no' as the response.

7) For this solution I have implemented a Graph data structure as a utility to find if the two input nodes are connected.

8) Here I have used breadth first search(BFS) technique to find if the path exists between two nodes.

9) The time complexity for this solution would be O(V+E) where V stands for vertices and E stands for edges.
   In this case vertices are cities and edges are routes/paths.