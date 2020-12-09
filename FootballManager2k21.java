import java.io.*;
public class FootballManager2k21{

  private static void creaGiocator1(String Giocatori[]){
    String[]Nomi={"Kobe","Michael","LeBron","James","Kawhi","Wilt","Stephen","Tim","Marco","Bill"};
    String[]Cognomi={"Bryant","Jordan","James","Harden","Leonard","Chamberlain","Curry","Duncan","Belinelli","Russell"};
    int max=Nomi.length-1;
    int min=0;
    int range=max-min+1;
    int randNomi;
    int randCognomi;
    boolean salcazzi=true;
    for (int i=0 ;i<Giocatori.length ;i++ ) {
      randNomi=(int)(Math.random() * range) + min;
      randCognomi=(int)(Math.random() * range) + min;
      for (int j=0 ;j<i ;j++ ) {
        if (Nomi[randNomi]+" "+Cognomi[randCognomi]!=Giocatori[j]) {
          salcazzi=false;
        }
      }
      if (!salcazzi){
        Giocatori[i]=Nomi[randNomi]+" "+Cognomi[randCognomi];
        salcazzi=true;
      }

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
    creaGiocator1(Giocatori);
  }

}
