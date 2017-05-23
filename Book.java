/**
 * Last Name: Zar
 * First Name: Ilan
 */
class Book {
    String       bookName;    // the book name
    int          valueTag;    // an integer between -100 and 100
    Library      library;     // the library having this book it its 
inventory
    RentSettings rs;          // rent settings
    public Book(String bookName, int valueTag) {
       this.bookName = bookName;
       this.valueTag = valueTag;
	   library = null;
	   try {
		rs = new RentSettings();
	   } catch (DateFormatException e) {
		
		e.getMessage();
	   }
    }
    // set the rent dates; if dates are not valid catch 
DateFormatException and return false,
    // if rentDate > dueDate catch RentPeriodException and return false
    // if one the exceptions occur there is no RentSettings object
    public boolean rentBook(String rentDate, String dueDate, Library 
library) throws DateFormatException, RentPeriodException {
    	if(this.library == library){
    		
        	try{
        		Helper.checkDate(rentDate);
        		Helper.checkDate(dueDate);
        	}
        	catch(DateFormatException e){
        		e.getMessage();
        	}
        	try{
        		if(Helper.timeDifference(dueDate, rentDate) >= 0){
        			throw new RentPeriodException();
        		}
        	}catch(RentPeriodException e){
        		e.getMessage();
        	}   
        	rs = new RentSettings(rentDate, dueDate, library);
        	rs.borrowed = true;
        	System.out.println("Rent Request: Successfully rented 
book!");
        	return true;
        }
        return false;
    }
    // destroy the RentSettings object for this book
    public void returnBook(Library library) {
    	if(this.library == library){
    		rs.borrowed = false;
    		System.out.println("Return Request: Book has been 
returned!\n");
    	}
    }
    // return the date when this book is available
    public String availableDate(Library library) {
       return Helper.printAvailable(this, rs.rentDate, library);
    }
    // returns true if the current date is greater than the due date
    public boolean isBookOverdue() throws DateFormatException {
	   try{
		Long difference = 
Helper.timeDifference(Helper.getCurrentDate(), rs.dueDate);
		if(difference > 0.0){
    	   return true;
		 }
	   }catch(DateFormatException e){
			e.getMessage();
	   }
       return false;
    }
    // returns true is the book is rented
    public boolean isRented(Library l) {
    	if(library == l && rs.borrowed == true){
    		return true;
    	}
       return false;
    }
    //getter for dueDate from rs object
    public String getDate(){
    	return rs.dueDate;
    }
    // getter for RentSettings rs object
    public RentSettings getRs() {
       return rs;
    }
    // setter for RentSettings rs object
    public void setRs(RentSettings rs) {
       this.rs = rs;
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (library == null) {
			if (other.library != null)
				return false;
		} else if (!library.equals(other.library))
			return false;
		if (rs == null) {
			if (other.rs != null)
				return false;
		} else if (!rs.equals(other.rs))
			return false;
		if (valueTag != other.valueTag)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookName == null) ? 0 : 
bookName.hashCode());
		result = prime * result + ((library == null) ? 0 : 
library.hashCode());
		result = prime * result + ((rs == null) ? 0 : 
rs.hashCode());
		result = prime * result + valueTag;
		return result;
	}
	//do this in eclipse
    @Override
    public String toString() {
        String s = "";
        if(this.library == null){
        	s = bookName();
        }
        else{
        	s = "(" + bookName + ", " + valueTag + " => " + 
library.libraryName +")" + rs.toString();
        }
        return s;
    }
    public String bookName() {
        return "(" + bookName + ", " + valueTag + ")\n";   
    }
    
    //inner class that defines the rented period and book availability
    private class RentSettings {
        private String rentDate;          // date when the item is 
requested
        private String dueDate;           // date when the item must be 
returned
        private boolean borrowed = false; // true if the item is rented
        //default ctr
        private RentSettings() throws DateFormatException {
        //Generic default values set and checked for dates.
        //Logic assumed since no specific instructions that dates are set 
to current date.
        	try{
        		rentDate = Helper.getCurrentDate();
        		dueDate = Helper.getCurrentDate();
        		Helper.checkDate(rentDate);
        		Helper.checkDate(dueDate);
        	}catch(DateFormatException e){
        		e.getMessage();
        	}
        }
        // private ctr must throw DateFormatException and 
RentPeriodException
        private RentSettings(String rentDate, String dueDate, Library 
library)
                throws DateFormatException, RentPeriodException {
        	if(library != null){
        		try{
        			Helper.checkDate(rentDate);
        			Helper.checkDate(dueDate);
        		}catch(DateFormatException e){
        			e.getMessage();
        		}
        		try{
            		if(Helper.timeDifference(dueDate, rentDate) >= 0){
            			throw new RentPeriodException();
            		}
        		}catch(RentPeriodException e){
        			e.getMessage();
        		}
        		this.rentDate = rentDate;
        		this.dueDate = dueDate;
            }
        }
        @Override
        public String toString() {
            return " RentSettings (" + rentDate + ", " + dueDate + ", " + 
library.libraryName + ", " + borrowed + ")\n";
        }
    }
}

