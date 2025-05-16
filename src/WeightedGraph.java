import java.util.*;
public class WeightedGraph <V>{
    private Map<V, Vertex<V>> vertices = new HashMap<>();

    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V from, V to, double weight) {
        Vertex<V> fromVertex = vertices.get(from);
        Vertex<V> toVertex = vertices.get(to);
        if (fromVertex != null && toVertex != null) {
            fromVertex.addAdjacentVertex(toVertex, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Collection<Vertex<V>> getAllVertices() {
        return vertices.values();
    }
}
