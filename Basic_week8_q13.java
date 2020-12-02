
class Graph {

    boolean[][] array;
    boolean[] visited;

    public Graph(int size) {
        array = new boolean[size][size];
    }

    public void setEdge(int from, int to, boolean e) {
        array[from - 1][to - 1] = e;
        array[to - 1][from - 1] = e;
    }

    public void search(int start) {
        visited = new boolean[array.length];
        System.out.print("[ ");
        dfs(start - 1);
        System.out.println("]");
    }

    private void dfs(int node) {
        visited[node] = true;
        System.out.print(node + 1 + " ");
        for (int i = 0; i < array[node].length; i++) {
            if (array[node][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s += "Node [" + (i + 1) + "] go [ ";
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]) {
                    s += j + 1 + " ";
                }
            }
            s += "]\n";
        }
        return s;
    }

}

public class Basic_week8_q13 {

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.setEdge(1, 2, true);
        g.setEdge(1, 6, true);
        g.setEdge(1, 9, true);
        g.setEdge(2, 3, true);
        g.setEdge(2, 5, true);
        g.setEdge(3, 4, true);
        g.setEdge(3, 5, true);
        g.setEdge(4, 7, true);
        g.setEdge(4, 8, true);
        g.setEdge(5, 7, true);
        g.setEdge(6, 7, true);
        System.out.println(g);
        g.search(1);
    }
}
