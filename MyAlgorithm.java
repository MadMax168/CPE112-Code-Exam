// Implement your code in this file
import java.util.*;

public class MyAlgorithm extends Algorithm{
    
    public MyAlgorithm(){
    }

    public List<Integer> preorder(BST tree){
        List<Integer> order = new ArrayList<>();
        preorderUtil(tree.root, order);
        return order;
    }
    public void preorderUtil(BinNode root, List<Integer> order){
        if (root == null) return;
        order.add(root.node);
        preorderUtil(root.leftChild, order);
        preorderUtil(root.rightChild, order);
    }

    public List<Integer> inorder(BST tree){
        List<Integer> order = new ArrayList<>();
        inorderUtil(tree.root, order);
        return order;
    }
    public void inorderUtil(BinNode root, List<Integer> order){
        if (root == null) return;
        inorderUtil(root.leftChild, order);
        order.add(root.node);
        inorderUtil(root.rightChild, order);
    }

    public List<Integer> postorder(BST tree){
        List<Integer> order = new ArrayList<>();
        postorderUtil(tree.root, order);
        return order;
    }
    public void postorderUtil(BinNode root, List<Integer> order){
        if (root == null) return;
        postorderUtil(root.leftChild, order);
        postorderUtil(root.rightChild, order);
        order.add(root.node);
    }

    public List<Integer> dfs(GraphM graph, int startNode){
        List<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.size()];
        
        dfsUtil(graph, startNode, isVisited, result);

        return result;
    }
    public void dfsUtil(GraphM graph, int curr, boolean[] isVisited, List<Integer> result){
        isVisited[curr] = true; //Set the node to visited
        result.add(curr); //Add node into result

        for(int n = graph.size() - 1; n >= 0 ; n--){
            if (graph.matrix[curr][n] == 1 && !isVisited[n]) {
                dfsUtil(graph, n, isVisited, result); //Recall func dfsUtil but start with neighbor not startnode
            } //Check neighbor has edge? and is it visited?
        } //Loop from heighest to less. Cause LIFO concept
    }

    public List<Integer> bfs(GraphL graph, int startNode){
        List<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.size()]; //Add range of arr from graph size but have to create size func in graphL
        Queue<Integer> q = new LinkedList<>();

        q.add(startNode);
        isVisited[startNode] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);

            for (Pair<Integer, Integer> edge : graph.adjacencyList.get(curr)){
                int n = edge.first; // first is from Pair<first, second> second = weight;
                if (!isVisited[n]){
                    isVisited[n] = true;
                    q.add(n);
                }
            }
        }        

        return result;
    }

    public int floyd(GraphM graph, int startNode, int destNode){
        int[][] dist = new int[graph.size()][graph.size()];

        //insert distance data into dist[][] and setup
        for (int i = 0; i < graph.size(); i++){
            for (int j = 0; j < graph.size(); j++){
                if (i == j) {
                    dist[i][j] = 0; //if from node A to A set it to 0
                } else if (graph.matrix[i][j] != 0){
                    dist[i][j] = graph.matrix[i][j];
                } else {
                    dist[i][j] = Integer.MAX_VALUE; //if no Path set INF
                }
            }
        }

        //floyd utility
        for (int k = 0; k < graph.size(); k++) {
            for (int i = 0; i < graph.size(); i++) {
                for (int j = 0; j < graph.size(); j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    } // filter just only has path and must be less than start to dest
                }
            }
        }

        return dist[startNode][destNode] == Integer.MAX_VALUE ? 0 : dist[startNode][destNode]; //Chat said it be better if found no Path
    }

    public boolean warshall(GraphM graph, int startNode, int destNode){
        boolean[][] path = new boolean[graph.size()][graph.size()];

        for (int i = 0; i < graph.size(); i++){
            for (int j = 0; j < graph.size(); j++){
                path[i][j] = (graph.matrix[i][j] != 0); //if has path = true, no = false
            }
        }

        for (int k = 0; k < graph.size(); k++) {
            for (int i = 0; i < graph.size(); i++) {
                for (int j = 0; j < graph.size(); j++) {
                    if (!path[i][j]) {
                        path[i][j] = path[i][k] && path[k][j];
                    }
                }
            }
        } //K is a node that between 2 nodes

        return path[startNode][destNode];
    }
    
    public int dijkstra(GraphL graph, int startNode, int destNode){
        int[] dist = new int[graph.size()];
        boolean[] isVisited = new boolean[graph.size()];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(p -> p.second)
        );

        pq.add(new Pair<>(startNode, 0));

        while (!pq.isEmpty()){
            Pair<Integer, Integer> curr = pq.poll();
            int u = curr.first;

            if(isVisited[u]) continue;
            isVisited[u] = true;

            for (Pair<Integer, Integer> edge : graph.adjacencyList.get(u)){
                int n = edge.first;
                int weight = edge.second;

                if (!isVisited[n] && dist[u] + weight < dist[n]) {
                    dist[n] = dist[u] + weight;
                    pq.add(new Pair<>(n, dist[n]));
                }

            }
        }

        return dist[destNode];
    }
}