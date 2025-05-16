public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addVertex("Astana");
        graph.addVertex("Almaty");
        graph.addVertex("Shymkent");
        graph.addVertex("Aktobe");
        graph.addVertex("Karaganda");
        graph.addVertex("Pavlodar");
        graph.addVertex("Kostanay");
        graph.addVertex("Taraz");

        graph.addEdge("Astana", "Almaty", 1);
        graph.addEdge("Almaty", "Shymkent", 3);
        graph.addEdge("Astana", "Shymkent", 10);
        graph.addEdge("Shymkent", "Aktobe", 2);
        graph.addEdge("Astana", "Karaganda", 2);
        graph.addEdge("Karaganda", "Pavlodar", 4);
        graph.addEdge("Pavlodar", "Kostanay", 5);
        graph.addEdge("Kostanay", "Aktobe", 3);
        graph.addEdge("Almaty", "Taraz", 2);
        graph.addEdge("Taraz", "Shymkent", 1);

        Search<String> bfs = new BreadthFirstSearch<>(graph);
        Search<String> dijkstra = new DijkstraSearch<>(graph);

        System.out.println("BFS Path Astana -> Aktobe: " + bfs.getPath("Astana", "Aktobe"));
        System.out.println("Dijkstra Path Astana -> Aktobe: " + dijkstra.getPath("Astana", "Aktobe"));
    }
}