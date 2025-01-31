public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    public ListItem next() {
        return rightLink;
    }

    @Override
    public void setNext(ListItem next) {
        this.rightLink = next;
    }

    @Override
    public ListItem previous() {
        return leftLink;
    }

    @Override
    public void setPrevious(ListItem previous) {
        this.leftLink = previous;
    }

    @Override
    public int compareTo(ListItem listItem) {
        return ((Integer)this.getValue() - (Integer)listItem.getValue());
    }
}
