package GUI;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import algorithms.*;
import dataStructure.*;
import utils.*;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Window extends JFrame implements ActionListener, MouseListener, Serializable
{
	LinkedList<Point3D> points = new LinkedList<Point3D>();
	graph gr;
	private static JFrame frame;
	public Window()
	{
		initGUI();
	}
	public Window(graph g) {
		this.gr=g;
		initGUI();
	}
	private void initGUI() //להוסיף אפשרויות
	{
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stop running window
		MenuBar menuBar = new MenuBar();
		//Menu
		Menu menu = new Menu("Menu");
		this.setMenuBar(menuBar);
		menuBar.add(menu);
		MenuItem save = new MenuItem("save");
		save.addActionListener(this);
		MenuItem init = new MenuItem("init");
		init.addActionListener(this);
		menu.add(save);
		menu.add(init);
		//Graph algorithms
		Menu algo = new Menu("Graph algorithms");
		menuBar.add(algo);
		MenuItem isconnected = new MenuItem("is connected");
		isconnected.addActionListener(this);
		MenuItem shortestPathDist = new MenuItem("shortest path distance");
		shortestPathDist.addActionListener(this); 
		MenuItem shortestPath = new MenuItem("shortest path");
		shortestPath.addActionListener(this);
		MenuItem tsp = new MenuItem("tsp");
		tsp.addActionListener(this);
		algo.add(isconnected);
		algo.add(shortestPathDist);
		algo.add(shortestPath);
		algo.add(tsp);
		this.addMouseListener(this);
	}

	public void paint(Graphics g)//לעבור על קודקודים לצייר בצבע. לעבור על צלעות בעזרת קולקשן ולצבוע בצבע אחר. להכניס ערכים לטאג של הצלעות כדי לדעת אם ישתנו ולצבוע את הדרך הקצרה
	{
		super.paint(g);
		Point3D p = null;
		for (node_data v : gr.getV()) 
		{
			g.setColor(Color.BLACK);
			g.fillOval(v.getLocation().ix(),v.getLocation().iy(), 10, 10);
			g.drawString(Integer.toString(v.getKey()), v.getLocation().ix()+2, v.getLocation().iy()-5);
			Collection<edge_data> e=gr.getE(v.getKey());
			g.setColor(Color.RED);
			for(edge_data ed: e)
			{
				if(ed.getTag()==1)
				{
					g.setColor(Color.GREEN);
					ed.setTag(0);
				}
				int xs=gr.getNode(ed.getSrc()).getLocation().ix();// x src
				int ys=gr.getNode(ed.getSrc()).getLocation().iy();// y src
				int xd=gr.getNode(ed.getDest()).getLocation().ix();// x dest
				int yd=gr.getNode(ed.getDest()).getLocation().iy();// y dest
				g.drawLine(xs+4,ys+4,xd+4,yd+4);
				int xl=(xs+xd)/2;//x string weight of line
				int yl=(ys+yd)/2;//y string weight of line
				g.drawString(Double.toString(ed.getWeight()), xl,yl);
				g.setColor(Color.RED);
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) //מה יקרה בלחיצת עכברת קייסים של כל לחיצה
	{
		String str = e.getActionCommand();
		switch(str) 
		{
		case "save":
			Graph_Algo gSave=new Graph_Algo();
			gSave.init(this.gr);
			FileDialog sa=new FileDialog(Window.frame,"save .txt",FileDialog.SAVE);
			sa.setVisible(true);
			String file=null;
			file=sa.getFile();
			gSave.save(sa.getDirectory()+file+".txt");
			break;
		case "init":
			Graph_Algo gInit=new Graph_Algo();
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			JFrame frame = new JFrame("JComboBox Test");
			frame.setLayout(new FlowLayout());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JFileChooser chooser = new JFileChooser();
			int returnValue = chooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) 
			{
				File selected = chooser.getSelectedFile();

				gInit.init(selected.getPath());
				gr = gInit.copy();
			
				repaint();
			}
			frame.pack();
			break;


		case "is connected":

			break;
		case "shortest path distance":
			break;
		case "shortest path":
			break;
		default:



		}
		if(str.equals("Item 1"))
		{
			Point3D p1 = new Point3D(100,100);
			Point3D p2 = new Point3D(50,300);
			Point3D p3 = new Point3D(400,150);

			points.add(p1);
			points.add(p2);
			points.add(p3);

			repaint();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Point3D p = new Point3D(x,y);
		points.add(p);
		//		repaint();
		//		System.out.println("mousePressed");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}
}
