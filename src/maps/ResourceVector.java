package maps;

import java.awt.Point;
import java.util.Vector;

public class ResourceVector {
	Vector<Resource> Tree;
	Vector<Resource> GoldMine;
	Vector<Resource> IronMine;
	Vector<Resource> Farm;
	Vector<Resource> Fish;
	public ResourceVector(Map map) {
		// TODO Auto-generated constructor stub
		Tree = new Vector<>();
		GoldMine = new Vector<>();
		IronMine = new Vector<>();
		Farm = new Vector<>();
		Fish = new Vector<>();
	}

	public void setresource(Map map){
		Tree = new Vector<>();
		GoldMine = new Vector<>();
		IronMine = new Vector<>();
		Farm = new Vector<>();
		Fish = new Vector<>();
		for(int i=0 ; i<map.getSecondLayer().length ; i++){
			for(int j=0 ; j<map.getSecondLayer()[i].length ; j++){
				switch (map.getSecondLayer()[i][j]) {
				case 7:{//fish
					Fish.add(new Resource(15000,new Point(j,i),40,50));
				}
				break;
				case 8:{//tree
					Tree.add(new Resource(10000,new Point(j,i),30,50));
				}
				break;
				case 9:{//farm
					Farm.add(new Resource(8000,new Point(j,i),35,50));
				}
				break;
				case 10:{//iron
					IronMine.add(new Resource(20000,new Point(j,i),20,25));
				}
				break;
				case 11:{//gold
					GoldMine.add(new Resource(20000,new Point(j,i),20,20));

				}
				break;

				default:
					break;
				}

			}
		}	
	}
	
	public int searchForResource(int resourceType , Point p){
		switch (resourceType) {
		case 7:{//fish
			for(int i=0 ; i<Fish.size() ; i++){
				if(Fish.get(i).getResourceP().equals(p)){
					return i;
				}
			}
		}
		
		break;
		
		case 8:{//tree
			for(int i=0 ; i<Tree.size() ; i++){
				if(Tree.get(i).getResourceP().equals(p)){
					return i;
				}
			}
		}
		
		break;
		
		case 9:{//farm
			for(int i=0 ; i<Farm.size() ; i++){
				if(Farm.get(i).getResourceP().equals(p)){
					return i;
				}
			}
		}
		
		break;
		
		case 10:{//iron
			for(int i=0 ; i<IronMine.size() ; i++){
				if(IronMine.get(i).getResourceP().equals(p)){
					return i;
				}
			}
		}
		
		break;

		case 11:{//gold
			for(int i=0 ; i<GoldMine.size() ; i++){
				if(GoldMine.get(i).getResourceP().equals(p)){
					return i;
				}
			}
		}
		break;

		default:
		break;
		}
		return 0;
	}

	public Vector<Resource> getTree() {
		return Tree;
	}

	public Vector<Resource> getGoldMine() {
		return GoldMine;
	}

	public Vector<Resource> getIronMine() {
		return IronMine;
	}

	public Vector<Resource> getFarm() {
		return Farm;
	}

	public Vector<Resource> getFish() {
		return Fish;
	}
	
	
}
