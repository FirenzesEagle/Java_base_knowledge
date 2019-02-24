package me.liumingbo.bases;

/**
 * 基于单链表LRU算法（java）
 *
 * @author liumingbo
 * @create 2019-02-15
 */
public class LRUBaseLinkedList<T> {

    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    private Integer length;

    private Integer capacity;

    public LRUBaseLinkedList(){
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data){
        SNode preNode = findPreNode(data);
        if (preNode != null){
            deleteElemOptim(preNode);
            insertElementAtBegin(data);
        } else {
            if (length >= this.capacity){
                deleteElemAtEnd();
            }
            insertElementAtBegin(data);
        }
    }

    private void insertElementAtBegin(T data){
        SNode next = headNode.getNext();
        SNode beginNode = new SNode(data, next);
        headNode.setNext(beginNode);
        length++;
    }

    private void deleteElemOptim(SNode preNode){
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    private SNode findPreNode(T data){
        SNode node = headNode;
        while (node.getNext() != null){
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
        }
        return null;
    }

    private void deleteElemAtEnd(){
        SNode node = headNode;
        if (node.getNext() == null) {
            return;
        }
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }

        SNode temp = node.next;
        node.setNext(null);
        temp = null;
        length--;
    }

    public class SNode<T> {
        private T element;

        private SNode next;

        public SNode(T element){
            this.element = element;
        }

        public SNode(T element, SNode next){
            this.element = element;
            this.next = next;
        }

        public SNode(){
            this.next = null;
        }

        public T getElement(){
            return element;
        }

        public void setElement(T element){
            this.element = element;
        }

        public SNode getNext(){
            return next;
        }

        public void setNext(SNode next){
            this.next = next;
        }
    }

}
