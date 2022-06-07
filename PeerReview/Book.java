import java.util.ArrayList;

public class Book {
    String name;
    Boolean isReservedBook;
    ArrayList<BookCopy> copies;
    ArrayList<Reserve> reservations;

    Book(String name, Boolean reserved) {
        this.name = name;
        this.isReservedBook = reserved;
        this.copies = new ArrayList();
        this.reservations = new ArrayList<>();
    }

    public int registration(BookCopy copy) {
        if (!this.copies.contains(copy)) {
            this.copies.add(copy);
            return this.copies.size();
        } else {
            return -1;
        }
    }

    public Boolean isReservable() {
        if(isReserved()) return false;
        for(BookCopy copy: copies) {
            System.out.println(copy.toString());
            if(copy.isRented()) return false;
        }
        System.out.println("I am here");
        return true;
    }

    public String toString() {
        return "Book{name='" + this.name + "', isReservedBook=" + this.isReservedBook + "}";
    }

    public boolean isReserved() {
        return this.isReservedBook;
    }

    public void notifyReserved(Reserve reservation) {
        if (!this.reservations.contains(reservation)) {
            this.reservations.add(reservation);
        }
    }

    public Reserve getReservation() {
        if(this.reservations.size() != 0) {
            return this.reservations.remove(0);
        }
        return null;
    }
}
