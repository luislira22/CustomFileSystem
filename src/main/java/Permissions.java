public class Permissions {
    private boolean readable;
    private boolean writable;
    private boolean executable;

    Permissions(boolean readable, boolean writable, boolean executable) {
        this.readable = readable;
        this.writable = writable;
        this.executable = executable;
    }

    public void setReadable(boolean readable) {
        this.readable = readable;
    }

    public void setWritable(boolean writable) {
        this.writable = writable;
    }

    public void setExecutable(boolean executable) {
        this.executable = executable;
    }
}
