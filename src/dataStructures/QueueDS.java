package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bhuvan on 27/12/14.
 */
public class QueueDS {
    public static Queue getQueue(){
        Queue<String> queue = new LinkedList<String>();
        queue.add("one");
        queue.add("two");
        queue.add("three");
        return queue;
    }
    public static void main(String [] args){
        Queue q = getQueue();
        while (!q.isEmpty()){
            System.out.println(q.remove());
        }
        q = getQueue();
        while (!q.isEmpty()){
            System.out.println(q.peek());
            System.out.println(q.remove());
        }
    }
}
