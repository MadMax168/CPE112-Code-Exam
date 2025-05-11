// Implement your code in this file.
import java.util.*;

public class GraphL extends AdjL{
    boolean isDirected;
    int numVertices;
    int numEdges;

    public GraphL(boolean isDirected, int numVertices, int numEdges){
        super();
        this.isDirected = isDirected;
        this.numVertices = numVertices;
        this.numEdges = numEdges;

        for (int i = 0; i < numVertices; i++) {
            this.adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight){
        adjacencyList.putIfAbsent(src, new ArrayList<>());
        adjacencyList.putIfAbsent(dest, new ArrayList<>());

        this.adjacencyList.get(src).add(new Pair<>(dest, weight));
        if(!isDirected){
            this.adjacencyList.get(dest).add(new Pair<>(src, weight));
        }
    }

    public int size(){
        return adjacencyList.size();
    }
}
