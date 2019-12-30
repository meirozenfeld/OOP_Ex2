package GUI;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.DGraph;
import dataStructure.NodeData;
import utils.Point3D;

public class mainGui {

	public static void main(String[] args) {
		DGraph g=new DGraph ();
		Point3D p1=new Point3D(300,200,0);
		Point3D p2=new Point3D(200,100,0);
		Point3D p3=new Point3D(180,300,0);
		Point3D p4=new Point3D(350,200,0);
		Point3D p5=new Point3D(400,350,0);
		NodeData n1=new NodeData(1,p1);
		NodeData n2=new NodeData(2,p2);
		NodeData n3=new NodeData(3,p3);
		NodeData n4=new NodeData(4,p4);
		NodeData n5=new NodeData(5,p5);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.connect(1, 2, 1);
		g.connect(2, 3, 2);
		g.connect(3, 4, 3);
		g.connect(4, 5, 4);
		//		g.connect(1, 5, 1000);
		//		g.connect(5, 3, 1000);
		graph_algorithms gr= new Graph_Algo();
		gr.init(g);
		Window window=new Window (g);
		window.setVisible(true);
	}

}
