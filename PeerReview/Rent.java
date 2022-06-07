import java.time.LocalDate;

public class Rent {
    private static final long rentalDays = 15;

    LocalDate fromDate;
    LocalDate toDate;
    BookCopy bookCopy;
    Human member;

    Rent(Human member, BookCopy bookCopy) {
        this.member = member;
        this.bookCopy = bookCopy;
        fromDate = LocalDate.now();
        toDate = fromDate.plusDays(Rent.rentalDays);
        bookCopy.notifyRented(this);
    }

    Rent(Human member, BookCopy bookCopy, LocalDate startDate) {
        this.member = member;
        this.bookCopy = bookCopy;
        fromDate = startDate;
        toDate = fromDate.plusDays(Rent.rentalDays);
        bookCopy.notifyRented(this);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", bookCopy=" + bookCopy.toString() +
                ", member=" + member.toString() +
                '}';
    }

    public void notifyReturnBook() {
        this.member.notifyReturn(this.bookCopy);
        System.gc();
    }

    public BookCopy getBookCopy() {
        return this.bookCopy;
    }
}
