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

    protected File copy(String name, Directory parent) {
        File copy = new File(name, parent, this.size);
        copy.setContent(this.content);
        return copy;
    }

    protected File move(String name, Directory parent) {
        File move = this.copy(name, parent);
        this.delete();
        return move;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
