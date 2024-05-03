package FinalProject;

class Node {
    int value;
    Node next;
    Node(int x) { value = x; }
}

class Solution2 {
    public Node deleteNthFromEnd(Node head, int n) {
        Node helper = new Node(0);
        helper.next = head;
        Node lead = helper;
        Node follow = helper;
        
        for (int i = 1; i <= n + 1; i++) {
            lead = lead.next;
        }
        
        while (lead != null) {
            lead = lead.next;
            follow = follow.next;
        }
        
        follow.next = follow.next.next;
        return helper.next;
    }
    
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        
        head1 = solution.deleteNthFromEnd(head1, 2);
        displayList(head1); 
    }
    
    public static void displayList(Node node) {
        while (node != null) {
            System.out.print(node.value);
            if (node.next != null) System.out.print("->");
            node = node.next;
        }
        System.out.println();
    }
}

