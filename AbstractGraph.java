/**
 * AbstractGraph.java
 * Abstract base class for graphs. A graph is a set of vertices and a set of edges. Vertices are represented
 * by integers from 0 to n - 1. Edges are ordered pairs of vertices.
 *
 * @version 1.0
 */
 
package models.graphClasses;

import java.util.*;

public abstract class AbstractGraph implements Graph {
    private int nodes; /* Number of vertices */
    private boolean isDir; /*Flag set to true or false indicating directed graph */

    /**
     * Construct a graph with the specified number of vertices and the directed flag.
     * @param nodes representing number of vertices
     * @param isDir status flag
     */
    public AbstractGraph(int nodes, boolean isDir) {
        this.nodes = nodes;
        this.isDir = isDir;
    }

    /**
     * @return number of vertices present in graph
     */
    public int getNodes() {
        return nodes;
    }

    /**
     * @return true if directed graph, otherwise false.
     */
    public boolean isDir() {
        return isDir;
    }

    /**
     * Load edges of a graph from the data in an input file. The file should contain a series of lines, each line
     * with strictly two or three data values. First is source, second is destination, and the optional third
     * is the weight.
     * @param scanner object
     */
    public void loadEdgesFromFile(Scanner scan) {
        int src;
        int dest;
        double w;
        Edge e;
        
        while (scan.hasNextLine()) {
            src = scan.nextInt();
            dest = scan.nextInt();
            if (scan.hasNextDouble()) {
                w = scan.nextDouble();
                e = new Edge(src, dest, weight);
            } else {
                e = new Edge(src, dest);
            }
            scan.nextLine();
        }
    }

    /**
     * Factory method to create a graph and load the data from an input file. The first line of the input file should
     * contain the number of vertices. The remaining lines should contain the edge data as described under loadEdgesFromFile.
     * @param scan Scanner object connected to the data file
     * @param isDir
     * @param type String "matrix" if an adjacency matrix is to be created, and string "list" if an adjacency
     *             list is to be created.
     * @throws IllegalArgumentException if type is neither matrix nor list.
     */
    public static Graph createGraph(Scanner scan, boolean isDir, String type){
        int nodes = scan.nextInt();
        AbstractGraph val = null;
        if (type.equalsIgnoreCase("matrix")) {
            //Stub out since we are not doing a matrix-version.
            //returnValue = new MatrixGraph(numV, isDirected);
        } else if (type.equalsIgnoreCase("list")) {
            val = new ListGraph(nodes, isDir);
        } else {
            throw new IllegalArgumentException();
        }
        return val;
    }

}
