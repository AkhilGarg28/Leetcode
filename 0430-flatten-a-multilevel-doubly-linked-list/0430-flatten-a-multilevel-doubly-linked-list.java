/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            if (curr.child != null) {
                Node childLast = dfs(curr.child);

                curr.next = curr.child;
                curr.child.prev = curr;

                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                curr.child = null;
                last = childLast;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }
}