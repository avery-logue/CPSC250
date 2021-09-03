/**
 * Methods that act on Queues
 * 
 * @author <student>
 * @version 0
 * 
 *
 */
public class QueueMethods {

    /**
     * Creates a separate copy of the queue (same references to elements, so not
     * deep)
     * 
     * Make sure the original queue is unchanged!
     * 
     * @param queue
     *            to copy
     * @param <T>
     *            type for queue
     * @return queue containing same references as original queue
     */
    public static <T> SimpleQueue<T> copyQueue(SimpleQueue<T> queue) {

        if (queue == null) {
        	return null;
        }
        SimpleQueue<T> temp = new SimpleQueue<T>();
        while (!queue.isEmpty()) {
        	temp.enqueue(queue.dequeue());
        }
        
        SimpleQueue<T> nq = new SimpleQueue<T>();
        while (!temp.isEmpty()) {
        	queue.enqueue(temp.peek());
        	nq.enqueue(temp.dequeue());
        }
        return nq;
    }

    /**
     * Given two queues, create a new queue with elements that alternate
     * references from first two queues
     * 
     * Make sure the original queues are unchanged!
     * 
     * @param <T>
     *            type for queue
     * @param queue1
     *            data
     * @param queue2
     *            data
     * @return new queue that interleaves the given data
     */
    public static <T> SimpleQueue<T> interleave(SimpleQueue<T> queue1,
            SimpleQueue<T> queue2) {
    	SimpleQueue<T> q1 = copyQueue(queue1);
    	SimpleQueue<T> q2 = copyQueue(queue2);
    	SimpleQueue<T> nq = new SimpleQueue<T>();
    	
    	while (!q1.isEmpty()) {
    		nq.enqueue(q1.dequeue());
    		if (!q2.isEmpty()) {
    			nq.enqueue(q2.dequeue());
    		}
    	}
    	while (!q2.isEmpty()) {
    		nq.enqueue(q2.dequeue());
    	}
        return nq;

    }

}
