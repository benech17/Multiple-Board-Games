public class PathCard extends Card{
    // private Shape shape;
    //ou bien un tab de boolean shape.getPaths() ??
    private boolean[] isPaths;

    //on aimerait avoir les 4 objets shape north,west... dans chaque carte ,
    // j'ai pas du bien comprendre l'utilisation des enums !

    public PathCard(boolean[] t){
	super.setCardName("PATHCARD");
	isPaths=t;
    }

    public PathCard rotate(){} //echanger nord avec sud , east west invariants
			     

    public static void main(String args[]){
	boolean [] t1={true,true,false,false};
	PathCard p1=new PathCard(t1);
	//	PathCard p2=new PathCard(true,false,false,false);
	//	PathCard p3=new PathCard(false,true,false,false);
	//PathCard p4=new PathCard(false,true,true,true);
	System.out.println(p1);
	//System.out.println(p3);
	//System.out.println(p2);
	//System.out.println(p4);
	
    }
}
