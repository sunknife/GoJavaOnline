package files;

public class File {
    private static final int MAX_NAME_LENGTH = 20;
    String name;

    public File(String name) {
        try {
            this.setName(name);
        } catch (IllegalFileNameException e) {
            System.out.println("[Error: ]File name length too big!");
        }
    }

    private void setName(String name) throws IllegalFileNameException {
        // Number 20 is an example of magic number anti-pattern. Should be replaced by static constant variable
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalFileNameException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
