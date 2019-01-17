//*******************************************************************
//  BinærTreNode.java               
//
//  Representerer en node i et binært tre.
//*******************************************************************

public class BinaerTreNode<T> {
   private T element;
   private BinaerTreNode<T> venstre, høyre;

   
   
   /*****************************************************************
     Oppretter et nytt tre med spesifisert data.
   *****************************************************************/
   BinaerTreNode (T el) {
      element   = el;
      venstre   = null;
      høyre     = null;
   }
         
   /******************************************************************/
   /*   Hent- og settmetoder
   /******************************************************************/
   
    
 public BinaerTreNode<T> getVenstre(){
  return venstre;
 }
 
 public BinaerTreNode<T> getHoyre(){
  return høyre;
 }
 
 public void setVenstre(BinaerTreNode<T> ny){
  venstre = ny;
 }
 
 public void setHoyre(BinaerTreNode<T> ny){
  høyre = ny;
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

      if (høyre != null)
         barn = barn + 1 + høyre.antallBarn();

      return barn;
   }
}
