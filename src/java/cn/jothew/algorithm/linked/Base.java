package cn.jothew.algorithm.linked;

/**
 * 链表基础算法
 *
 * 链表遍历
 * 反向遍历
 * 反转
 * 取中
 * 顺序打印反向打印
 */
public class Base {

    /**
     * 遍历链表
     * @param node
     */
    public static void erg(Node node) {

        while (node != null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    /**
     * 链表反转
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param node
     * @return
     */
    public static Node reverse(Node node){
        Node pre = null;
        Node cur = node;
        while (cur != null){
            Node nextTmp = cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextTmp;
        }

        return pre;
    }
    /**
     * 获取链表中值
     * @param node
     * @return
     */
    public static Node midNode(Node node) {
        if (node==null) return node;

        Node slow=node;
        Node fast=node;
        while (slow.next !=null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    /**
     * 顺序打印
     */
    public static void print(Node node) {
        if(node==null) System.out.println("");

        while (node != null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    /**
     * 逆序打印
     * @param node
     */
    public static void reversPrint(Node node){
        if (node==null) System.out.println("");

        if (node != null){
            reversPrint(node.next);
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {
        Node node =new Node(5,null);

        node=new Node(4,node);
        node=new Node(3,node);
        node=new Node(2,node);
        node=new Node(1,node);
        node=new Node(0,node);
        Node mid = reverse(node);

        print(mid);
    }
}
