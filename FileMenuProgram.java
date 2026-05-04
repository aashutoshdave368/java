import java.io.*;
import java.util.Scanner;

public class FileMenuProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- File Menu ---");
            System.out.println("1. Create File");
            System.out.println("2. Write File");
            System.out.println("3. Read File");
            System.out.println("4. Copy File");
            System.out.println("5. Delete File");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                //  1. Create File
                case 1:
                    try {
                        File file = new File("source.txt");
                        if (file.createNewFile()) {
                            System.out.println("File created.");
                        } else {
                            System.out.println("File already exists.");
                        }
                    } catch (IOException e) {
                        System.out.println("Error creating file.");
                    }
                    break;

                // 2. Write File
                case 2:
                    try {
                        FileWriter fw = new FileWriter("source.txt" , true);
                        System.out.print("Enter data: ");
                        String data = sc.nextLine();
                        fw.write(data);
                        fw.close();
                        System.out.println("Data written.");
                    } catch (IOException e) {
                        System.out.println("Error writing file.");
                    }
                    break;

                //  3. Read File
                case 3:
                    try {
                        File file = new File("source.txt");
                        Scanner reader = new Scanner(file);

                        System.out.println("File Content:");
                        while (reader.hasNextLine()) {
                            System.out.println(reader.nextLine());
                        }

                        reader.close();
                    } catch (Exception e) {
                        System.out.println("Error reading file.");
                    }
                    break;

                //  4. Copy File
                case 4:
                    try {
                        FileReader fr = new FileReader("source.txt");
                        FileWriter fw = new FileWriter("destination.txt");

                        int ch;
                        while ((ch = fr.read()) != -1)//read() one character at a time 
                             //-1 when end of file is reached
                            {
                            fw.write(ch);
                        }

                        fr.close();
                        fw.close();

                        System.out.println("File copied successfully.");
                    } catch (IOException e) {
                        System.out.println("Error copying file.");
                    }
                    break;

                //  5. Delete File
                case 5:
                    File file = new File("source.txt");
                    if (file.delete()) {
                        System.out.println("File deleted.");
                    } else {
                        System.out.println("File not found.");
                    }
                    break;

                //  Exit
                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}