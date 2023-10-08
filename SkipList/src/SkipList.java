public class SkipList<T extends Comparable<T>> {
    NodoSkip<T> head, tail;
    int maxLevel, size, currentLevel;

    public SkipList() {
        head = new NodoSkip<T>(null);
        tail = new NodoSkip<T>(null);
        head.right = tail;
        tail.left = head;
        maxLevel = 0;
        size = 0;
        currentLevel = 0;
    }

    public void insert(T element) {
        NodoSkip<T> aux = search(element);
        if (aux.element != null && aux.element.compareTo(element) == 0) {
            return;
        }
        NodoSkip<T> newNode = new NodoSkip<T>(element);
        newNode.left = aux;
        newNode.right = aux.right;
        aux.right.left = newNode;
        aux.right = newNode;
        int level = 0;
        while (Math.random() < 0.5) {
            level++;
        }
        if (level > maxLevel) {
            maxLevel = level;
            NodoSkip<T> newHead = new NodoSkip<T>(null);
            NodoSkip<T> newTail = new NodoSkip<T>(null);
            newHead.right = newTail;
            newHead.down = head;
            head.up = newHead;
            newTail.left = newHead;
            newTail.down = tail;
            tail.up = newTail;
            head = newHead;
            tail = newTail;
            currentLevel++;
            aux = head;
            while (aux != null) {
                aux.level++;
                aux = aux.right;
            }
        }
        NodoSkip<T> up = null;
        aux = newNode;
        while (level >= 0) {
            while (aux.left.up == null) {
                aux = aux.left;
            }
            up = aux.left.up;
            NodoSkip<T> newUp = new NodoSkip<T>(element);
            newUp.left = up;
            newUp.right = up.right;
            up.right.left = newUp;
            up.right = newUp;
            newUp.down = newNode;
            newNode.up = newUp;
            newNode = newUp;
            level--;
        }
        size++;
    }

    public NodoSkip<T> search(T element) {
        NodoSkip<T> aux = head;
        while (true) {

            while (aux.right.element != null && aux.right.element.compareTo(element) <= 0) {
                aux = aux.right;
            }
            if (aux.down != null) {
                aux = aux.down;
            } else {
                break;
            }
        }
        return aux;
    }

    public void delete(T element) {
        NodoSkip<T> aux = search(element);
        if (aux.element.compareTo(element) == 0) {
            while (aux != null) {
                aux.left.right = aux.right;
                aux.right.left = aux.left;
                aux = aux.up;
            }
            size--;
        }

        if (currentLevel > Math.log(size + 1) + 1) {
            head = head.down;
            tail = tail.down;
            aux = head;
            while (aux != null) {
                aux.level--;
                aux = aux.right;
            }
            currentLevel--;
        }

    }

    public void deleteLevel(int level) {
        NodoSkip<T> aux = head;
        while (aux != null) {
            if (aux.level == level) {
                aux.left.right = aux.right;
                aux.right.left = aux.left;
            }
            aux = aux.right;
        }
    }

}
