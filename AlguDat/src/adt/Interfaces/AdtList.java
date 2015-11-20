package adt.Interfaces;

public interface AdtList {               
	public boolean isEmpty();
	public int laenge();
	public void insert(int pos, int elem);
	public void delete(int pos);
	public int find(int elem);      
	public int retrieve(int pos);
	public AdtList concat(AdtList list);
}
