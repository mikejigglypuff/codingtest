public class Reserve {
    Human member;
    Book book;
    String contactInfo;

    Reserve(Human member, Book aBook, String contactInfo) {
        this.member = member;
        book = aBook;
        this.contactInfo = contactInfo;
        aBook.notifyReserved(this);
    }

    public String toString() {
        return "Reserve{" +
                "Contact Information =" + contactInfo +
                ", book=" + book.toString() +
                ", member=" + member.toString() +
                '}';
    }

}
