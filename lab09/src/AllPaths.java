import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;


public class AllPaths {
    public int target;
    public int[][] graph;
    public int [][] results;

    protected void backtrack(int currNode, LinkedList<Integer> path) {
        if (currNode == this.target) {
            // make a deep copy of the path

            this.results.equals(path);
            return;
        }
        // explore the neighbor nodes one after another.
        for (int nextNode : graph[currNode]) {
            // mark the choice, before backtracking.
            path.addLast(nextNode);
            this.backtrack(nextNode, path);
            // remove the previous choice, to try the next choice
            path.removeLast();
        }
    }

    public int[][] allPaths (int[][] graph) {

        target = graph.length - 1;
        this.graph = graph;
        this.results = new int[target][target];

        // adopt the LinkedList for fast access to the tail element.
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.addLast(0);
        // kick of the backtracking, starting from the source (node 0)
        this.backtrack(0, path);
        return results;
    }
}