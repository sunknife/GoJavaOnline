package files;

public class Directory {
    private String name;
    private File[] files;
    private int fileIndex;
    public static final int FILES_LIMIT = 2;

    public Directory(String name) {
        this.name = name;
        this.files = new File[FILES_LIMIT];
        this.fileIndex = 0;
    }

    public void addFile(String name) throws OutOfFileLimitException {
        if (this.fileIndex == FILES_LIMIT) throw new OutOfFileLimitException();
        File newFile = new File(name);
        this.files[this.fileIndex] = newFile;
        this.fileIndex++;
    }

    public void deleteFile(File file) throws NoSuchFileException {
        boolean fileFound = false;
        for (File currentFile : this.files) {
            if (currentFile == file) {
                currentFile = null;
                fileFound = true;
            }
        }
        if (!fileFound) {
            throw new NoSuchFileException();
        }
    }

    public File getFile(int index) {
        try {
            return this.files[index];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[Error: ] There is no such element with index '" + index + "' in array!");
        }
        return null;

    }

    public static void main(String[] args) throws NoSuchFileRuntime, OutOfFileLimitRuntime {
        Directory folder = new Directory("GoJavaOnline");
        try {
            folder.addFile("Thebiggestnameintheuniverse");
            folder.addFile("Example");
            folder.addFile("NewFile");
        } catch (OutOfFileLimitException e) {
            System.out.println("[Error ]Directory file limit exceed");
            throw new OutOfFileLimitRuntime();
        }
        try {
            folder.deleteFile(new File("Example"));
        } catch (NoSuchFileException e) {
            System.out.println("[Error ] There is no such file in directory");
            throw new NoSuchFileRuntime();
        }
        File fileReciever = folder.getFile(45);
    }
}
