package files;

public class Directory {
    String name;
    File[] files;

    public Directory(String name){
        this.name=name;
        this.files=new File[10];
    }

    public void addFile(String name){
        File newFile = new File(name);
        this.files[0]=newFile;
    }
    public void deleteFile(File file){
    }

    public File getFile(int index){
        try {
            return this.files[index];
        } catch (IndexOutOfBoundsException e){
            System.out.println("[Error: ] There is no such element with index '"+index+"' in array!");
        }
        return null;

    }

    public static void main(String[] args) {
        Directory folder = new Directory("GoJavaOnline");
        folder.addFile("Thebiggestnameintheuniverse");
        File fileReciever = folder.getFile(45);
    }
}
