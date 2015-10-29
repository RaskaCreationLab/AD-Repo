package implementations;

import interfaces.AdtQueue;
import interfaces.AdtStack;

public class AdtQueueImpl implements AdtQueue {
	
	AdtStack inStack, outStack;
	final int ERRORCODE = -99999999;
	
	AdtQueueImpl() {
		inStack = Factory.createS();
		outStack = Factory.createS();
	}

	//enqueue :: Queue x elem -> Queue :: (elem)
	@Override
	public void enqueue(int elem) {
		inStack.push(elem);
	}

	//dequeue :: Queue -> Queue
	@Override
	public void dequeue() {
		if(outStack.isEmptyS()) {
			while(!inStack.isEmptyS()) {
				outStack.push(inStack.top());
				inStack.pop();
			}
		}
		if(!outStack.isEmptyS()) 
			outStack.pop();
		
	}

	//front :: Queue -> elem 
	@Override
	public int front() {
		return outStack.top();
	}

	//front :: Queue -> bool
	@Override
	public boolean isEmptyQ() {
		return (outStack.top() == ERRORCODE);
	}

}
