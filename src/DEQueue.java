import java.util.ArrayList;

public class DEQueue {
	ArrayList<Object> queue;
	
	public DEQueue() {
		queue = new ArrayList<Object>();
	}
	
	public void pushBack(Object el) {
		queue.add(el);
	}
	
	public Object back() {
		if (this.size() > 0) {
			return queue.get(queue.size() - 1);
		} else {
			return null;
		}
	}
	
	public int size() {
		return queue.size();
	}
	
	public void pushFront(Object el) {
		queue.add(0, el);
	}
	
	public Object front() {
		if (this.size() > 0) {
			return queue.get(0);
		} else {
			return null;
		}
	}
	
	public Object popFront() {
		Object el = this.front();
		if (el != null) 
			queue.remove(0);
		return el;
	}
	
	public Object popBack() {
		Object el = this.back();
		if (el != null)
			queue.remove(this.size() - 1);
		return el;
	}
	
	public void clear() {
		queue.clear();
	}
	
	public Object[] toArray() {
		Object[] res = new Object[queue.size()];
		
		for (int i = 0; i < queue.size(); i++) {
			res[i] = queue.get(i);
		}
		
		return res;
		
	}
}
