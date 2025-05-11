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
        int n = sc.nextInt();
        int e = sc.nextInt();
        sc.nextLine();
        GraphL chemL = new GraphL(false, n, e);

        List<Pair<Integer, Integer>> doublebonds = new ArrayList<>();
        for (int i = 0; i < e; i++){
            int u = sc.nextInt();
            char bond = sc.next().charAt(0);
            int v = sc.nextInt();
            sc.nextLine();

            chemL.addEdge(u, v, 1);

            if (bond == '=') doublebonds.add(new Pair<>(u, v));
        }

        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++){
            if (chemL.adjacencyList.get(j).size() != 1) continue;

            List<Integer> dist = algo.bfs(chemL, j);
            for (Pair<Integer, Integer> bond : doublebonds){
                int u = bond.first;
                dist.add(u);
                int v = bond.second;
                dist.add(v);

                int diff = Math.min(dist.get(u), dist.get(v));

                if (diff < min) {
                    min = diff;
                }
            }
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
        int nLNode = sc.nextInt();
        int nLEdge = sc.nextInt();
        sc.nextLine();
        GraphL gL = new GraphL(false, nLNode, nLEdge);

        for (int i = 0; i < nLEdge; i++){
            int src = sc.nextInt();
            int des = sc.nextInt();
            int time = sc.nextInt();
            sc.nextLine();

            gL.addEdge(src, des, time);
        }

        int Q = sc.nextInt(); sc.nextLine();
        for (int j = 0; j < Q; j++){
            int router = sc.nextInt(); sc.nextLine();
            int totalTime = 0;

            for (int k = 0; k < nLNode; k++){
                if (k == router) continue;

                int time = algo.dijkstra(gL, router, k);

                if (time != Integer.MAX_VALUE){
                    if (totalTime < time) totalTime = time;
                }
            }

            System.out.println(totalTime);
        }
    }
}
