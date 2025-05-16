import java.util.*;

public interface Search<V> {
    List<V> getPath(V start, V end);
}