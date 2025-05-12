// Implement your code in this file
public class GraphM extends AdjM{
    boolean isDirected;
    int numVertices;
    int numEdges;

    public GraphM(int n, boolean isDirected){
        super(n);
        this.isDirected = isDirected;
        this.numVertices = n;
    }

    public void addEdge(int i, int j, int weight){
        matrix[i][j] = weight;
        if(!isDirected)
            matrix[j][i] = weight;
    }

    public int size(){
        return matrix.length;
    }

}
