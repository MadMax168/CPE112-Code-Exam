/*
 * There should be 
 * one Main class per problem
 * such as, MainMagicPowder.java, MainVindows.java, etc.
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyAlgorithm algo = new MyAlgorithm();
        /* problem 1 Test */
        BST t = new BST();
        int nNodeT = sc.nextInt();
        for (int i = 0; i < nNodeT; i++){
            int tempVal = sc.nextInt();
            t.insertNode(tempVal);
        }

        System.out.println(algo.inorder(t)); //Tree answer

        /* problem 2 Magic Powder */
        int n = sc.nextInt() + 1;
        int e = sc.nextInt();
        sc.nextLine();
        GraphL chemL = new GraphL(false, n, e);

        int dest = -1;
        for (int i = 0; i < e; i++){
            int u = sc.nextInt();
            char bond = sc.next().charAt(0);
            int v = sc.nextInt();
            sc.nextLine();

            chemL.addEdge(u, v, 1);

            if (bond == '=') dest = v;
        }

        List<Integer> leaf = new ArrayList<>();
        for (int i = 0; i < chemL.numVertices; i++){
            if (chemL.adjacencyList.containsKey(i) && chemL.adjacencyList.get(i).size() == 1) {
                leaf.add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < leaf.size(); j++){
            int dist = algo.dijkstra(chemL, leaf.get(j), dest) + 1;
            
            if (dist < min) min = dist;
        }
        
        System.out.println(min);

        /* problem 3 Cokrabue */
        int nNodeG = sc.nextInt(); sc.nextLine();
        GraphM gM = new GraphM(nNodeG, false);
        
        while (true) {
            String relate = sc.nextLine();
            if (relate.equals("0")) break;

            char a = relate.charAt(0);
            char b = relate.charAt(2);
            int u = a - 'A';
            int v = b - 'A';
            gM.addEdge(u, v, 1);
        }

        int nQ = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < nQ; i++){
            String ans = sc.nextLine();

            char a = ans.charAt(0);
            char b = ans.charAt(2);
            int u = a - 'A';
            int v = b - 'A';

            List<Integer> result = algo.dfs(gM, u);
            if (result.contains(v)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        /* problem 4 Network Engineer */
        int nN = sc.nextInt();
        int nE = sc.nextInt();
        sc.nextLine();
        GraphL gNet = new GraphL(false, nN, nE);

        for (int i = 0; i < nE; i++){
            int src = sc.nextInt();
            int des = sc.nextInt();
            int time = sc.nextInt();
            sc.nextLine();

            gNet.addEdge(src, des, time);
        }

        int qNet = sc.nextInt(); sc.nextLine();
        

        sc.close();
    }
}
