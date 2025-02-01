

public class MyLinkedList implements NodeList {
    protected ListItem root = null;

    public MyLinkedList(ListItem item) {
        this.root = item;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (root == null) {
            this.root = item;
            return true;
        } else {
            ListItem currentItem = this.root;
            while (true) {
                int comparison = currentItem.compareTo(item);
                if (comparison < 0) {
                    if (currentItem.next() != null) {
                        currentItem = currentItem.next();
                    } else {
                        currentItem.setNext(item).setPrevious(currentItem);
                        return true;
                    }
                } else if (comparison > 0) {
                    if (currentItem.previous() != null) {
                        currentItem.previous().setNext(item).setPrevious(currentItem);
                        item.setNext(currentItem).setPrevious(item);
                    } else {
                        item.setNext(this.root).setPrevious(item);
                        this.root = item;
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null) {
            return false;
        } else {
            ListItem currentItem = this.root;
            while (currentItem != null) {
                int comparison = currentItem.compareTo(item);
                if (comparison == 0) {
                    System.out.println("Removing " + item + " from the list");
                    if (currentItem == this.root) {
                        this.root = currentItem.next();
                    } else {
                        currentItem.previous().setNext(currentItem.next());
                        if (currentItem.next() != null) {
                            currentItem.next().setPrevious(currentItem.previous());
                        }
                    }
                    return true;
                } else if (comparison < 0) {
                    currentItem = currentItem.next();
                } else {
                    return false;
                }
            }
            System.out.println("Item " + item + " is not in the list");
            return false;
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The List is empty");
        }
        while (root != null) {
            System.out.println(root.getValue());
            root = root.next();
        }
    }
}
