class Node {
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{

    constructor(){
        this.head = null;
    }

    insertAtHead(data){
        
        const newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    display(){
        const current = this.head;
        console.log('head');
        while(current !=null){
                console.log(current.data+"->");
                current = current.next;
        }
        console.log('null');
    }

    removeAt(position){
        const current = this.head;
        
        let index =0;
        while(current !=null){
                index++;
                if(index === position){
                    const temp = current.next;
                    current.next = temp.next;
                    return;
                }
                current = current.next;
        }
        

    }
}