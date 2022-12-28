package Design;

import java.util.ArrayList;
import java.util.List;

class Point {

	private float x;
	private float y;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
//Inside a region, we have points, + a region might overlap with other, creating quadrants
class Region{
	private float x1;
	private float y1;
	private float x2;
	private float y2;
	
	public Region(float x1, float y1, float x2, float y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	public float getX1() {
		return x1;
	}
	public void setX1(float x1) {
		this.x1 = x1;
	}
	public float getY1() {
		return y1;
	}
	public void setY1(float y1) {
		this.y1 = y1;
	}
	public float getX2() {
		return x2;
	}
	public void setX2(float x2) {
		this.x2 = x2;
	}
	public float getY2() {
		return y2;
	}
	public void setY2(float y2) {
		this.y2 = y2;
	}
	
	public boolean containsPoint(Point point) {
		return point.getX() >= this.getX1()&&
			   point.getX() < this.getX1() &&
			   point.getY() >= this.getY1() &&
			   point.getY() < this.getY2();
	}
	
	public boolean doesOverlap(Region testRegion) {
		if(testRegion.getX2() < this.getX1())
			return false;
		if(testRegion.getX1() > this.getX2())
			return false;
		if(testRegion.getY2() < this.getY1())
			return false;
		if(testRegion.getY1() > this.getY2())
			return false;
		return true;
	}
	
	public Region getQuadrant(int quadrantIndex) {
		float quadrantWidth  = this.x2 - this.x1 / 2;
		float quadrantHeight = this.y2 - this.y1 / 2;
		
		//0 = SW, 1 = NW, 2 = NE, 3=SE
		switch(quadrantIndex) {
		  case 0:
			  return new Region(x1,y1, x1 + quadrantWidth, y1 + quadrantHeight);
		  case 1:
			  return new Region(x1, y1+quadrantHeight,x1 + quadrantWidth,y2);
		  case 2:
			  return new Region(x1+quadrantWidth,y1+quadrantHeight, x2,y2);
		  case 3:
			  return new Region(x1+quadrantWidth,y1, x2,y1+quadrantHeight);
		}
		
		return null;
	}
	
	
	@Override
	public String toString() {
		return "Region [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
	}
}
// adding, searching and creating quadrants
class QuadTre{
	 
	private List<Point> points = new ArrayList<>();
	private Region boundary;
	private List<QuadTre> quadTrees = new ArrayList<>();
	private StringBuilder searchTraversePath;
	
	QuadTre(Region boundary){
		this.boundary = boundary;
	}
	
	void createQuadrants() {
		Region region;
		for(int i=0;i<4;i++) {
			region = this.boundary.getQuadrant(i);
			quadTrees.add(new QuadTre(region));
		}
	}
	
	
	public boolean addPoint(Point point) {
		if(this.boundary.containsPoint(point)) {
			if(this.points.size() < 4) {
				this.points.add(point);
			}else {
				if(this.quadTrees.size()==0)
					createQuadrants();
				return addPointToOneQuadrant(point);
			}
		}
		return false;
	}
	
	public boolean addPointToOneQuadrant(Point point) {
		boolean isPointAdded;
		for(int i=0;i<4;i++) {
			isPointAdded = this.quadTrees.get(i).addPoint(point);
			if(isPointAdded)
				return true;
		}
		return false;
	}
	
//	public List<Point> search(Region searchRegion, List<Point> matches){
//		
//		if(matches ==null)
//			
//		
//		for(Point point: points) {
//			if(searchRegion.containsPoint(point)) {
//				matches.add(point);
//			}
//		}
//		
//	}
	
}



public class QuadTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
