/*
Heap is a BT with special arrangement where each node is greater than its children.
The cool thing about heap is its efficient for very large data with O(logn) thanks to sorting
during insertion & deletion of elements

For any given index i, its left and right children can be found at 2i+1, 2i+2 with parent at Math.floor(2(i-1)/2)

insertion logic (bubble-up, heapify) 
1. add new element at the last of the heap(array).
2. call heapify-max 
    - declare three variable index = declare a variable called index and initialize with the last index in the heap.
    - while index > 0, 
        declare three variable element, parentIndex
        if parent is greater than or equal to the elemet then breakout
        otherwise swap the parent and child(element)   


deletion logic 
1. create a vaiable max = top element(max-element) from the heap and replace it with last element
2. call heapify down or bubble down
    - declare three variables left = 2i+1, right = 2i+2, largest = index
    - compare largest with left , then right
    - largest not equal to index recursive call to bubble down function       
*/

class BinaryHeap{

    constructor(values){
        this.heap = values;
    }

    insert(value){
        this.heap.push(value);
        this.bubbleUp();
    }

    bubbleUp(){
        let index = this.heap.length - 1;

        while(index > 0){
            let element = this.heap[index],
                 parentIndex = Math.floor((index-1)/2),
                 parent = this.heap[parentIndex];

                 if(parent >= element) break;
                 this.heap[index] = parent; // swap parent
                 this.heap[parentIndex] = element; // and child
                 index = parentIndex;
        }
    }

    remove(){
        let max = this.heap[0];
        this.heap[0] = this.heap.pop() // update first element with last
        this.bubbleDown(0);
        return max;
    }

    bubbleDown(index){
        let left = 2*index + 1,
            right = 2* index + 2,
            largest = index;

        const length = this.heap.length;
        
        if(left <= length && this.heap[left] > this.heap[largest]){
            largest = left;
        }
        
        if(right <= length && this.heap[right] > this.heap[largest]){
            largest = right;
        }
        
        //repeat until index = 0 becomes the largest
        if(largest !== index){
            [this.heap[largest], this.heap[index]] =
            [this.heap[index], this.heap[largest]];
            this.bubbleDown(largest);
        }
    }
}