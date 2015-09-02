package laivanupotus;

public class Laiva {
    private int pituus;
    private String nimi;
    private int sarake;
    private int rivi;
    private String suunta;
    private int elinvoima;
    
    public Laiva(Integer pituus, String nimi) {
        this.pituus=pituus;
        this.nimi=nimi;
        this.elinvoima=pituus;
    }

    public String getNimi() { //Ehkä nää get-metodit on selkeitä

        return this.nimi;
    }
    
    public Integer getPituus(){ 
        return this.pituus;
    }
    
    public void osuma(){
        
        elinvoima--;
        
    }
    public Integer getElinvoima(){
        
        return this.elinvoima;
    }
    
    public Integer getSarake() {
        return this.sarake;
    }
    public Integer getRivi() {
        return this.rivi;
    }
    
    public void asetuLaudalle(Integer sarake,Integer rivi,String suunta){ //Laiva tiedostaa paikkansa laudalla
        
        this.sarake=sarake;
        this.rivi=rivi;
        this.suunta=suunta;
    }
    
    public boolean onRuudussa(Integer sarake, Integer rivi){ //Jos laiva on kysytyssä ruudussa, palautetaan True
        
        if(suunta.equals("V")) {
            
            if(rivi == this.rivi) {
                
                if(sarake <= this.sarake && sarake > this.sarake - this.pituus) {
                    return true;
                }
                
                return false;
            }
        }
        else if(suunta.equals("O")) {
            
            if (rivi == this.rivi) { 
                
                if (sarake >= this.sarake && sarake < this.sarake + this.pituus) {
                    return true;
                }
                
                return false;
            }
            
        }
        else if(suunta.equals("Y")) {
            
            if (sarake == this.sarake){
                
                if (rivi <= this.rivi && rivi > this.rivi - this.pituus){
                    
                    return true;
                }
                
                return false;
            }
            
        }
        else if(suunta.equals("A")) {
            
            if (sarake == this.sarake){
                
                if (rivi >= this.rivi && rivi < this.rivi + this.pituus){
                    
                    return true;
                }
                
                return false;
            }
        }
        return false;
    }
}
