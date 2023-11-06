package BinaryAVL;

class NodoAVL<T extends Comparable<T>> {
    private T data;
    private int height;
    private NodoAVL<T> left;
    private NodoAVL<T> right;

    NodoAVL(T data) {
        this.data = data;
        this.height = 0;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public NodoAVL<T> getLeft() {
        return left;
    }

    public void setLeft(NodoAVL<T> left) {
        this.left = left;
    }

    public NodoAVL<T> getRight() {
        return right;
    }

    public void setRight(NodoAVL<T> right) {
        this.right = right;
    }

    public int height() {

        return height;
    }

    public void updateHeight() {
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        height = Math.max(leftHeight, rightHeight) + 1;
    }

    public int getBalanceFactor() {
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        return leftHeight - rightHeight;
    }
}