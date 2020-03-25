//Description: Class that tests the Pair class
//Author: Michael Ly
//Date: 3/25/2020
//Version: 1.0

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    /**
     * Method that will get the size of all files in a directory that it has access to
     * @param directoryName
     * @return size of the files or 0
     */

    public static int getSize(String directoryName){
        File file = new File(directoryName); //initializing that the directory name is a file
        File[] fileList = file.listFiles(); //creating a list of files of the directory
        if(fileList == null){
            return 0; //if there is nothing in the list then return 0
        }
        for (int i = 0; i < fileList.length; i++) { //repeating the program to go through every file/directory inside of the initial directory
            if(fileList[i].isFile()){ //if they file/directory at index i is a file
                long temp = fileList[i].length(); //get the size of the file
                if (temp/1000000000>=1){ //converting to gigabytes if possible
                    temp = temp/1000000000;
                    System.out.println(temp + " Gigabytes"); //printing out the data
                }
                else if(temp/1000000>=1){ //converting to megabytes if possible
                    temp = temp/1000000;
                    System.out.println(temp + " Mbytes"); //printing out the data
                }
                else if (temp/1000>=1){ //converting to kilobytes if possible
                    temp = temp/1000;
                    System.out.println(temp + " Kbytes"); //printing out the data
                }
                else{
                    System.out.println(temp + " Bytes"); //printing out the data
                }
            }
            else if(fileList[i].isDirectory()){ //if the file/ directory at index i is a directory
                int recursivePath = getSize(fileList[i].getPath()); //creating a recursion point where it will check if the given directory has a file within it
                if(recursivePath!=0){
                    return recursivePath; //if it does have a file/directory in it call this method again
                }
            }
        }
        if(!(file.isDirectory() && file.isFile())) { //if the file/directory no longer has files/directories, then return one
            return 1;
        }
        else{
            return 0; //returning zero if this point is reached
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in); //implementing the scanner
        System.out.print("Enter a pathname: "); //asking for the directory/file
        String file = s.next();
        int i = getSize(file); //calling the get size method
        if (i==0){
            System.out.println(0); //output if the given pathname is not a file or directory
        }

        ArrayList<Pair<String, Integer>> listTree = new ArrayList<>(5); //initializing the array of pairs for the tree
        Pair<String, Integer> p;
        p = new Pair<String, Integer>("Leather Leaf Acacia", 12); //filling in data
        listTree.add(p);
        p = new Pair<String, Integer>("Key Lime", 24); //filling in data
        listTree.add(p);
        p = new Pair<String, Integer>("American Hazelnut", 24); //filling in data
        listTree.add(p);
        p = new Pair<String, Integer>("Flowering Maple", 24); //filling in data
        listTree.add(p);
        p = new Pair<String, Integer>("Silverberry", 36); //filling in data
        listTree.add(p);

        ArrayList<Pair<Integer, Double>> listStudents = new ArrayList<>(5); //initializing the array of pairs for the students
        Pair<Integer, Double> t;
        t = new Pair<Integer, Double>(12345, 3.96); //filling in data
        listStudents.add(t);
        t = new Pair<Integer, Double>(54321, 2.25); //filling in data
        listStudents.add(t);
        t = new Pair<Integer, Double>(12453, 3.50); //filling in data
        listStudents.add(t);
        t = new Pair<Integer, Double>(53421, 2.83); //filling in data
        listStudents.add(t);
        t = new Pair<Integer, Double>(51234, 1.25); //filling in data
        listStudents.add(t);

        int operation = 0; //initializing the switch variable
        do{
            printMenu(); //printing out a menu
            operation = s.nextInt(); //getting their desired operation
            switch(operation){
                case 1: //case one is the search function for the tree list
                    System.out.println("What is the name of the tree?");
                    String key = s.next(); //name of tree input
                    int index = search(listTree, key); //finding the index of the key
                    if (index == -1){
                        System.out.println("Item not found!"); //message if not contained within the list
                    }
                    else{
                        System.out.println(listTree.get(index)); //data in that index
                    }
                    break;
                case 2: //case two is the search function for the tree list
                    System.out.println("What is the ID of the student?");
                    int key1 = s.nextInt(); //id of the student input
                    index = search(listStudents, key1); //searching for the index of the key
                    if (index == -1){
                        System.out.println("Item not found!"); //message if not contained within the list
                    }
                    else{
                        System.out.println(listTree.get(index)); //data in that index
                    }
                    break;
            }
        }while(operation!=3);
    }

    /**
     * Method that will take a list of type pair and try to fin the index of the key
     * @param list
     * @param key
     * @param <E1>
     * @param <E2>
     * @return index of key or -1
     */

    public static <E1, E2> int search(ArrayList<Pair<E1,E2>> list, E1 key){
        int index;
        if(list.contains(key)){
            index = list.indexOf(key);
            return index;
        }
        else{
            return -1;
        }
    }

    /**
     * Method that will print out a menu
     */

    public static void printMenu(){
        System.out.println("Select and Operation: ");
        System.out.println("1: Search for a tree");
        System.out.println("2: Search for a student");
        System.out.println("3: Quit");
    }
}
