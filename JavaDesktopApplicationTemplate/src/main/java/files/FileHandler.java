package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

        public void create(String name, String dir) {
                try {
                        File newFile = new File(dir + name);
                        if (newFile.createNewFile()) {
                                System.out.println("File created: " + newFile.getName());
                        } else {
                                System.out.println("File already exists.");
                        }
                } catch (IOException e) {
                        System.out.println("An error occurred.");
                }
        }

        public void write(String name, String dir, String text) {
                try {
                        FileWriter writer = new FileWriter(dir + name);
                        writer.write(text);
                        writer.close();
                        System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                        System.out.println("An error occurred.");
                }
        }

        public String read(String name, String dir) {
                BufferedReader reader;
                String data = "";

                try {
                        reader = new BufferedReader(new FileReader(dir + name));
                        String line = reader.readLine();

                        while (line != null) {
                                data  = data + line + "\n";
                                line = reader.readLine();
                        }

                        reader.close();
                        return data.trim();
                } catch (IOException e) {
                }
                return null;
        }

        public File delete(String name, String dir) {
                File file = new File(dir + name);
                if (file.delete()) {
                        System.out.println("Deleted the file: " + file.getName());
                        return file;
                } else {
                        System.out.println("Failed to delete the file.");
                }
                return null;
        }
}