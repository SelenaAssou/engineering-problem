//Modified by Soukaina Assou

package app;

import java.util.*;
import java.io.*;


public final class Main {

  private Main() {}

  public static void main(String[] args) throws Exception {

    List<Invoice> myInvoices = getMyInvoiceList();
    List<Invoice> accountantsInvoices = getAccountantsInvoiceList();
    
    // Reconcile the invoices between lists. 
    // Use System.out.println() to print out the results.

    int flag = 0;
    
    //Using 2 for loops to get the Invoice objects to be evaluated.
    //Assuming we are comparing the Accountants list to OURs...
    for(int i = 0; i < invoices.size() ; i++){
      //Must reset the flag to its original value: 0 for the next Invoice comparison.
      flag = 0;
      for(int j = 0; j < myInvoices.size() ; j++){
        //If the Invoice Numbers are equal
        if(invoices.get(i).getInvoiceNumber().equals(myInvoices.get(j).getInvoiceNumber()))
        {   //Check if the Amount is also equal ...
          if(invoices.get(i).getInvoiceAmount() == (myInvoices.get(j).getInvoiceAmount())){
            flag = 1 ;
            break;
          }else{
            //Point out the difference in either invoice numbers since the numbers are equal ...
            System.out.println("There is a difference in amounts for invoice: " + 
              invoices.get(i).getInvoiceNumber());
            flag =  1;
            break;
          }
        }

      }//end of inner loop.

      //we reached the end of the loop, meaning we cou'dn't find any invoice numbers that match.
      if(flag == 0){
        System.out.println("Invoice number: " + invoices.get(i).getInvoiceNumber() + " does not exist");
      }
    }//End of outer loop.


    //Now: Evaluate my list of invoices...
    //reset original value for flag.
    flag = 0;

    //2 for loops again now outer loop: myInvoices.
    for(int i = 0; i < myInvoices.size() ; i++){
      //Must reset the flag to its original value: 0 for the next Invoice evaluaiton.
      flag = 0;
      for(int j = 0; j < invoices.size() ; j++){
        if(invoices.get(j).getInvoiceNumber().equals(myInvoices.get(i).getInvoiceNumber())){
          flag = 1;
          break;
        }

      }
      //We haven't find a match, therefore Invoice entry doesn't exist ...
      if(flag == 0){
        System.out.println("Invoice number: " + myInvoices.get(i).getInvoiceNumber() + " does not exist in my invoices.");
      }
    }

  }//end of main.




  private static List<Invoice> getMyInvoiceList() {
    // Usually the data will be stored in the database,
    // however we are just returning a static list to simplify the problem.
    return Arrays.asList(
      new Invoice("100", 10),
      new Invoice("101", 13),
      new Invoice("102", 17),
      new Invoice("103", 19),
      new Invoice("104", 16),
      new Invoice("105", 11),
      new Invoice("106", 10),
      new Invoice("107", 19),
      new Invoice("109", 16),
      new Invoice("110", 19),
      new Invoice("111", 14),
      new Invoice("112", 10),
      new Invoice("113", 16),
      new Invoice("114", 11),
      new Invoice("115", 19),
      new Invoice("117", 15),
      new Invoice("119", 11),
      new Invoice("120", 12),
      new Invoice("121", 16),
      new Invoice("122", 18),
      new Invoice("123", 19),
      new Invoice("124", 14)
    );
  }
  
  private static List<Invoice> getAccountantsInvoiceList() {
    List<Invoice> invoices;

    // TODO: Read invoices from accountants_invoices.csv.
    // The file has a header row and a row for each invoice.

    //Open the csv file.
    Scanner in = new Scanner(new File("accountants_invoices.csv"));
    
    //Skip the first line (header)
    in.nextLine(); 

    //Use ArrayList since List is abstract.
    invoices = new ArrayList<Invoice>();

    while(in.hasNext())
    {
      //Line contains String and Int.
      String line = in.nextLine();
      //Split into a string array.
      String[] invoice = line.split(", ");

      //Add both parts (Number and Amount) of the invoice to the List.
      invoices.add(new Invoice(invoice[0], Integer.parseInt(invoice[1])));
    
    }

    return invoices;
  }


}
