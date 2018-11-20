public class PlayerHand implements Serializable,Cloneable{

    private static final int MAX_HELD_CARDS=6;  //constante
    private ArrayList<Card> hand;

    public PlayerHand(){
	hand=new ArrayList<Card>();
    }
    
    public void addCard(Card c){
	hand.add(c);
    }
    public ArrayList<Card> getHand(){
	return hand;
    }

    public Card getCardByIndex(int index){
	if(getPlayerHandSize()==0) return null;
	return hand.get(index);
    }

    public Card removeCard(int index){
	if(getPlayerHandSize()==0) return null;
	return hand.remove(index);
    }

}
	//autres fonctions :rotateCardByIndex
	//getMaxHeldCards() return 6
	//getHandSize()
	//swapCards : echange de place 2 cartes
	//discardCArd(int index): quand il passe son tour,les autres choisissent une carte dans sa main
	
