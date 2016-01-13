package files;

public class File {
    String name;
    public File(String name) {
        try {
            this.setName(name);
        } catch (IllegalFileNameException e) {
            System.out.println("[Error: ]File name length too big!");
        }
    }

    private void setName(String name) throws IllegalFileNameException {
        // Number 20 is an example of magic number anti-patern. Should be replaced by static constant variable
        if (name.length()>20) {
            throw new IllegalFileNameException();
        }
        this.name=name;
    }
}
