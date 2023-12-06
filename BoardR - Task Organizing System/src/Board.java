import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final List<BoardItem> items = new ArrayList<>();
    private Board() {
    }
    public static void addItem(BoardItem item) {
        items.add(item);
    }

    public static List<BoardItem> getItems() {
        return items;
    }
}