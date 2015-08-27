public class List {

    Element head;

    public List() {
        head = null;
    }

    private static class Element {
        Object obj;
        Element next;
        Element prev;
        public Element(Object obj) {
            this.obj = obj;
        }
    }

    public void add(Object obj) {
        Element el = head;
        if (head == null) {
            head = new Element(obj);
        }

        while (el != null) {

        }
        if (el == null) {
            head = 
        }
    }
}
