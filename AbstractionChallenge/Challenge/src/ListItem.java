public abstract class ListItem {
    protected ListItem rightLink, leftLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    // These methods cannot be private in an abstract class
    public abstract ListItem next();
    public abstract void setNext(ListItem next);
    public abstract ListItem previous();
    public abstract void setPrevious(ListItem previous);
    public abstract int compareTo(ListItem listItem); // Fixed return type

    public Object getValue() {
        return value;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }
}
