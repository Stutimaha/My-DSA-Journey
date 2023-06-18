class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        
        HashMap<Node, Node> oldToCopy = new HashMap<>();
        
        while(curr!=null){
            oldToCopy.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr =head;
        while(curr!=null){
            oldToCopy.get(curr).next = oldToCopy.get(curr.next);
            oldToCopy.get(curr).random = oldToCopy.get(curr.random);
            curr = curr.next; 
        }
        return oldToCopy.get(head);
    }
}

