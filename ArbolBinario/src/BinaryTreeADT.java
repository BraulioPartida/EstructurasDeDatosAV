
import java.util.ArrayList;
import java.util.Iterator;

public interface BinaryTreeADT<T> {
    public boolean isEmpty();

    public int size();

    public boolean find(T elemento);

    public Iterator<T> preOrder();

    public Iterator<T> postOrder();

    public Iterator<T> inOrder();

}