import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] files = {
                "data/small1.json", "data/small2.json", "data/small3.json",
                "data/medium1.json", "data/medium2.json", "data/medium3.json",
                "data/large1.json", "data/large2.json", "data/large3.json"
        };

        for (String filename : files) {
            System.out.println("=== Processing " + filename + " ===");

            // Загружаем граф
            GraphLoader loader = new GraphLoader(filename);
            List<List<GraphLoader.Edge>> graph = loader.getGraph();
            int source = loader.getSource();

            // SCC
            SCCFinder sccFinder = new SCCFinder(graph);
            List<List<Integer>> sccs = sccFinder.getSCCs();
            System.out.println("Strongly connected components:");
            for (List<Integer> comp : sccs)
                System.out.println(comp);

            // TopoSort
            List<List<Integer>> dag = new ArrayList<>();
            for (int i = 0; i < graph.size(); i++)
                dag.add(new ArrayList<>());
            for (int u = 0; u < graph.size(); u++)
                for (GraphLoader.Edge e : graph.get(u))
                    dag.get(u).add(e.to);

            TopoSort topo = new TopoSort(dag);
            System.out.println("Topological order:");
            System.out.println(topo.getTopoOrder());

            // DAG Shortest Paths
            DAGShortestPaths dagSP = new DAGShortestPaths(graph);

            // Кратчайшие пути
            dagSP.shortestPaths(source);
            System.out.println("Shortest paths from " + source + ":");
            double[] dist = dagSP.getDist();
            for (int i = 0; i < dist.length; i++)
                System.out.println(i + " -> " + dist[i]);

            System.out.println("Shortest paths reconstructed:");
            for (int i = 0; i < dist.length; i++)
                System.out.println(dagSP.getPath(i));

            // Длиннейшие пути (critical paths)
            dagSP.longestPaths(source);  // убедись, что метод реализован
            System.out.println("Longest paths from " + source + " (critical paths):");
            double[] longest = dagSP.getLongestDist();
            for (int i = 0; i < longest.length; i++)
                System.out.println(i + " -> " + longest[i]);

            System.out.println("Longest paths reconstructed:");
            for (int i = 0; i < longest.length; i++)
                System.out.println(dagSP.getLongestPath(i));

            System.out.println(); // пустая строка между файлами
        }
    }
}
