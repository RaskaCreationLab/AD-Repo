package adt.Interfaces;

public interface AdtQueue {

	public void enqueue(int elem);
	
	public void dequeue();
	
	public int front();
	
	public boolean isEmptyQ();
	
}
