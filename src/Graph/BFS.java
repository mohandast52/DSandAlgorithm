package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine().trim());

        List<Integer> arrayOfList[] = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            arrayOfList[i] = new LinkedList<>();
        }

        //  add edges
        for (int i = 0; i < vertices - 1; i++) {
            String[] line = br.readLine().trim().split("\\s+");
            int source = (Integer.parseInt(line[0])) - 1;
            int destination = (Integer.parseInt(line[1])) - 1;
            if (!arrayOfList[source].contains(destination) && (source != destination)) {
                arrayOfList[source].add(destination);
                arrayOfList[destination].add(source);
            }
        }

        int x = Integer.parseInt(br.readLine().trim());
        //  print edges
        /*
         for (int i = 0; i < vertices; i++) {
         System.out.print(i + 1);
         for (Integer eachListElemet : arrayOfList[i]) {
         System.out.print(" -> " + (eachListElemet + 1));
         }
         System.out.println("");
         }
         */

        //  adding to queue
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> tempQueue = new LinkedList<>();

        boolean arr[] = new boolean[100001];
        q.add(1 - 1);
        q.add(null);
        arr[1 - 1] = true;
        while (true) {
            if (q.size() == 1 && q.peek() == null) {
                break;
            }
            Integer index = q.remove();
            tempQueue.add(index);
            if (index == null) {
                q.add(null);
            } else {
                //  get all non-visited vertices of index
                for (Integer eachListElemet : arrayOfList[index]) {
                    if (!arr[eachListElemet]) {
                        q.add(eachListElemet);
                        arr[eachListElemet] = true;
                    }
                }
            }
        }

        //Iterator  to get the correct level
        Iterator<Integer> it = tempQueue.iterator();
        int k = 0;
        int count = 0;
        while (true) {
            if (k == (x - 1)) {
                break;
            }
            if (it.next() == null) {
                k++;
            }
        }

        //  count from the current pointer to next null
        while (true) {
            if (it.next() == null) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
