public class File extends Entry {
    private String content;
    private int size;

    public File(String name, Directory parent, int size) {
        super(name, parent);
        if (parent != null)
            parent.addEntry(this);
        this.size = size;
    }

    public int size() {
        return size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
