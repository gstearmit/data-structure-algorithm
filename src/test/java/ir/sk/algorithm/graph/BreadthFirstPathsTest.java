package ir.sk.algorithm.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 5/8/2021.
 */
public class BreadthFirstPathsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void hasPathTo() {
    }

    @Test
    public void distTo() {
    }

    @Test
    public void pathTo() {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, 1);

        for (int v = 0; v < graph.vertexSize(); v++) {
            if (bfs.hasPathTo(v)) {
                System.out.printf("%d to %d:  ", 1, v);
                for (int x : bfs.pathTo(v)) {
                    if (x == 1) System.out.println(x);
                    else System.out.print(x);
                }
                System.out.println();
            }

            else {
                System.out.printf("%d to %d:  not connected\n", 1, v);
            }

        }
    }
}