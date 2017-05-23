/**
 * Last Name: Zar
 * First Name: Ilan
 */
public class Main {
    public static void main(String[] args) {
        /* TASK 1 - build libraries from files - at least two libraries */
        System.out.println("\n\n *" + " TASK 1 " + "*");
        Libraries ls = new Libraries(8);
		ls.buildLibraryFromFile("NewnhamLibrary", "NewnhamLibrary.txt");
		ls.buildLibraryFromFile("YorkLibrary", "YorkLibrary.txt");
		ls.buildLibraryFromFile("FirstLibrary", "FirstLibrary.txt");
		ls.buildLibraryFromFile("SecondLibrary", "SecondLibrary.txt");
		ls.buildLibraryFromFile("ThirdLibrary", "ThirdLibrary.txt");
		ls.buildLibraryFromFile("FourthLibrary", "FourthLibrary.txt");
		ls.buildLibraryFromFile("FifthLibrary", "FifthLibrary.txt");
		ls.buildLibraryFromFile("SixthLibrary", "SixthLibrary.txt");
		for(int x = 0; x < ls.numberOfLibraries; x++){
			System.out.println("Library = " + ls.libraries[x].libraryName + "\n");
			System.out.println("[\n");
			for(int k = 0; k < ls.libraries[x].books.size(); k++){
				System.out.println(ls.libraries[x].books.get(k).toString());
			}
			System.out.println("]\n");
		}
       
        /* TASK 2 - ask for a book that is not in any library inventory */
        System.out.println("\n\n *" + " TASK 2 " + "*");
        Book book = new Book("C++", 20);
        Library library = ls.isThereBookInLibraries(book);
        if (library == null)
            System.out.println(Helper.printNonexistent(book));
         /* TASK 3 - ask for a book that is in a library inventory
         *  issue a rent request and print the bookEssentials of Database Management
         *  issue the same rent request and print the book
         *  return the book
         *  issue the rent request with new dates and print the book
         */
        System.out.println("\n\n *" + " TASK 3 " + "*");
		Book book3 = new Book("Database Management Systems", 53);
		try{
			Library library3 = ls.rentBookAvailable(book3, "01/01/2017", "01/05/2017");
			
			if(library3 != null){
				book3.library = library3;
				Book temp = ls.bookLocation(book3, library3);
				if(library3.rentRequest(book3, "01/01/2017", "01/05/2017") == true){
					temp.rentBook("01/01/2017", "01/05/2017", library3);
					System.out.println(temp.toString());
				}
				else{
					System.out.println(book3.toString());
				}
			}
		}
		catch(DateFormatException e){
			e.getMessage();
		} catch (RentPeriodException e) {
			e.getMessage();
		}
		
		Book book4 = new Book("Database Management Systems", 53);
		try{
			Library library4 = ls.rentBookAvailable(book4, "01/01/2017", "01/05/2017");
			if(library4 != null){
				book4.library = library4;
				Book temp = ls.bookLocation(book4, library4);
				if(library4.rentRequest(book4, "01/01/2017", "01/05/2017") == true){
					temp.rentBook("01/01/2017", "01/05/2017", library4);
				}
				System.out.println(temp.toString());
			}
			else{
				System.out.println(book4.toString());
			}
			
		}
		catch(DateFormatException e){
			e.getMessage();
		} catch (RentPeriodException e) {
			e.getMessage();
		}
		Library library5 = ls.isThereBookInLibraries(book3);
		book3.returnBook(library5);
		Book temp = ls.bookLocation(book3, library5);
		temp.setRs(book3.rs);
		
		try{
			Library library3 = ls.rentBookAvailable(book3, "01/06/2017", "01/12/2017");
			
			if(library3 != null){
				book3.library = library3;
				Book temp5 = ls.bookLocation(book3, library3);
				if(library3.rentRequest(book3, "01/06/2017", "01/12/2017") == true){
					temp5.rentBook("01/06/2017", "01/12/2017", library3);
					System.out.println(temp5.toString());
				}
				else{
					System.out.println(book3.toString());
				}
			}
		}
		catch(DateFormatException e){
			e.getMessage();
		} catch (RentPeriodException e) {
			e.getMessage();
		}
         /* TASK 4 - ask for the same book in all libraries
         * if you can find a library, rent the book from that library
         */
        System.out.println("\n\n *" + " TASK 4 " + "*");
        Book bookinquire4 = new Book("Essentials of Database Management",65);
        Library inquiretemp4 = ls.isThereBookInLibraries(bookinquire4);
        Library templib = null;
        Book bookinquiretemp4;  
        Library[] templibraries4 = ls.bookLibrarys(bookinquire4);
        int counter = 1;
        System.out.println("Desired Book: " + bookinquire4.toString());
        System.out.println(bookinquire4.bookName + " belongs to the following libraries :\n");
        for(int x = 0; x < templibraries4.length; x++){
        	bookinquiretemp4 = ls.bookLocation(bookinquire4, templibraries4[x]);
        	if(templib == templibraries4[x]){
        		counter++;
        	}
        	
        	if(templib == templibraries4[x]){
        		System.out.println(templibraries4[x].libraryName + " - " + counter + " Copy\n");
        	}
        	else if(counter == 2){
        		System.out.println(templibraries4[x].libraryName + " - 1 Copy\n");
        	}
        	templib = templibraries4[x];
        	
        	
        }
        for(int x = 0; x < templibraries4.length; x++){
        	bookinquiretemp4 = ls.bookLocation(bookinquire4, templibraries4[x]);
        	System.out.println(templibraries4[x].libraryName);
        	System.out.println(" Available? :");
            if(bookinquiretemp4.isRented(inquiretemp4) == false){
            	System.out.println(" Yes.\n");
            }
            else{
            	System.out.println(" No. ");
            	System.out.println(" Overdue? :");
            	try {
    				if(bookinquiretemp4.isBookOverdue() == true){
    					System.out.println(" Yes.");
    				}
    				else{
    					System.out.println(" No. " + bookinquiretemp4.availableDate(inquiretemp4) + "\n");
    				}
    			} catch (DateFormatException e) {
    				e.getMessage();
    			}
            }
        }
        
        
        /* TASK 5 - calculate maximum value tag for each library */
        System.out.println("\n\n *" + " TASK 5 " + "*");
        //Assumption is made to include tags of rented books, as it does not say otherwise in the instructions.
        for(int x = 0; x < ls.numberOfLibraries; x++){
        	System.out.println(ls.libraries[x].libraryName + " : Max Tag Value = " + ls.libraries[x].findMaximumValueTag() + "\n");
        }
        
         /* TASK 6 - inquire about a book - it is available? when does it become available, etc. */
        System.out.println("\n\n *" + " TASK 6 " + "*");
        //Testing with a book that is available and a book that isn't.
        //Book that is available
        Book bookinquire = new Book("Introductory Statistics with R",-95);
        Library inquiretemp = ls.isThereBookInLibraries(bookinquire);
        Book bookinquiretemp;  
        Library[] templibraries = ls.bookLibrarys(bookinquire);
        
        for(int x = 0; x < templibraries.length; x++){
        	bookinquiretemp = ls.bookLocation(bookinquire, templibraries[x]);
        	System.out.println("Desired Book: " + bookinquire.toString());
        	System.out.println(bookinquiretemp.bookName + " exists in library :");
        	System.out.println(templibraries[x].libraryName);
        	System.out.println(" Available? :");
            if(bookinquiretemp.isRented(inquiretemp) == false){
            	System.out.println(" Yes.\n");
            }
            else{
            	System.out.println(" No. ");
            	System.out.println(" Overdue? :");
            	try {
    				if(bookinquiretemp.isBookOverdue() == true){
    					System.out.println(" Yes.");
    				}
    				else{
    					System.out.println(" No. " + bookinquiretemp.availableDate(inquiretemp) + "\n");
    				}
    			} catch (DateFormatException e) {
    				e.getMessage();
    			}
            }
        }
        
        
        //Book that isn't available everywhere
        Book bookinquire2 = new Book("Database Management Systems", 53);
        Library inquiretemp2 = ls.isThereBookInLibraries(bookinquire2);
        Book bookinquiretemp2;
        Library[] templibraries2 = ls.bookLibrarys(bookinquire2);
        for(int x = 0; x < templibraries2.length; x++){
        	System.out.println("Desired Book: " + bookinquire2.toString());
        	bookinquiretemp2 = ls.bookLocation(bookinquire2, templibraries2[x]);
        	System.out.println(bookinquiretemp2.bookName + " exists in library :");
        	System.out.println(templibraries2[x].libraryName);
        	
            
        	System.out.println(" Available? :");
            if(bookinquiretemp2.isRented(inquiretemp2) == false){
            	System.out.println(" Yes.\n");
            }
            else{
            	System.out.println(" No. ");
            	System.out.println(" Overdue? :");
            	try {
    				if(bookinquiretemp2.isBookOverdue() == true){
    					System.out.println(" Yes.");
    				}
    				else{
    					System.out.println(" No. " + bookinquiretemp2.availableDate(inquiretemp2) + "\n");
    				}
    			} catch (DateFormatException e) {
    				e.getMessage();
    			}
            }
        }
        /* TASK 7 */
        System.out.println("\n\n *" + " TASK 7 " + "*");
        Book book7 = new Book("Almost done",26);
        Library[] templibraries7 = ls.bookLibrarys(book7);
        Book actualbook1 = ls.bookLocation(book7, templibraries7[0]);
        Book actualbook2 = ls.bookLocation(book7, templibraries7[1]);
        
        System.out.println("Renting the books first.");
        try {
			actualbook1.rentBook("05/05/2018", "05/10/2032", templibraries7[0]);
		} catch (DateFormatException e) {
			e.getMessage();
		} catch (RentPeriodException e) {
			e.getMessage();
		}
        try {
			actualbook2.rentBook("05/05/2018", "05/09/2019", templibraries7[1]);
		} catch (DateFormatException e) {
			e.getMessage();
		} catch (RentPeriodException e) {
			e.getMessage();
		}
        System.out.println("Desired Book : " + book7.toString());
        Long difference = 0L;
        try {
			difference = Helper.timeDifference(actualbook1.getDate(), actualbook2.getDate());
		} catch (DateFormatException e) {
	
			e.getMessage();
		}
        System.out.println(actualbook1.toString());
        System.out.println(actualbook2.toString());
        System.out.println("Library that holds book with closest date to desired date : ");
        if(difference >= 0.0){
        	System.out.println(actualbook1.library.libraryName);
        }
        else{
        	System.out.println(actualbook2.library.libraryName);
        }
        
    }
}

