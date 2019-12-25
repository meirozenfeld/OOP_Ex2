package dataStructure;

import java.util.Hashtable;

public class Zibi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Hashtable<Integer,Integer> h=new Hashtable<Integer,Integer>();
		DGraph g=new DGraph ();
		NodeData n1=new NodeData(1);
		NodeData n2=new NodeData(2);
		NodeData n3=new NodeData(3);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.connect(1, 2, 1000);
		System.out.println(g.tostring());

	}

}
