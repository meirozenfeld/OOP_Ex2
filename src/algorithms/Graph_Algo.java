package algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


import dataStructure.graph;
import dataStructure.node_data;
import dataStructure.edge_data;
import dataStructure.NodeData;
import dataStructure.DGraph;
import dataStructure.EdgeData;



/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{

	graph gr;
	@Override
	public void init(graph g) {
		this.gr=g;


	}

	public void clearG()
	{
		for(node_data v: gr.getV())
		{
			v.setInfo(Double.toString(v.getWeight()));//save the original weight
			v.setWeight(Double.POSITIVE_INFINITY); // set all nodes to infinity
			v.setTag(0); // set tag to 0 (not visited)
		}
	}

	@Override
	public void init(String file_name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isConnected() {
		int counter=0;
		int n=gr.nodeSize();
		clearG(); // reset graph 
		Iterator<node_data> N= this.gr.getV().iterator(); // iterator to this.gr nodes
		if(n==1)return true; // end case
		node_data v=N.next();
		Stack<node_data> F = new Stack<node_data>();
		gr.getNode(v.getKey()).setTag(1);// v visited
		F.push(gr.getNode(v.getKey()));
		while(!F.isEmpty())
		{
			node_data x=F.pop();
			counter++;
			gr.getNode(x.getKey()).setTag(1);// x visited
			Collection<edge_data> ne=gr.getE(x.getKey());
			for(edge_data e: ne)
			{
				if(gr.getNode(e.getDest()).getTag()==0)
				{
					F.add(gr.getNode(e.getDest()));

				}
			}
		}
		return (counter==n);
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		if(src==dest)return 0;
		clearG();// reset graph 
		gr.getNode(src).setWeight(0);// reset start node to zero (minimum)
		while(!visited(this.gr))
		{
			node_data min=gr.getNode(minW(this.gr,src)); // save the min weight node
			min.setTag(1);//visited
			Collection<edge_data> ne=gr.getE(min.getKey()); // neighbors of min node
			for(edge_data e:ne)
			{
				double w=min.getWeight()+e.getWeight();// sum weight of vertex and edge neighbor
				if(w<gr.getNode(e.getDest()).getWeight())
				{
					gr.getNode(e.getDest()).setWeight(w);
					gr.getNode(e.getDest()).setInfo(String.valueOf(gr.getNode(e.getSrc()).getKey()));// save parent on info for
				}
			}
		}
		return gr.getNode(dest).getWeight();
	}

	/*
	 * check if all graph visited or not
	 */
	public boolean visited(graph g)
	{
		boolean ans=true;
		for(node_data v:g.getV())
		{
			if(v.getTag()==0)ans=false;
		}
		return ans;
	}

	/*
	 * find node that not visited with min weight 
	 * return key of node
	 */
	public int minW(graph g,int src)
	{
		int key=src;
		double minW=Double.POSITIVE_INFINITY;
		for(node_data v:g.getV())
		{
			if(v.getTag()==0&&v.getWeight()<=minW)//check min and not visited
			{
				minW=v.getWeight();
				key=v.getKey();
			}
		}
		return key;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		if(src==dest)return null;
		ArrayList<node_data> sp=new ArrayList<node_data>();
		shortestPathDist(src,dest);	
		sp.add(0,gr.getNode(dest));//add dest
		int key=-1;
		node_data d=gr.getNode(dest);
		while(key!=src)
		{
			node_data x=this.gr.getNode(Integer.parseInt(d.getInfo()));
			sp.add(0, x);
			key=x.getKey();
			d=gr.getNode(key);
		}
		return sp;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		if(targets.size()==0)return null;
		ArrayList<node_data>list=new ArrayList<node_data>();
		ArrayList<node_data>list2=new ArrayList<node_data>();
		for (int i = 0; i+1 < targets.size(); i++)
		{
			list.addAll(shortestPath(targets.get(i), targets.get(i+1)));
		}
		
		
//		for (int i = 0; i+1 < targets.size(); i++)
//		{
//			list2= (ArrayList<node_data>) shortestPath(targets.get(i), targets.get(i+1));
//			list.addAll(list2);
			
//			node_data v=gr.getNode(targets.get(i));
//			edge_data e=gr.getEdge(targets.get(i), targets.get(i+1));
//			if(v.getTag()==0&&e.getTag()==0)
//			{
//			list.addAll(shortestPath(targets.get(i), targets.get(i+1)));
//			e.setTag(1);
//			}
//		}
		
		
		
		
		
		
		
		
//		ArrayList<node_data> tar =new ArrayList<node_data>();
//		clearG();
//		for(node_data v:gr.getV())
//		{
//			for (int i = 0; i < targets.size(); i++) 
//			{
//				if(v.getKey()==targets.get(i)) 
//				{
//					v.setInfo("target");
//					tar.add(v); // save the nodes we must pass
//				}
//			}
//		}
//		
//		for (int i = 0; i+1 < targets.size(); i++) 
//		{
//			
//			node_data s=gr.getNode(targets.get(i));
//			node_data t=gr.getNode(targets.get(i+1));
//			edge_data e=gr.getEdge(s.getKey(), t.getKey());
//			e.setInfo("target");
//			
//			if(e.getInfo().equals("target"))
//			{
//			list.addAll(shortestPath(targets.get(i), targets.get(i+1)));
//			e.setInfo("");
//			}		
//		}
//		for(int i=0;i+1<tar.size();i++)
//		{
//			if(tar.get(i).getInfo().equals("target"))
//			{
//				list.addAll(shortestPath(tar.get(i).getKey(), (tar.get(i+1).getKey())));
//				tar.get(i).setInfo("");
//			}
//			
//		}

		return list;
	}

	@Override
	public graph copy() {
		graph g = new DGraph();
		for(node_data v:this.gr.getV())
		{
			g.addNode(v);
			for(edge_data e: this.gr.getE(v.getKey()))
			{
				g.connect(e.getSrc(), e.getDest(), e.getWeight());
			}
			
		}
		
		return g;
	}


}

