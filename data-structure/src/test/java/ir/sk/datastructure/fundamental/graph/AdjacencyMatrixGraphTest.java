package ir.sk.datastructure.fundamental.graph;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.keyvanfar on 7/1/2020.
 */
public class AdjacencyMatrixGraphTest {

    private AdjacencyMatrixGraph theGraph;

    @Before
    public void setUp() throws Exception {
        theGraph = new AdjacencyMatrixGraph();
        theGraph.addVertex('A'); // 0 (start for dfs)
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void dfs() {
        theGraph.dfs();
        System.out.println();
    }

    @Test
    public void bfs() {
        theGraph.bfs();
        System.out.println();
    }
}