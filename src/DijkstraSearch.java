import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<V> getPath(V start, V end) {
        Map<V, V> cameFrom = new HashMap<>();
        Map<V, Double> distances = new HashMap<>();
        PriorityQueue<Map.Entry<V, Double>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (Vertex<V> vertex : graph.getAllVertices()) {
            distances.put(vertex.getData(), Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);
        queue.add(new AbstractMap.SimpleEntry<>(start, 0.0));

        while (!queue.isEmpty()) {
            V current = queue.poll().getKey();
            if (current.equals(end)) break;

            for (Map.Entry<Vertex<V>, Double> entry : graph.getVertex(current).getAdjacentVertices().entrySet()) {
                V neighborData = entry.getKey().getData();
                double newDist = distances.get(current) + entry.getValue();

                if (newDist < distances.get(neighborData)) {
                    distances.put(neighborData, newDist);
                    cameFrom.put(neighborData, current);
                    queue.add(new AbstractMap.SimpleEntry<>(neighborData, newDist));
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

