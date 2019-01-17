package no.hvl.dat102;

//-----------------------------------------
//
//Balansering av uttrykk med parenteser {},(),[]
//} ] ) kalles lukkete symboler (h�yre)
// { [ ( kalles for �pne symboler (venstre)
//...{... [...(...)...]...}... lovlig (balansert) utrykk
//...{...(...[...)...]...}...  ulovlig (ikke balansert) uttrykk
//algoritme balansering
//    Lag en tom stabel
//    s� lenge( ikke-slutt p� strengen og fortsatt balansert){
//      hvis symbolet er �pent 
//             stable det p�
//      ellers hvis  symbolet er lukket 
//           hvis stabelen er tom 
//              sett fortsatt = usann, feilmelding
//           ellers
//                stable av symbol (�pent symbol)
//                hvis det �pne symbolet ikke svarer til det sist leste
//                lukkete symbolet
//                    sett fortsatt = usann, feilmelding
//  }
//    hvis stabelen er ikke-tom s� feilmelding */

public class Parentesinfo{
 
 private int linjenr;
 private int posisjon;
 private char venstreparentes;
 
 public Parentesinfo(int linjenr, int posisjon, char venstreparentes) {
	 this.linjenr = linjenr;
	 this.posisjon = posisjon;
	 this.venstreparentes = venstreparentes;
 }
 
 public Parentesinfo(){
  linjenr  = -1;
  posisjon = -1;
  venstreparentes = ')';
 }
 
 public void settLinjenr(int nyttLinjenr){
  linjenr = nyttLinjenr;
 }
 
 public void settPosisjon(int nyPosisjon){
  posisjon = nyPosisjon;
  
 }
 
 public void settVenstreparentes(char nyVenstreparentes){
  venstreparentes = nyVenstreparentes;
 }
 
 public int hentLinjenr(){ return linjenr;}
 
 public int hentPosisjon(){ return posisjon;}

 public char hentVenstreparentes(){ return venstreparentes;}

 
}//class
