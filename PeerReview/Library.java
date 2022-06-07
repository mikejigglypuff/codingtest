import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList();
    ArrayList<Human> memberList = new ArrayList();

    Library() {
    }

    public Boolean addBook(Book book) {
        if (!this.books.contains(book)) {
            this.books.add(book);
            return true;
        } else {
            return false;
        }
    }

    public Boolean enrollMember(Human member) {
        if (!this.memberList.contains(member)) {
            this.memberList.add(member);
            member.notifyMembership(this);
            return true;
        } else {
            return false;
        }
    }
}
