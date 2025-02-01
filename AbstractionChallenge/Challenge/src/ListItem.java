public abstract class ListItem {
    protected ListItem rightLink, leftLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    // These methods cannot be private in an abstract class
    abstract ListItem next();
    abstract ListItem setNext(ListItem next);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem previous);
    abstract int compareTo(ListItem listItem); // Fixed return type

    public Object getValue() {
        return value;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }
}
