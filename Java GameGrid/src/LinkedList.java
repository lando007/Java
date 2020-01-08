public class LinkedList {

    public Node headNode;


    public void addNode(int iXPosistion, int iYPosistion){

        Node oNewNode = new Node();
        //assigns the x and y position to the object
        oNewNode.xPosition = iXPosistion;

        oNewNode.yPosition = iYPosistion;
        //makes the next node the headnode
        oNewNode.nextNode = headNode;
        //assigns object to the headnode
        headNode = oNewNode;


    }

    public Node removeHeadNode(){

        //loops through assigning the headnode to the temp node and makes the next node the headnode
        while(headNode != null){

            Node temp = null ;

            temp = headNode;

            headNode = temp.nextNode;

            return temp;
        }
        return null;
    }
}
