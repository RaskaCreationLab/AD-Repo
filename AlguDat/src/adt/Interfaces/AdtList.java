<<<<<<< HEAD:AlguDat/src/adt/Interfaces/AdtList.java
package adt.Interfaces;
=======
package Interfaces;
>>>>>>> refs/remotes/origin/master:AlguDat/src/Interfaces/AdtList.java

public interface AdtList {               
	public boolean isEmpty();
	public int laenge();
	public void insert(int pos, int elem);
	public void delete(int pos);
	public int find(int elem);      
	public int retrieve(int pos);
	public AdtList concat(AdtList list);
}
