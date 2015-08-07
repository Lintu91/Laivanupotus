
package laivanupotus;

public class Laivat {
    String nimi;
    int pituus;
    String laiva1 = "Lentotukialus";
    String laiva2 = "Risteilija";
    String laiva3 = "Havittaja";
    String laiva4 = "Sukellusvene";
    
    public Laivat() {
                
    }
  public Integer pituus(String nimi){
      
      if (nimi.equals("Lentotukialus")){
          return 4;
      }
      else if (nimi.equals("Risteilijä")){
          return 3;
      }
      else if (nimi.equals("Hävittäjä")){
          return 2;
      }
      else {
          return 1;
      }
  }
    
}
