import java.io.*;
public class FootballManager2k21{

  public static void definisciRuoli(String Giocatori[]){
    final int nPortieri=15;
    final int nDifensori=30;
    final int nCentrocampisti=35;
    final int nAttaccanti=20;

    

  }

  private static void creaGiocator1(String Giocatori[]){
    String[]Nomi={"Lukabboloy","Sean","TonyFantino","Guesus","AlexObesoNano","Deiso","Carolo","Marvin","EvilKann","Carl","Bernardo","Joele","Gabe","William","Marco","'Ntuoni","Juanni","Sarpeni","Saro","Gregorio","Mariello","Salvatore","Sandro","Frode","Gianni","Moe","Dark","Michele","Pakalu","Pinzkeberg"};
    String[]Cognomi={"Picone","Figliodijuanni","Canadesi","Girelli","Piconetu","Chamberlain","Kane","Cosimo","Russell","Jordano","De Magistris","Cosmo","Froicio","Berlinguer","Boschetti","Dula","Scavoli","Bomba","Settebello","Laureantont","Battilamiera","Rollins","Egregio","Mazza","Pinorat","Hamilton","Gang","Gianni","Misseri","Andreotti","Papito","Osas","Maggi","Fonino"};
    int max=Nomi.length-1;
    int min=0;
    int range=max-min+1;
    int randNomi;
    int randCognomi;

    for (int i=0 ;i<Giocatori.length ;i++ ) {

      boolean controlloNomi=false;
      randNomi=(int)(Math.random() * range) + min;
      randCognomi=(int)(Math.random() * range+4) + min;
      String ciocatori= Nomi[randNomi]+" "+Cognomi[randCognomi];

      for (int j=0 ;j<i ;j++ ) {
        String gae = Giocatori[j];

        if ( (ciocatori.equals(gae) )  ) {  //gae=GenerazioneArrayEnonsapevochemetteredopo
          controlloNomi=true ;
        }
      }

      if (controlloNomi == false  ){
        Giocatori[i]=ciocatori;
      }else if (i>0)
          i--;
      }


    for (int picone=0;picone<Giocatori.length;picone++){
      System.out.println(Giocatori[picone]);
    }
  }
  public static void main(String[] args) {
    InputStreamReader isr;
    BufferedReader br;
    isr = new InputStreamReader(System.in);
    br = new BufferedReader(isr);

    String[] Giocatori=new String[100];
    Int[] Caratteristiche1=new Int[100]; //velocita,tuffo
    Int[] Caratteristiche2=new Int[100]; //potenza,contrasto,posizione
    Int[] Caratteristiche3=new Int[100]; //dinamicità,visione di gioco, riflessi, scivolata
    creaGiocator1(Giocatori);

  }

}
