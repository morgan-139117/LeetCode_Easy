package easy;
import java.util.HashMap;
import java.util.Map;

class RandomListNode {
	      int label;
	      RandomListNode next, random;
	    public  RandomListNode(int x) { this.label = x; }
	  };
	 
public class CloneString {
		
	public RandomListNode copyRandomList(RandomListNode head) {
		
		Map<RandomListNode, RandomListNode> rMap = new HashMap<RandomListNode, RandomListNode>();
		
		if(head == null) return null;
		RandomListNode it = head;
		
		do{
			rMap.put(it, new RandomListNode(it.label));
			it = it.next;
		}while(it != null);
		
		it = head;
		
		do{
			//rMap.get(it).random = it.random; bug 1 
			//rMap.get(it).next = it.next; bug 2
			
			rMap.get(it).random = rMap.get(it.random);
			rMap.get(it).next = rMap.get(it.next);
			
			it = it.next;
		}while(it != null);
		
		
		return rMap.get(head);
        		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RandomListNode rNode1 = new RandomListNode(1);
		RandomListNode rNode2 = new RandomListNode(2);
		RandomListNode rNode3 = new RandomListNode(3);
		rNode1.next = rNode2;
		rNode2.next = rNode3;
		rNode3.next = null;
		rNode1.random = rNode3;
		rNode2.random = null;
		rNode3.random = rNode2;
		
		
		CloneString cString = new CloneString();
		RandomListNode rNode1_1 = cString.copyRandomList(rNode1);
		RandomListNode it = rNode1_1;
		if(it == null) return;
		
		
		
		
		do{
			System.out.println(it.label);
			if(it.random != null) System.out.println("random" + it.random.label);
			else System.out.println("random" + "null");
			it = it.next;
		}while(it != null);
	}

}
