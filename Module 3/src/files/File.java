package files;

public class File {
    String name;
    public File(String name) {
        if (name.length()>20) try {
            throw new IllegalFileNameException();
        } catch (IllegalFileNameException e) {
            System.out.println("[Error: ]File name length too big!");
        }
        this.name=name;
    }
}
