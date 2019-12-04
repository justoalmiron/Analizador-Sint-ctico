/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.*;
/**
 *
 * @author justo
 * Tarea 3 Traducción dirigida por sintaxis
 */
public class Main {

    int i=0;
    String synchset[];
    //String entrada =  ""; para ingresar cadena a controlar
    String entrada =  "";
    lexema analizador_lexico;
    String salida= "";
    
    public Main() throws IOException {
       entrada=leer();
       analizador_lexico = new lexema(entrada,i);
       System.out.println(entrada); //imprime texto de entrada
       analizador_lexico.gettoken(); //funcion de la clase lexema trae token 
       while(analizador_lexico.getTokens() == " " || analizador_lexico.getTokens() == "\n" || analizador_lexico.getTokens() == "\t"   ){
            
           analizador_lexico.gettoken();
       }
       analisis();
      
       
    }

    
    //1 funcion por cada no terminal
       public void analisis() throws IOException{
        //subrutina que llama a la gramatica 1 funcion por cada no terminal
        //en cada no terminal tiene un control de errores 
           json();

      
 
      }
       
       public void json() throws IOException{
        String[] firstset={"L_CORCHETE", "L_LLAVE"};
        String[] followset={""};
        checkinput (firstset,followset);
        if (tokenEnarray(analizador_lexico.getTokens(),followset )==1) {
           element();
           
          
           
        }
        checkinput(followset,firstset);
       }
       
       public void element(){
        String[] firstset={"L_CORCHETE", "L_LLAVE"};
        String[] followset={"COMA","",""};
        checkinput (firstset,followset);
           
        if (tokenEnarray(analizador_lexico.getTokens(),followset )==1) {   
              if(analizador_lexico.getTokens()== "L_LLAVE"){
                
                  object();
                  
                  
              }else if(analizador_lexico.getTokens()== "L_CORCHETE"){  
                  array();
              }
              
              
             }
         followset[1]= "R_CORCHETE";
         followset[2]= "R_LLAVE";
         checkinput(followset,firstset);
       }
       
       
       public void array(){
          String[] firstset={"L_CORCHETE"};
          String[] followset={"COMA",""};
          checkinput (firstset,followset);
 
          
          if (tokenEnarray(analizador_lexico.getTokens(),followset )==1) {  
           if(analizador_lexico.getTokens()== "L_CORCHETE"){
              macht("L_CORCHETE");
              if(analizador_lexico.getTokens()!= "R_CORCHETE") {
              element_list();  
              
              
              }
              macht("R_CORCHETE");
           }
          }
          followset[1]= "R_LLAVE";
          checkinput(followset,firstset); 
          
       }
       
       public void element_list(){
         String[] firstset={"L_CORCHETE","L_LLAVE"};
         String[] followset={"R_CORCHETE"};
         checkinput (firstset,followset);
   
         if (tokenEnarray(analizador_lexico.getTokens(),followset )==1) {  
         
         element();
       
     
         if(analizador_lexico.getTokens()== "COMA")  {
         element_listP();
      
        
         }
         
         }
         checkinput(followset,firstset);
  
       }  
       
       
       public void element_listP(){
         String[] firstset={"COMA"};
         String[] followset={"R_CORCHETE"};
         checkinput (firstset,followset);
        
         
         if (tokenEnarray(analizador_lexico.getTokens(),followset )==1) {   
           
          if(analizador_lexico.getTokens()=="COMA" ){
           macht("COMA");
       
           element();
   
          if(analizador_lexico.getTokens()== "COMA")  { 
           
            element_listP();
            
          }
          }
         } 
          checkinput(followset,firstset);
          
          
       }        
       
       

       public void object(){
        String[] firstset={"L_LLAVE"};
        String[] followset={"COMA",""};
        checkinput (firstset,followset);
        if (tokenEnarray(analizador_lexico.getTokens(),followset )==1) {  
 
           if(analizador_lexico.getTokens()== "L_LLAVE"){  
              macht("L_LLAVE");
              if(analizador_lexico.getTokens()!= "R_CORCHETE") {
              attributes_list();            
              }
              macht("R_LLAVE");
            }
        }  
         followset[1]= "R_CORCHETE";
         checkinput(followset,firstset);
          
       }
       
       
      public void attributes_list(){
        String[] firstset={"STRING"};
        String[] followset={"R_LLAVE"};
        
        
        checkinput (firstset,followset);
        if (tokenEnarray(analizador_lexico.getTokens(),followset )==1) {     
          
         attributes();
      
         if(analizador_lexico.getTokens()== "COMA")  {
         
          attribute_listP();
         
         }
        }
        checkinput(followset,firstset);
         
        
        
      } 
      
      
      public void attribute_listP(){ 
        String[] firstset={"COMA"};
        String[] followset={"R_LLAVE"}; 
        checkinput (firstset,followset);
  
        
        if (tokenEnarray(analizador_lexico.getTokens(),followset )==1) {   
          if(analizador_lexico.getTokens()== "COMA")  {
           macht("COMA");  

          
           attributes();
  
          
           if(analizador_lexico.getTokens()== "COMA")  {
            
             
            attribute_listP();
          
            
           }
          }
        }
        checkinput(followset,firstset);
         
     
        
      }       
      
    public void attributes(){ //verificar su conjunto siguiente
      String[] firstset={"STRING"};
      String[] followset={"COMA","R_LLAVE"};
      checkinput (firstset,followset);

      
      
      if (tokenEnarray(analizador_lexico.getTokens(),followset )==1) { 
        
          attribute_name();
          macht("DOS_PUNTOS");
          attribute_value();
        
       
    
      } 
      checkinput(followset,firstset);
       
      
      
    }  
    public void attribute_name(){
     String[] firstset={"STRING"};
     String[] followset={"DOS_PUNTOS",""};
     checkinput (firstset,followset);
     
     
     if (tokenEnarray(analizador_lexico.getTokens(),followset )==1) {    
        
       if (analizador_lexico.getTokens()== "STRING"){ 
         
           macht("STRING");
         ;
       }
     }  
     followset[1]= "R_LLAVE";
     checkinput(followset,firstset); 
     
    
    }
    
    
    
    
    public void attribute_value(){
     String[] firstset={"PR_FALSE","PR_NULL","PR_TRUE","NUMBER","L_CORCHETE","L_LLAVE","DOS_PUNTOS","STRING"};
     String[] followset={"COMA",""};
     checkinput (firstset,followset);
     
     if (tokenEnarray(analizador_lexico.getTokens(),followset )==1) { 
        
         
        if(analizador_lexico.getTokens()== "L_LLAVE" || analizador_lexico.getTokens()== "L_CORCHETE" ){
             
            element();
            
        }   
        if(analizador_lexico.getTokens()== "NUMBER"){
   
            macht("NUMBER");
         
        }else if(analizador_lexico.getTokens()== "STRING"){
      
            macht("STRING");
         
        }else if(analizador_lexico.getTokens()== "PR_TRUE"){
     
            macht("PR_TRUE");
        
        }else if(analizador_lexico.getTokens()== "PR_FALSE"){
           
            macht("PR_FALSE");
         
        }else if(analizador_lexico.getTokens()== "PR_NULL"){
          
            macht("PR_NULL");
        
        }
      
     }
     followset[1]= "R_LLAVE";
     checkinput(followset,firstset);
       
    }
    
    public void macht(String exptoken){
        //get token trae consigo espacios en blanco por eso con este ciclo se omiten los tokens en blanco y saltos
        while(analizador_lexico.getTokens() == " " || analizador_lexico.getTokens() == "\n" || analizador_lexico.getTokens() == "\t"   ){
            
           analizador_lexico.gettoken();
       }
       
       if(analizador_lexico.getTokens() == exptoken){
           System.out.println(analizador_lexico.getTokens() + "  sintacticamente correcto"); //imprime tokens que estan sintacticamente correctos
           analizador_lexico.gettoken();
           
       
       }
        //get token trae consigo espacios en blanco por eso con este ciclo se omiten los tokens en blanco y saltos
        while(analizador_lexico.getTokens() == " " || analizador_lexico.getTokens() == "\n" || analizador_lexico.getTokens() == "\t"  ){
            
           analizador_lexico.gettoken();
       }
       
    }
    public void checkinput(String[] firstset, String[] followset){
      //check de conjunto primero y siguiente
        if(analizador_lexico.getLongitud()< entrada.length()){  //esta condicion detiene el analisis cuando el texto llega a fin de linea     
           if(tokenEnarray(analizador_lexico.getTokens(),firstset )==1 )  {
               System.out.println("error sintactico token" + analizador_lexico.getTokens() + "no valido" );
               
               scanto(ConcatenarArray(firstset,followset));
                      
               
               
           }
        }
    
    }
    
    public void scanto(String[] synchset){
    //controla si es scan o pop para el control de errores
        
           while(tokenEnarray(analizador_lexico.getTokens(),synchset )==1){
             if(analizador_lexico.getLongitud()< entrada.length()){ break;}
             analizador_lexico.gettoken();
               System.out.println("error se pasa a siguiente palabra");
              
                
           }
    
        
    }
    
    
    
     public String leer()
      //subrutina para leerarchivo txt y guardar en cadena        
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String lineas= "";
        try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File ("archivo.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
 
			// Lectura del fichero
			System.out.println("Leyendo el contendio del archivo.txt");
			String linea;
			while((linea=br.readLine())!=null){
				lineas = lineas + linea; }
                        return lineas;
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{
              if( null != fr ){
                 fr.close();
              }
           }catch (Exception e2){
              e2.printStackTrace();
           }
        }
        return null;
    }
     

    
    public static String[] ConcatenarArray(String[] o1, String[] o2)
	//contena dos array
    {
		String[] ret = new String[o1.length + o2.length];
 
		System.arraycopy(o1, 0, ret, 0, o1.length);
		System.arraycopy(o2, 0, ret, o1.length, o2.length);
 
		return ret;
	} 
     
    public static int tokenEnarray(String token,String[] array){
    //Funcion que consulta si un token esta o no en un array
        for(int i=0;i< array.length; i++){
            if(token == array[i] ){
                       
                return 0;
        }
    
        
        }
        
        return 1;
    }
    
    
    public static void main(String[] args) throws IOException {
        new Main();
        
        
    }
    
}
