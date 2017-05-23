/**
 * Last Name: Zar
 * First Name: Ilan
 */
//import java.util.Iterator;
import java.util.Vector;
public class Library implements MaxTagValue {
    String       libraryName;
    Vector<Book> books;
    
    //ctr. that takes as param only the libraryName
    public Library(String libraryName) {
        if(libraryName != null){
        	this.libraryName = libraryName;
        	books = new Vector<Book>();
        }
    }
    //this method search all the books from a library
    //and returns an integer that is the maximum value tag
    public int findMaximumValueTag() {
        int maxElement = -100;
        for(int x = 0; x < books.size(); x++){
        	if(books.get(x).valueTag > maxElement){
        		maxElement = books.get(x).valueTag;
        	}
        }
        return maxElement;
    }
    
    //the method takes three params: a book and two dates
    //the method returns true if the book is available in this library
    //from requestData up to dueDate
    public boolean rentRequest(Book wanted, String requestDate, String dueDate) throws DateFormatException {
        try {
            Helper.checkDate(requestDate);
            Helper.checkDate(dueDate);
        } catch (DateFormatException e) {
            System.out.println(wanted + e.getMessage());
 
        }
        if(Helper.timeDifference(requestDate, dueDate) >= 0.0){
        	
        	return true;
        }else
        return false;
    }
}

