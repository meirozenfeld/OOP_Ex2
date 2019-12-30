package dataStructure;

import java.util.ArrayList;

import algorithms.*;
import utils.*;
public class main {

	public static void main(String[] args) {
		//		DGraph g=new DGraph ();
		//		NodeData n1=new NodeData(1);
		//		NodeData n2=new NodeData(2);
		//		NodeData n3=new NodeData(3);
		//		NodeData n4=new NodeData(4);
		//		NodeData n5=new NodeData(5);
		//		g.addNode(n1);
		//		g.addNode(n2);
		//		g.addNode(n3);
		//		g.addNode(n4);
		//		g.addNode(n5);
		//		g.connect(1, 2, 1000);
		//		g.connect(2, 3, 1000);
		//		g.connect(3, 4, 1000);
		//		g.connect(4, 1, 1000);
		//		g.connect(1, 5, 1000);
		//		g.connect(5, 3, 1000);

		//		
		//		graph_algorithms gr= new Graph_Algo();
		//		gr.init(g);
		//		System.out.println(gr.isConnected());


		DGraph g1=new DGraph ();
		NodeData m1=new NodeData(8);
		NodeData m2=new NodeData(9);
		NodeData m3=new NodeData(10);
		NodeData m4=new NodeData(11);
		g1.addNode(m1);
		g1.addNode(m2);	
		g1.addNode(m3);
		g1.addNode(m4);
		g1.connect(8, 9, 1);
		g1.connect(9, 10, 0);
		g1.connect(9, 11, 0);
		g1.connect(10, 11, 1);
		g1.connect(8, 11, 2);
		g1.connect(11, 8, 1);
		graph_algorithms gr1= new Graph_Algo();
		gr1.init(g1);
//		graph gr2=gr1.copy();
//		if(gr1.equals(gr2))System.out.println("fail");
//				System.out.println(gr1.shortestPathDist(8, 11));



		//		ArrayList<node_data> sp=(ArrayList<node_data>) gr1.shortestPath(8, 10);
		//		for (int i = 0; i < sp.size(); i++) {
		//			if(i!=sp.size()-1)
		//			System.out.print(sp.get(i).getKey()+"-->");
		//			else {System.out.print(sp.get(i).getKey());}
		//		}

		System.out.println();

		ArrayList<Integer> targets=new ArrayList<Integer>();
		targets.add(8);
//		targets.add(9);
		targets.add(11);
		ArrayList<node_data> ts=(ArrayList<node_data>) gr1.TSP(targets);
		for (int i = 0; i < ts.size(); i++)
		{
			if(i!=ts.size()-1)
				System.out.print(ts.get(i).getKey()+"-->");
			else {System.out.print(ts.get(i).getKey());}
		}
		//		g.connect(2, 3, 1000);


		//System.out.println(g.tostring()+" "+g.getEdge(1, 2).getWeight());


	}

}
