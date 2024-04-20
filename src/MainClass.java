import java.io.*;

public class MainClass 
{
    public static void main(String[] args) 
    {
    	// Proviamo dei comandi che possono generare delle "eccezioni"
    	// (cioè degli errori potenzialmente dannosi per l'esecuzione
    	// del programma e/o addirittura per tutto il computer
    	
    	
    	
    	//Scriveremo il codice "pericoloso dentro il blocco "try"
    	// In questo caso mettiamo diversi possibili errori tutti
    	// dentro un unico blocco, ma è possibile, ovviamente
    	// anche scrivere un blocco diverso per ogni istruzione
        
    	try // è necessaria la parola try 
    	{ 	// e da qui uno "scope", cioé un blocco di codice contenuto tra parentesi graffe
    		
    		
    		/*
    		 * Ogni volta che si scatena un'eccezione si va direttamente al primo blocco
    		 * Catch con l'eccezione compatibile (generica o specifica), quindi per testare
    		 * gli altri errori commentare quelli precedenti
    		 */
    		            
            // Invochiamo un metodo da un oggetto null
            String a = null; 
            a.toCharArray(); // L'oggetto è nullo: NullPointerException
            
            // Facciamo una divisione per zero:
    		System.out.println(10/0); // Non si può dividere per zero: ArithmeticException
            
            // Accediamo ad un elemento dell'array oltre il suo limite
    		int[] array = new int[3];	// L'array ha 3 elementi
			System.out.println(array[3]); // L'elemento 3 è il quarto: ArrayOutOfBound
    		
            // Convertiamo una stringa in numero che non abbia numeri al suo interno
    		Integer.parseInt("ciao"); // Questa stringa non contiene numeri: NumberFormat
    		
    		// Apriamo un file che non esiste 
            FileReader file = new FileReader("test.txt"); // Non esiste il file: FileNotFound


        }
    	
    	// da qui in poi possiamo mettere tutti i blocchi catch che vogliamo
    	// ognuno gestirà un'eccezione specifica, determinata dal nome della classe
    	// del parametro che troviamo da parentesi tonde
    	
    	
    	// Eccezione lanciata quando si tenta di utilizzare un riferimento a un oggetto che è `null`.
    	catch (NullPointerException e) 
    	{            
            System.out.println("1 - Messaggio dell'errore: " + e.getMessage());
        } 
    	
        // Eccezione lanciata quando si verifica un errore aritmetico, come una divisione per zero.
    	catch (ArithmeticException e) 
    	{
            System.out.println("2 - Messaggio dell'errore: " + e.getMessage());
            // azioni specifiche per errori aritmetici (es. div. per zero, logaritmo negativo, ecc.);
        } 
    	
        // Eccezione lanciata quando si tenta di accedere a un indice di array che è al di fuori del range valido.
    	catch (ArrayIndexOutOfBoundsException e) 
    	{
            System.out.println("3 - Messaggio dell'errore: " + e.getMessage());
            // azioni specifiche per quando si sconfina in un array o matrice
        } 
    	
        // Eccezione lanciata quando si tenta di convertire una stringa in un numero, ma la stringa non ha un formato valido per il numero.
    	catch (NumberFormatException e) 
    	{
            System.out.println("4 - Messaggio dell'errore: " + e.getMessage());
            // azioni specifiche per quando si fa un errore di formato numerico (es. parseInt)
        } 
    	
    	// Eccezione lanciata quando il file specificato non è stato trovato.
    	catch (FileNotFoundException e) // l'oggetto e, conterrà tutti i dettagli dell'errore
    	{            
            System.out.println("5 - Messaggio dell'errore: " + e.getMessage());
            // azioni specifiche per il File non trovato
        } 

        // Eccezione generica, se non si è sicuri dell'errore che potrebbe generarsi
    	// Exception è la superclasse di tutte le classi scritte dentro i Catch sopra
    	catch (Exception e) 
    	{
            System.out.println("7 - Eccezione generica" + e.getMessage());
        }
    	
        System.out.println("Ora che gestito tutte le eccezioni, anche se c'era un errore, il programma continua a girare");

        
        /*
         * Ricordare: 
         * si entra solo nel primo blocco Catch compatibile con il tipo di eccezione
         * 
         * L'errore generico è compatibile con tutti i tipi di eccezione quindi
         * si entrerà in quel blocco solo se nessun altro errore specifico
         * è stato catturato prima, ad esempio:
         * 
         * se l'errore è aritmetico non si enterà anche nel blocco Catch generico
         * dato che è scritto prima
         * 
         * ma se si cancella il blocco Catch dell'errore aritmetico allora verrà
         * l'errore verrà catturato da quello generico. 
         */
    }
}
