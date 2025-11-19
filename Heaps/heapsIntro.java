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