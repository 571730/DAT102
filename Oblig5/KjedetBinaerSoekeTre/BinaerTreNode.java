//*******************************************************************
//  Bin�rTreNode.java               
//
//  Representerer en node i et bin�rt tre.
//*******************************************************************

public class BinaerTreNode<T> {
   private T element;
   private BinaerTreNode<T> venstre, h�yre;

   
   
   /*****************************************************************
     Oppretter et nytt tre med spesifisert data.
   *****************************************************************/
   BinaerTreNode (T el) {
      element   = el;
      venstre   = null;
      h�yre     = null;
   }
         
   /******************************************************************/
   /*   Hent- og settmetoder
   /******************************************************************/
   
    
 public BinaerTreNode<T> getVenstre(){
  return venstre;
 }
 
 public BinaerTreNode<T> getHoyre(){
  return h�yre;
 }
 
 public void setVenstre(BinaerTreNode<T> ny){
  venstre = ny;
 }
 
 public void setHoyre(BinaerTreNode<T> ny){
  h�yre = ny;
 }
 
 public T getElement(){
  return element;
 }
 public void setElement(T el){
  element = el;
 }
 
   /*****************************************************************
     Returnerer antall barn ulik null.     
   *****************************************************************/
   public int antallBarn() {
      int barn = 0;

      if (venstre != null)
         barn = 1 + venstre.antallBarn();

      if (h�yre != null)
         barn = barn + 1 + h�yre.antallBarn();

      return barn;
   }
}
