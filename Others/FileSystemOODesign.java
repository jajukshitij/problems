import java.util.ArrayList;
import java.util.List;

class FileSystemItem {
    private String name;

    public FileSystemItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getSize();
}

class File extends FileSystemItem {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}

class Folder extends FileSystemItem {
    private List<FileSystemItem> items;

    public Folder(String name) {
        super(name);
        items = new ArrayList<>();
    }

    public void addItem(FileSystemItem item) {
        items.add(item);
    }

    @Override
    public int getSize() {
        int size = 0;
        for (FileSystemItem item : items) {
            size += item.getSize();
        }
        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        // Task 1 - Define hierarchy with folders and files
        File file1 = new File("File1", 5);

        Folder folder1 = new Folder("Folder1");
        folder1.addItem(file1);

        Folder folder2 = new Folder("Folder2");
        File file2 = new File("File2", 2);
        File file3 = new File("File3", 3);
        folder2.addItem(file2);
        folder2.addItem(file3);

        folder1.addItem(folder2);

        // Task 2 - Instantiate a sample file system

        // Task 3 - Display the size of root folder and one file
        System.out.println("Size of root folder (" + folder1.getName() + "): " + folder1.getSize() + " bytes");
        System.out.println("Size of " + file2.getName() + ": " + file2.getSize() + " bytes");
    }
}
