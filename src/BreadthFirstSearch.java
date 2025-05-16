import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private final WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<V> getPath(V start, V end) {
        Map<V, V> cameFrom = new HashMap<>();
        Queue<V> queue = new LinkedList<>();
        Set<V> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            if (current.equals(end)) break;

            for (Vertex<V> neighbor : graph.getVertex(current).getAdjacentVertices().keySet()) {
                V neighborData = neighbor.getData();
                if (!visited.contains(neighborData)) {
                    visited.add(neighborData);
                    queue.add(neighborData);
                    cameFrom.put(neighborData, current);
                }
            }
        }

        return reconstructPath(cameFrom, start, end);
    }

    private List<V> reconstructPath(Map<V, V> cameFrom, V start, V end) {
        List<V> path = new LinkedList<>();
        V current = end;
        while (current != null && !current.equals(start)) {
            path.add(0, current);
            current = cameFrom.get(current);
        }
        if (current == null) return Collections.emptyList();
        path.add(0, start);
        return path;
    }
}

