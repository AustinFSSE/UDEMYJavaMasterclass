import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryList<T extends QueryItem> extends ArrayList<T> {


//    private List <T> items;

    public QueryList(List <T> items) {
        super(items);
//        this.items = items;
    }
    public QueryList() {}

    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value) {
        List<T> matches = new ArrayList <>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public QueryList<T> getMatches(String field, String value) {
        QueryList<T> matches = new QueryList <>();
        for (var item : this) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
