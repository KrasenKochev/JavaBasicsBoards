import java.time.LocalDate;
public class BoardItem {
    public String title;
    public LocalDate dueDate;
    public Status status;

    public BoardItem(String title, LocalDate dueDate) {
        if (title == null || title.length() < 5 || title.length() > 30) {
            throw new IllegalArgumentException ("Invalid title");
        }
        if (dueDate == null || dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.title = title;
        this.dueDate = dueDate;
        this.status = Status.Open;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public Status getStatus() {
        return this.status;
    }

    public void revertStatus() {
        // Check current status and revert if possible
        switch (status) {
            case Todo:
                status = Status.Open;
                break;
            case InProgress:
                status = Status.Todo;
                break;
            case Done:
                status = Status.InProgress;
                break;
            case Verified:
                status = Status.Done;
                break;
        }
    }
    public void advanceStatus() {
        // Check current status and advance if possible
        switch (status) {
            case Open:
                status = Status.Todo;
                break;
            case Todo:
                status = Status.InProgress;
                break;
            case InProgress:
                status = Status.Done;
                break;
            case Done:
                status = Status.Verified;
                break;
        }
    }
    public String viewInfo() {
        return String.format("'%s', [%s | %s]", title, status, dueDate);
    }
}