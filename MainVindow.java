import java.util.*;

public class MainVindow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MyAlgorithm algo = new MyAlgorithm();

        /* Duplicate Mode */
        BST t1 = new BST();
        String str = sc.nextLine();
        String[] strPro = str.split(",");
        int[] process = new int[strPro.length];
        for (int i = 0; i < strPro.length; i++) {
            process[i] = Integer.parseInt(strPro[i].trim());
        }

        for (int num : process) {
            t1.insertNode(num);
        }

        List<Integer> dupli = algo.preorder(t1);

        BST t2 = new BST();
        for (int proc2 : dupli){
            t2.insertNode(proc2);
        }

        System.out.println("t1 : " + algo.preorder(t1));
        System.out.println("t2 : " + algo.preorder(t2));

        /* Balance Mode */
    }
}
