/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical.pkg3;

/**
 *
 * @author Sylvia Tan
 */
public interface SetInterface<T> {
    
    public boolean add(T newElement);
    public boolean remove(T anElement);
    public void union(SetInterface anotherSet);
    public SetInterface intersection(SetInterface anotherSet);
    public boolean checkSubset(SetInterface anotherSet);
    public boolean isEmpty();
    public int size();
    public int length();
}
