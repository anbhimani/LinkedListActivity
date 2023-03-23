public class CustomLinkedList {
    private Node head;

    public CustomLinkedList(){

    }

    public void addNode(int data){
        Node newNode = new Node(data);

        //if only head in list, then stick the new node right to the head
        if(head == null){
            head = newNode;
        }

        else{
            // look for null pointer
            Node currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            // We now know that currentNode is pointing to null = end of the list
            currentNode.setNext(newNode);
            newNode.setPrevious(currentNode);
        }
    }

    public void addToHead(int data){
        Node newNode = new Node(data);

        newNode.setNext(head);

        head = newNode;

        head.getNext().setPrevious(head);
    }
    public void addToPos(int pos, int data){
        //create new node
        Node newNode = new Node(data);

        if(pos == 0){
            addToHead(data);
        }
        else{
            //loop through list to find pos
            Node currentNode = head;
            for(int i = 0; i < pos; i++){
                // check to see if pos goes beyond end of the list
                if(currentNode.getNext() != null){
                    currentNode = currentNode.getNext();
                }
                else{
                    break;
                }
            }
            newNode.setNext(currentNode);
            newNode.setPrevious(currentNode.getPrevious());
            currentNode.getPrevious().setNext(newNode);
            currentNode.setPrevious(newNode);


        }
    }

    public void changeData(int data, int newData){

        Node currentNode = head;
        while(currentNode.getData() != data && currentNode.getNext()!=null){
            currentNode = currentNode.getNext();
        }
        currentNode.setData(newData);

    }

    public String reverseOutput(){
        String data = "";
        Node currentNode = head;
        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }

        while(currentNode != head){
            data = data + currentNode.getData() + ", ";
            currentNode = currentNode.getPrevious();
        }
        data = data + currentNode.getData();
        System.out.println(data);
        return data;
    }

    public void delete(int data){
        Node currentNode = head;

        if(currentNode.getData() == data){
            head = currentNode.getNext();
            currentNode.getNext().setPrevious(null);
        }

        else{
            while(currentNode.getData() != data && currentNode.getNext()!=null){
                currentNode = currentNode.getNext();
            }

            if(currentNode.getNext() == null){
                currentNode.getPrevious().setNext(null);
            }
            else{
                currentNode.getPrevious().setNext(currentNode.getNext());
                currentNode.getNext().setPrevious(currentNode.getPrevious());
            }


        }
    }

    public String toString(){
        String data = "";

        Node currentNode = head;
        while(currentNode.getNext() != null){
            data = data + currentNode.getData() + ", ";
            currentNode = currentNode.getNext();
        }
        data = data + currentNode.getData();
        return data;
    }

    private Node getHead() {
        return head;
    }

    private void setHead(Node head) {
        this.head = head;
    }
}
