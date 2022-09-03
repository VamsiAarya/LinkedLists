import java.util.*;

class Node{
    int val;
    Node next;
    
    Node(int val){
        this.val = val;
    }
}

class Linklist {
    Node head;
    Node tail;
    
    void insert(int val){
        Node newNode = new Node(val);
        
        if(head==null && tail==null) 
        {
            head= newNode;
            tail= newNode;
        }
        else
        {
            tail.next = newNode;
            tail= newNode;
        }
        
    }
    
    void print(){
        Node temp = head;
        
        while(temp!=null){
            System.out.print(temp.val+"-> ");
            temp= temp.next;
        }
        System.out.println();
    }
    
    Node reverse(Node tHead){
        
        Node prev= null;
        Node current = tHead;
        
        while(current!=null){
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        // System.out.println(prev.val+" ");
        return prev;
        
    }
 
    void altReverse(){
        Node odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // System.out.println(odd.val+" "+evenHead.val);
        evenHead = reverse(evenHead);
        // System.out.println(odd.val+" "+evenHead.val);
        odd.next = evenHead;
        
    }
}

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		
		for(int i=0; i<n; i++) nums[i]= in.nextInt();
		
		Linklist ll = new Linklist();
		
		for(int i=0; i<n; i++) ll.insert(nums[i]);
		
		ll.print();
		ll.altReverse();
		ll.print();
	}
}


// Test case 5 2 4 6 8 10
// op 2 6 10 8 4
