class ListNode{
    ListNode next;
    int data;

    ListNode(){}
    ListNode(int data1){
        this.data = data1;
    }
}

class MyLinkedList {
    ListNode head = null;

    public MyLinkedList() {

    }
    
    public int get(int index) {
        if(head == null) return -1;

        ListNode temp = head;

        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        if(index >= len) return -1;

        int currInd = 0;
        temp = head;
        
        while(currInd <= index && temp != null){
            if(currInd == index) return temp.data;
            temp = temp.next;
            currInd++;
        }

        return -1;
    }
    
    public void addAtHead(int val) {
        ListNode neww = new ListNode(val);
        neww.next = head;
        head = neww;
    }
    
    public void addAtTail(int val) {
        if(head == null){
            head = new ListNode(val);
            return;    
        }

        ListNode temp = head;

        while(temp.next != null) temp = temp.next;
        temp.next = new ListNode(val);
    }
    
    public void addAtIndex(int index, int val) {
        ListNode neww = new ListNode(val);

        if(index == 0) {
            neww.next = head;
            head = neww;

            return;
        }

        int i = 0;
        ListNode temp = head;

        while(i <= index && temp != null){
            if(i == index-1){
                ListNode front = temp.next;

                temp.next = null;
                temp.next = neww;
                neww.next = front;

                break;
            }

            temp = temp.next;
            i++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(head == null) return;

        ListNode temp1 = head;

        int len = 0;
        while(temp1 != null){
            len++;
            temp1 = temp1.next;
        }
        
        if(index >= len) return;

        if(index == 0){
            ListNode temp = head.next;

            head.next = null;
            head = temp;

            return;
        }

        int i = 0;

        ListNode temp = head;

        while(i <= index && temp != null){
            if(i == index-1){
                ListNode front = temp.next.next;
                ListNode del = temp.next;

                temp.next = null;
                del.next = null;

                temp.next = front;
            }

            temp = temp.next;
            i++;
        }
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */