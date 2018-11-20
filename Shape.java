public enum Shape {
    //on aurait besoin d'un tableau de Shape?? mais alors quel est l'interet des enums par rapport a une classe normale.
    
    //objets directement construits 
    NORTH("north",true), 
    SOUTH("south",false),
    EAST("east",false),
    WEST("west",true);
    
    //attributs
    private String direction;
    private boolean isPath;
    

    Shape(String direction,boolean isPath){  //pas de modificateur d'accès 
	this.direction=direction;
	this.isPath=isPath;
    }
    
    public String getDirection(){ return direction;}
    public boolean getIsPath(){ return isPath;}

    public static boolean[] getPaths(){
	boolean [] res=new boolean[4];
	int i=0;
	for(Shape shapes:Shape.values()){
	    res[i]=shapes.isPath;
	    i++;
	}
	return res;
    }
    public static void Affiche (){
	for(Shape shapes:Shape.values()){
	    if(shapes.isPath)
		System.out.println("j'ai un chemin vers le "+shapes.direction);
	}
    }
   
    public static void main(String [] args){
	boolean [] test=getPaths();
	for(int i=0;i<4;i++)
	    System.out.println(test[i]+"lol");
	affiche();
    }
    
}
