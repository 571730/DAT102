import java.util.*;
public interface BSTreADT<T extends Comparable<T>> extends Iterable<T> {
  // Burde hatt javadoc her 
    // anbefaler at du fyller ut med javadoc her

  
    
   /*****************************************************************
     Returnerer sann hvis dette binære trett er tomt og usann ellers.
   *****************************************************************/
    
    public int antall();   
   
   /*****************************************************************
     Returnerer sann hvis dette binære treet er tom og usann ellers.
   *****************************************************************/
   public boolean erTom();   

   /******************************************************************
     Legger det spesifiserte elementet på passende plass i dette binære 
     søketreet. Like elementer blir lagt til høyre.
     ******************************************************************/
   public void leggTil(T element);       
  
  /**********************************************************************
     Returnerer en referanse til det spesifiserte elementet hvis det fins
     i dette binære treet ellers returneres null.
  / ***********************************************************************/
   public T finn(T element);  
  
   /************************************************************************
    Fjerner et element fra dette treet hvis det fins, ellers returneres null
   ************************************************************************/
   
   
   
   // public T fjern( T element);
    // Ikke impelmentert
   
   
   /*******************************************************************
    Returnerer en inordeniterator. 
   /*******************************************************************/ 
  public Iterator<T> iterator();
  }      
   


//************************************************************************

