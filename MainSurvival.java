import java.util.*;

public class MainSurvival {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MyAlgorithm algo = new MyAlgorithm();
        /* Ep.1 */
        int nC = sc.nextInt(); sc.nextLine();
        GraphM gM = new GraphM(nC, true);

        List<Integer> cave = new ArrayList<>();
        for (int i = 0; i < nC; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int dist = sc.nextInt();
            sc.nextLine();

            gM.addEdge(src, dest, dist);
        }

        boolean[] path = new boolean[nC];
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < nC; i++) {
            System.out.println("From Cave " + i + ", reachable caves:");

            for (int j = 0; j < nC; j++) {
                if (i == j) continue;
                path[i] = algo.warshall(gM, i, j);
                
                if (path[i] == true) {
                    str.append(", ").append(j);
                }
            }
            System.out.println("[" + i + "" + str + "]");
            str.delete(0, str.length());
        } //Testcase 2 not work have to make reverse checking

        /* Ep.2 */
        int nH = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        GraphL gL = new GraphL(false, nH, m);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            sc.nextLine();

            gL.addEdge(u, v, 1);
        }

        int s = sc.nextInt();
        int v = sc.nextInt();
        int z = sc.nextInt();
        sc.nextLine();

        int[] time = new int[2];
        time[0] = algo.dijkstra(gL, s, v);
        time[1] = algo.dijkstra(gL, z, v);

        if (time[0] <= time[1]) {
            System.out.println("SAFE");
        } else {
            System.out.println("TOO LATE");
        }

        sc.close();
    }
}