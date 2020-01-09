public abstract class Entry {

    private Directory parent;
    private long created;
    private long lastUpdated;
    private long lastAccessed;
    private String name;
    private boolean canRead;
    private boolean canWrite;
    private boolean canExecute;
    private Permissions permissions;


    public Entry(String name, Directory parent) {
        super();
        this.name = name;
        this.parent = parent;
        created = System.currentTimeMillis();
        lastUpdated = System.currentTimeMillis();
        lastAccessed = System.currentTimeMillis();
        this.permissions = new Permissions(canRead, canWrite, canExecute);

    }

    boolean delete() {
        return parent != null && parent.deleteEntry(this);
    }

    public abstract int size();

    public long getCreated() {
        return created;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public long getLastAccessed() {
        return lastAccessed;
    }

    public String getName() {
        return name;
    }

    public void changeName(String n) {
        name = n;
    }

    public Permissions getPermissions() {
        return permissions;
    }
}
