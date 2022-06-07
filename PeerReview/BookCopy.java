public class BookCopy {
    int id;
    Book book;
    Rent rent;

    BookCopy(Book book) {
        this.book = book;
        this.id = book.registration(this);
        this.rent = null;
    }

    public boolean isReserved() {
        return this.book.isReserved();
    }

    public boolean isRented() { return (this.rent != null); }

    public void notifyRented(Rent rent) {
        this.rent = rent;
    }

    public String toString() {
        return "Copy{id=" + this.id + ", book=" + this.book.toString() + "}";
    }

    public String returnBook() {
        this.rent.notifyReturnBook();
        this.rent = null;
        Reserve aReservation = this.book.getReservation();
        if(aReservation == null) {
            return null;
        }

        return aReservation.toString();      
    }
}
