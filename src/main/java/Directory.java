import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {

    private List<Entry> contents;

    public Directory(String name, Directory parent) {
        super(name, parent);
        if (parent != null)
            parent.addEntry(this);
        contents = new ArrayList<Entry>();
    }

    public int size() {
        int size = 0;
        for (Entry e : contents)
            size += e.size();
        return size;
    }

    private int numberOfFiles() {
        int count = 0;
        for (Entry e : contents) {
            if (e instanceof Directory) {
                count++; // Directory counts as a file
                Directory d = (Directory) e;
                count += d.numberOfFiles();
            } else if (e instanceof File)
                count++;
        }
        return count;
    }

    boolean deleteEntry(Entry entry) {
        return contents.remove(entry);
    }

    protected void addEntry(Entry entry) {// Entry can be a new directory or file
        contents.add(entry);
    }

    protected ArrayList<Entry> getContents() {
        return (ArrayList<Entry>) contents;
    }

    private void setContents(List<Entry> contents) {
        this.contents = contents;
    }

    protected Directory copy(String name, Directory parent) {
        Directory copy = new Directory(name, parent);
        copy.setContents(this.contents);
        return copy;
    }

    protected Directory move(String name, Directory parent) {
        Directory move = this.copy(name, parent);
        this.delete();
        return move;
    }

}
