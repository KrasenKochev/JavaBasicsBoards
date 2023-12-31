import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
        item.advanceStatus();
        BoardItem anotherItem = new BoardItem("Encrypt user data", LocalDate.now().plusDays(10));

        Board.getItems().add(item);
        Board.getItems().add(anotherItem);

        for (BoardItem boardItem : Board.getItems()) {
            boardItem.advanceStatus();
        }

        for (BoardItem boardItem : Board.getItems()) {
            System.out.println(boardItem.viewInfo());
        }
    }
}
