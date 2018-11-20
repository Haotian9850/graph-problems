import java.util.HashSet;
import java.util.Set;

public class Node {

    int val = -1;
    boolean visited = false;
    Set<Node> neighbors = new HashSet<>();

    public Node(){
        //default constructor

    }

    public Node(int val){
        this.val = val;
    }

}
