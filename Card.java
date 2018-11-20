public abstract class Card {  //abstract mais aucune methode abstract??
    
    private boolean isVisible=false; //card is face-down default
    protected String cardName;

    public void setVisibility(boolean isVisible){
	this.isVisible=isVisible;
    }
    public boolean getVisibility(){
	return isVisible;
    }

    public void setCardName(String name){
	cardName=name;
    }
    public String getCardName(){
	return cardName;
    }
}
