package implementations;

import interfaces.AdtQueue;
import interfaces.AdtStack;

public class AdtQueueImpl implements AdtQueue {
	AdtStack inStack, outStack;
	final int ERRORCODE = -99999999;
	
	AdtQueueImpl() {
		inStack = AdtStackImpl.createS();
		outStack = AdtStackImpl.createS();
	}
	
	public static AdtQueue createQ() {
		return new AdtQueueImpl();
	}

	//enqueue :: Queue x elem -> Queue :: (elem)
	@Override
	public void enqueue(int elem) {
		inStack.push(elem);
	}

	//dequeue :: Queue -> Queue
	@Override
	public void dequeue() {
		restack();
		if(!outStack.isEmptyS()) 
			outStack.pop();
		
	}
	
	public void restack() {
		if(outStack.isEmptyS()) {
			while(!inStack.isEmptyS()) {
				outStack.push(inStack.top());
				inStack.pop();
			}
		}
	}

	//front :: Queue -> elem 
	@Override
	public int front() {
		restack();
		return outStack.top();
	}

	//front :: Queue -> bool
	@Override
	public boolean isEmptyQ() {
		restack();
		return (outStack.top() == ERRORCODE);
	}

}
