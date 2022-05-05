package co.edu.umanizales.battleshipjava.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ListDE {
    private NodeDE head;
    private int count;

    public List<ShipDistribution> enlist() {
        List<ShipDistribution> list = new ArrayList<>();
        if (this.head != null) {
            NodeDE temp = this.head;
            while (temp != null) {
                list.add(temp.getData());
                temp = temp.getNext();
            }
        }
        return list;
    }

    public void add(ShipDistribution shipDistribution) {
        if (this.head == null) {
            NodeDE newNode = new NodeDE(shipDistribution);
            this.head = newNode;
        }
        else {
            NodeDE temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            NodeDE newNode = new NodeDE(shipDistribution);
            temp.setNext(newNode);
            newNode.setPrevious(temp);
        }
        this.count++;
    }

    public void addFirst(ShipDistribution shipDistribution) {
        if (this.head == null) {
            NodeDE newNode = new NodeDE(shipDistribution);
            this.head = newNode;
        }
        else {
            NodeDE newNode = new NodeDE(shipDistribution);
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
            this.head = newNode;
        }
        this.count++;
    }

    public ListDE cloneList() throws Exception {
        if (this.head != null) {
            ListDE newList = new ListDE();
            NodeDE temp = this.head;
            while (temp != null) {
                newList.add(temp.getData());
                temp = temp.getNext();
            }
            return newList;
        }
        else {
            throw new Exception("La lista está vacía.");
        }
    }
}
