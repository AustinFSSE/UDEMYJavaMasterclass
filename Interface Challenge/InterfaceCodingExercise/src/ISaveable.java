import java.util.ArrayList;
import java.util.List;

public interface ISaveable {

    default List <String> write() {
        return new ArrayList<>();
    }
    default void read(List <String> item){}
}
