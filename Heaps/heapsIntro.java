import java.util.*;
public class heapsIntro {
    
    public static class Heap{
        private ArrayList<Integer> arr=new ArrayList<>();
        
        public void add(int data){
            arr.add(data);
            int x=arr.size()-1; //index of child
            int par=(x-1)/2;    //index of parent
            
            while(x>0 && arr.get(x)<arr.get(par)){
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);
                
                x=par;
                par=(x-1)/2;
            }
        }
        
        public int peek(){
            if (arr.isEmpty()) throw new IllegalStateException("Heap is empty");
            return arr.get(0);
        }
        
        private void heapify(int i){ 
            int leftChild=2*i+1;
            int rightChild=2*i+2;
            int minIdx=i;
            
            if(leftChild<arr.size() && arr.get(leftChild)<arr.get(minIdx)){
                minIdx=leftChild;
            }
            
            if(rightChild<arr.size() && arr.get(rightChild)<arr.get(minIdx)){
                minIdx=rightChild;
            }
            
            if(i!=minIdx){
                int temp=arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                
                heapify(minIdx);
            }
        }
        
        public int remove(){
            
            if(arr.isEmpty()){
                throw new IllegalStateException("Heap is Empty");
            }
            
            int data=arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            
            arr.remove(arr.size()-1);
            
            if (!arr.isEmpty()) heapify(0);
            return data;
        }
        
        public void print(){
            System.out.println(arr);
        }
        
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void main(String args[]){
        Heap h=new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}

/*  A2Z sheet implementation Code 
import java.util.ArrayList;

class Solution {

    private ArrayList<Integer> arr;

    public void initializeHeap() {
        arr = new ArrayList<>();
    }

    public void insert(int key) {
        if (arr == null) arr = new ArrayList<>();
        arr.add(key);
        int i = arr.size() - 1;
        while (i > 0) {
            int p = (i - 1) / 2;
            if (arr.get(i) < arr.get(p)) {
                int t = arr.get(i);
                arr.set(i, arr.get(p));
                arr.set(p, t);
                i = p;
            } else break;
        }
    }

    public void changeKey(int index, int newVal) {
        if (arr == null) throw new IllegalStateException("Heap not initialized");
        if (index < 0 || index >= arr.size()) throw new IndexOutOfBoundsException("Index out of range");
        int oldVal = arr.get(index);
        arr.set(index, newVal);
        if (newVal < oldVal) {
            int i = index;
            while (i > 0) {
                int p = (i - 1) / 2;
                if (arr.get(i) < arr.get(p)) {
                    int t = arr.get(i);
                    arr.set(i, arr.get(p));
                    arr.set(p, t);
                    i = p;
                } else break;
            }
        } else if (newVal > oldVal) {
            heapify(index);
        }
    }

    public void extractMin() {
        if (arr == null || arr.isEmpty()) throw new IllegalStateException("Heap is empty");
        int last = arr.remove(arr.size() - 1);
        if (!arr.isEmpty()) {
            arr.set(0, last);
            heapify(0);
        }
    }

    public boolean isEmpty() {
        return arr == null || arr.isEmpty();
    }

    public int getMin() {
        if (arr == null || arr.isEmpty()) throw new IllegalStateException("Heap is empty");
        return arr.get(0);
    }

    public int heapSize() {
        return (arr == null) ? 0 : arr.size();
    }

    private void heapify(int i) {
        int n = arr.size();
        while (true) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int m = i;
            if (l < n && arr.get(l) < arr.get(m)) m = l;
            if (r < n && arr.get(r) < arr.get(m)) m = r;
            if (m != i) {
                int t = arr.get(i);
                arr.set(i, arr.get(m));
                arr.set(m, t);
                i = m;
            } else break;
        }
    }
}
*/