/**
 * Last Name: Zar
 * First Name: Ilan
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
public class Libraries {
    public Library[] libraries;        // a collection of libraries of type array
    public int numberOfLibraries;      // number of libraries in collection
    //the method takes two String params
    //it reads the file with fileName and creates an object of type Library
    //where the Library has the name defined by the string libraryName
    public Libraries(int x) {
		libraries = new Library[x];
		numberOfLibraries = 0;
    }
    public Library buildLibraryFromFile(String libraryName, String fileName) {
        Library library = new Library(libraryName);
       
        String path = System.getProperty("user.dir");
        Book book = null;
        String s;
        
         try (BufferedReader br = new BufferedReader(new FileReader("./Root/" + fileName))) {
        // if you run locally on your environment use: new FileReader(path + "/src/" + fileName)
        	 //("./Root/" + fileName)
        	 
            while ((s = br.readLine()) != null) {
            	String[] tok = s.split(",");
            	try{
            		String name = new String(tok[0]);
            		Integer tagv = new Integer(tok[1]);
            		book = new Book(name, tagv);
            		library.books.add(book);
					book.library = library;
            	}catch(Exception e){
            		System.out.println("This book isn't a valid entry");
            	}
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		libraries[numberOfLibraries] = library;
		numberOfLibraries++;
        return library;
    }
    //the method returns the first library where the book is found
    //this method checks only if the book is part of the library inventory
    public Library isThereBookInLibraries(Book book) {
    	Library temp = null;
		for(int x = 0; x < numberOfLibraries; x++){
			temp = libraries[x];
			for(int k = 0; k < temp.books.size(); k++)
    		if(book.bookName.equals(temp.books.get(k).bookName)){
    			
				return libraries[x];
			} 
		}
       return null;
    }
    //the method takes three params: a book and two dates that defines the desire
    //rented period. The method returns the first library where the book
    //is available and can be rented
    public Library rentBookAvailable(Book book, String requestDate, String dueDate) {
		try{
			isThereBookInLibraries(book);
		}catch(Exception e){
			System.out.println("Book does not exist in a Library!");
		}
		Library foundLibrary = null;
		for(int x = 0; x < numberOfLibraries; x++){
			foundLibrary = libraries[x];
			for(int k = 0; k < foundLibrary.books.size(); k++){
    		if(book.bookName.equals(foundLibrary.books.get(k).bookName) && book.valueTag == foundLibrary.books.get(k).valueTag && foundLibrary.books.get(k).isRented(foundLibrary) == false){
				
    			return foundLibrary;
			} 
    		if(book.bookName.equals(foundLibrary.books.get(k).bookName) && book.valueTag == foundLibrary.books.get(k).valueTag && foundLibrary.books.get(k).isRented(foundLibrary) == true){
				System.out.println("Rent Request: Book is currently rented!");
			} 
		}
        
	}
		foundLibrary = null;
        return foundLibrary;
    }
    
    public Book bookLocation(Book book, Library library){
    	for(int x = 0; x < library.books.size(); x++){
    		if(book.bookName.equals(library.books.get(x).bookName)){
    			return library.books.get(x);
    		}
    	}
    	return null;
    }
    
    public Library[] bookLibrarys(Book book){
    	Library[] templibrarys;
    	Library foundLibrary = null;
    	int counter = 0;
    	int counter2 = 0;
    	for(int k = 0; k < numberOfLibraries; k++){
    		foundLibrary = libraries[k];
    		for(int x = 0; x < foundLibrary.books.size(); x++){
    			if(book.bookName.equals(foundLibrary.books.get(x).bookName)){
    				counter++;
    			}
    		}
    	}
    	templibrarys = new Library[counter];
    	for(int k = 0; k < numberOfLibraries; k++){
    		foundLibrary = libraries[k];
    		for(int x = 0; x < foundLibrary.books.size(); x++){
    			if(book.bookName.equals(foundLibrary.books.get(x).bookName)){
    				templibrarys[counter2] = foundLibrary;
    				counter2++;
    			}
    		}
    	}
    	return templibrarys;
    }
}

