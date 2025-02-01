public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    public ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem next) {
        this.rightLink = next;
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.rightLink;
    }

    @Override
    ListItem setPrevious(ListItem previous) {
        this.leftLink = previous;
        return this.leftLink;
    }

    @Override
    public int compareTo(ListItem listItem) {
        if (listItem != null) {
            return ((String) super.getValue()).compareTo((String) listItem.getValue());
        } else {
            return -1;
        }
    }
}
