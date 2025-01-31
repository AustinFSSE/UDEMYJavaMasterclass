

public class MyLinkedList implements NodeList {
    protected ListItem root = null;

    public MyLinkedList(ListItem item) {
        root = item;
    }
    private ListItem root() {
        return root;
    }
    private boolean addItem(ListItem item) {
        if (root == null) {
            root = item;
            return true;
        } else {
            ListItem currentItem = root;
            while (currentItem.next() != null) {
                if (currentItem.compareTo(item) < 0) {
                currentItem.setNext(item);
                return true;
                }
                if (currentItem.compareTo(item) > 0) {
                    currentItem.setPrevious(item);
                    return true;
                }
                if (currentItem.compareTo(item) == 0) {
                    return false;
                }
            }
        }
        return false;
    }
    private boolean removeItem(ListItem item) {
        if (root == null) {
            return false;
        }
        ListItem currentItem = root;
        while (currentItem.next() != null) {
            if (currentItem.compareTo(item) == 0) {
                System.out.println("Removing " + item + " from the list");
                currentItem.setNext(item.next());
                return true;
            }
        }
        System.out.println("Item " + item + " is not in the list");
        return false;
    }

    private void traverse(ListItem item) {
        if (root == null) {
            System.out.println("The List is empty");
        }
        if (root != null && root.compareTo(item) == 0) {
            root = item;
        }
        while (item.next() != null) {
            System.out.println(item);
        }
    }
}
