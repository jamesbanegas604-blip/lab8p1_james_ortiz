/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8p1_james_ortiz;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author james
 */
public class Lab8p1_james_ortiz {
    
    /**
     * @param args the command line arguments
     */
     static char [][] supmer = new char [6][7];
    static Scanner sc = new Scanner (System.in);
    static Random ram =  new Random ();
    public static void main(String[] args) {
        // TODO code application logic here
        int op= menu();
        
           while(op!=3)
            switch(op){
               case 1:   
               conjunto();
                break;
               case 2:
                 supermer();
                 break;
               default :
                   System.out.println("adios");
            }
        
        }
    
   public static int menu(){
       System.out.println("===MENU===");
       System.out.println("1. conjuntos");
       System.out.println("2. supermercado");
       System.out.println("3. salir");
       int op = sc.nextInt();
       return op;
   }
   
     public static void conjunto() {
          ArrayList<Integer> listaa = new ArrayList<>();
          ArrayList<Integer> listab = new ArrayList<>();
          System.out.println("Tamaño del conjunto A :");
          int tama = sc.nextInt();
          llenarA(listaa,tama);
          System.out.println("Tamaño del conjunto B :");
          int tamb = sc.nextInt();
          llenarb(listab,tamb);
          int opcion;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Union ");
            System.out.println("2. Interseccion");
            System.out.println("3. Diferencia A-B");
            System.out.println("4. Diferencia B-A");
            System.out.println("5. Subconjunto A c B");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {

                case 1:
                    ArrayList<Integer> unida = new ArrayList<>();
                    unida=unir(listaa,listab);
                    mostrar(unida);
                    break;

                case 2:
                    interseccion(listaa,listab);

                    break;

                case 3:
                  difA_B(listaa,listab);
                    break;

                case 4:
                   disB_A(listaa,listab);
                    break;

                case 5:
                  subcoonjunto(listaa,listab);
                  break;
                case 6:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 6);
     }
   
   
      public static void llenarA(ArrayList<Integer> lista,int cant) {
        for (int i = 0; i < cant; i++) {
            int num = 0;
            System.out.print("ELEMENTO A ["+i+"]  :" );
            num=sc.nextInt();
              if (!lista.contains(num)) {
                lista.add(num);
            } else {
                System.out.println("Repetido, no se agrega.");
                i--;
            }
            
        }
    }
     public static void llenarb(ArrayList<Integer> lista,int cant) {
        for (int i = 0; i < cant; i++) {
            int num = 0;
            System.out.print("ELEMENTO b ["+i+"]  :" );
            num=sc.nextInt();
            if (!lista.contains(num)) {
                lista.add(num);
            } else {
                System.out.println("Repetido, no se agrega.");
                i--;
            }
        }
        
    }
      public static ArrayList<Integer> unir(ArrayList<Integer> lista1,ArrayList<Integer> lista2){
            ArrayList<Integer> nueva = new ArrayList<>();
            nueva.addAll(lista1);
            nueva.addAll(lista2);
            return nueva;
        }
      public static void mostrar(ArrayList<Integer> lista) {
          System.out.print("union : [");
        for (int i = 0;i<lista.size();i++) {
            System.out.print(lista.get(i) + ",");
        }
          System.out.println("]");
        System.out.println();
        }
     
    public static void interseccion(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {

        ArrayList<Integer> inter = new ArrayList<>();

        for (int i=0;i<lista1.size();i++) {
            if (lista2.contains(lista1.get(i))) {
                inter.add(lista1.get(i));
            }
        }

        System.out.println("Intersección: " + inter);
    }
     public static void difA_B(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {

        ArrayList<Integer> inter = new ArrayList<>();

        for (int i=0;i<lista1.size();i++) {
            if (!lista2.contains(lista1.get(i))) {
                inter.add(lista1.get(i));
            }
        }

        System.out.println("Diferencia A-B: " + inter);
    }
      public static void disB_A(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {

        ArrayList<Integer> inter = new ArrayList<>();

        for (int i=0;i<lista2.size();i++) {
            if (!lista1.contains(lista2.get(i))) {
                inter.add(lista2.get(i));
            }
        }

        System.out.println("Diferencia B-A: " + inter);
    }
      public static void subcoonjunto(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
          boolean essub=true;
          for (int i=0;i<lista1.size();i++ ){
              if(!lista2.contains(lista1.get(i))){
                  essub=false;
                 
              }
          }
          if(essub==true){
          System.out.println("A C B : TRUE");
          }else{
               System.out.println("A C B : FALSE");
          }        
      }
      
      public static void supermer(){
          char [][] mapa = {
                  {'*','*','*','*','*','*','*'},
                  {'*',' ',' ',' ',' ',' ','*'},
                  {'*','c',' ',' ',' ','l','*'},
                  {'*',' ','P',' ','A',' ','*'},
                  {'*',' ',' ',' ',' ','M','*'},
                  {'*','C',' ','$',' ',' ','*'},
                  {'*','*','*','*','*','*','*'},
          };
          imprimirTablero(mapa);
         
      }
        public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) { 
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println("");
        }
    }
      
     
}
