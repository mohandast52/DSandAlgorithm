package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DFS {

    static boolean[] visited = null;
    static List<Integer> arrayOfList[] = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().trim().split("\\s+");
        int vertices = (Integer.parseInt(line[0]));
        int edges = (Integer.parseInt(line[1]));


        arrayOfList = new LinkedList[vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            arrayOfList[i] = new LinkedList<>();
        }

        //  add edges
        for (int i = 1; i <= edges; i++) {
            line = br.readLine().trim().split("\\s+");
            int source = (Integer.parseInt(line[0]));
            int destination = (Integer.parseInt(line[1]));
            arrayOfList[source].add(destination);
            arrayOfList[destination].add(source);
        }


        //  print edges
        /*
        for (int i = 1; i <= vertices; i++) {
            for (Integer eachListElement : arrayOfList[i]) {
                System.out.print(" -> " + (eachListElement));
            }
            System.out.println("");
        }
        */
        visited = new boolean[vertices + 1];

        int head = Integer.parseInt(br.readLine().trim());
        DFSrecur(head);

        int count = 0;
        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) count++;
        }
        System.out.println(count);
    }

    private static void DFSrecur(int source) {
        if (!visited[source]) {
            visited[source] = true;
            for (Integer neighbor : arrayOfList[source]) {
                DFSrecur(neighbor);
            }
        }
    }
}
