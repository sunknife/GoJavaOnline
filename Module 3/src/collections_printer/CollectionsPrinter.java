package collections_printer;


import files.AudioFile;
import files.File;
import files.ImageFile;
import files.TextFile;
import flowers.Flower;
import flowers.FlowerType;
import flowers.Rose;
import instruments.MusicalInstrument;

import java.util.*;

enum fileTypes{Audio,Image,Text,General}

public class CollectionsPrinter {
    private String[] fileColumnNames = {"Name", "Type"};
    private int[] fileColumnSizes =new int[fileColumnNames.length];
    private String[] flowerColumnNames = {"Name", "Type"};
    private int[] flowerColumnSizes= new int[flowerColumnNames.length];
    private String[] instrumentColumnNames = {"Name"};
    private int[] instrumentColumnSizes= new int[instrumentColumnNames.length];
    private int mapIndex=0;

    public Integer getMapIndex(){
        return mapIndex++;
    }

    public void printFileCollection(Collection<File> fileList){
        fileTableInitialize(fileList);
        printFileTableHead();

        for (File file : fileList){
            System.out.print("| ");
            System.out.print(file.getName());
            printSpaces(fileColumnSizes[0], file.getName().length());
            System.out.print(" | ");
            if (file instanceof ImageFile){
                System.out.print(fileTypes.Image);
                printSpaces(fileColumnSizes[1],fileTypes.Image.toString().length());
            } else if (file instanceof TextFile){
                System.out.print(fileTypes.Text);
                printSpaces(fileColumnSizes[1],fileTypes.Text.toString().length());
            } else if (file instanceof AudioFile){
                System.out.print(fileTypes.Audio);
                printSpaces(fileColumnSizes[1],fileTypes.Audio.toString().length());
            } else {
                System.out.print(fileTypes.General);
                printSpaces(fileColumnSizes[1],fileTypes.General.toString().length());
            }
            System.out.print(" | ");

            System.out.println();
        }

    }

    private void printFileTableHead() {
        System.out.println("  Files list:");
        for (int i = 0; i< fileColumnNames.length; i++) {
            System.out.print("| "+ fileColumnNames[i]);
            printSpaces(fileColumnSizes[i], fileColumnNames[i].length());
            System.out.print(" ");
        }
        System.out.println("|");
    }

    private void fileTableInitialize(Collection<File> fileList) {

        int maxFileNameLength=0;
        for (File file : fileList){
            if (file.getName().length()>maxFileNameLength) {
                maxFileNameLength=file.getName().length();
            }
        }
        if (maxFileNameLength< fileColumnNames[0].length()){
            fileColumnSizes[0]= fileColumnNames[0].length();
        }   else {
            fileColumnSizes[0]=maxFileNameLength;
        }

        int maxFileTypeLength=0;
        if (fileTypes.Audio.toString().length()>maxFileTypeLength){
            maxFileTypeLength=fileTypes.Audio.toString().length();
        }
        if (fileTypes.Image.toString().length()>maxFileTypeLength){
            maxFileTypeLength=fileTypes.Image.toString().length();
        }
        if (fileTypes.Text.toString().length()>maxFileTypeLength){
            maxFileTypeLength=fileTypes.Text.toString().length();
        }if (fileTypes.General.toString().length()>maxFileTypeLength){
            maxFileTypeLength=fileTypes.General.toString().length();
        }
        if (maxFileTypeLength< fileColumnNames[1].length()){
            fileColumnSizes[1]= fileColumnNames[1].length();
        }   else {
            fileColumnSizes[1]=maxFileTypeLength;
        }
    }

    private void printSpaces(int maxFileNameLength, int indent) {
        for (int i=0; i<maxFileNameLength-indent; i++){
            System.out.print(" ");
        }
    }

    public void printFlowerCollection(Collection<Flower> flowerList){
        flowerTableInitialize(flowerList);
        printFlowerTableHead();

        for (Flower flower : flowerList){
            System.out.print("| ");
            System.out.print(flower.getName());
            printSpaces(flowerColumnSizes[0], flower.getName().length());
            System.out.print(" | ");
            if (flower.getType()== FlowerType.Astra){
                System.out.print(FlowerType.Astra);
                printSpaces(flowerColumnSizes[1],flower.getType().toString().length());
            } else if (flower.getType()==FlowerType.Chamomile){
                System.out.print(FlowerType.Chamomile);
                printSpaces(flowerColumnSizes[1],flower.getType().toString().length());
            } else if (flower.getType()==FlowerType.Rose){
                System.out.print(FlowerType.Rose);
                printSpaces(flowerColumnSizes[1],flower.getType().toString().length());
            } else if (flower.getType()==FlowerType.Tulip){
                System.out.print(FlowerType.Tulip);
                printSpaces(flowerColumnSizes[1],flower.getType().toString().length());
            }else {
                System.out.print(FlowerType.Unknown);
                printSpaces(flowerColumnSizes[1],flower.getType().toString().length());
            }
            System.out.print(" | ");

            System.out.println();
        }


    }

    private void printFlowerTableHead() {
        System.out.println("  Flowers list:");
        for (int i = 0; i< flowerColumnNames.length; i++) {
            System.out.print("| "+ flowerColumnNames[i]);
            printSpaces(flowerColumnSizes[i], flowerColumnNames[i].length());
            System.out.print(" ");
        }
        System.out.println("|");
    }

    private void flowerTableInitialize(Collection<Flower> flowerList) {
        int maxFlowerNameLength=0;
        for (Flower flower : flowerList){
            if (flower.getName().length()>maxFlowerNameLength) {
                maxFlowerNameLength=flower.getName().length();
            }
        }
        if (maxFlowerNameLength< flowerColumnNames[0].length()){
            flowerColumnSizes[0]= flowerColumnNames[0].length();
        }   else {
            flowerColumnSizes[0]=maxFlowerNameLength;
        }

        int maxFlowerTypeLength=0;
        if (FlowerType.Astra.toString().length()>maxFlowerTypeLength){
            maxFlowerTypeLength=FlowerType.Astra.toString().length();
        }
        if (FlowerType.Chamomile.toString().length()>maxFlowerTypeLength){
            maxFlowerTypeLength=FlowerType.Chamomile.toString().length();
        }
        if (FlowerType.Tulip.toString().length()>maxFlowerTypeLength){
            maxFlowerTypeLength=FlowerType.Tulip.toString().length();
        }
        if (FlowerType.Rose.toString().length()>maxFlowerTypeLength){
            maxFlowerTypeLength=FlowerType.Rose.toString().length();
        }
        if (FlowerType.Unknown.toString().length()>maxFlowerTypeLength){
            maxFlowerTypeLength=FlowerType.Unknown.toString().length();
        }
        if (maxFlowerTypeLength< flowerColumnNames[1].length()){
            flowerColumnSizes[1]= flowerColumnNames[1].length();
        }   else {
            flowerColumnSizes[1]=maxFlowerTypeLength;
        }
    }

    public void printInstrumentCollection(Map<Integer,MusicalInstrument> instrumentsList){
        instrumentsTableInitialize(instrumentsList);
        printInstumentsTableHead();

        for (Map.Entry<Integer,MusicalInstrument> instrument : instrumentsList.entrySet()){
            System.out.print("| ");
            System.out.print(instrument.getValue().getName());
            printSpaces(instrumentColumnSizes[0], instrument.getValue().getName().length());
            System.out.print(" | ");

            System.out.println();
        }

    }

    private void instrumentsTableInitialize(Map<Integer,MusicalInstrument> insrumentList) {
        int maxInstrumentNameLength=0;
        for (Map.Entry<Integer,MusicalInstrument> instrument : insrumentList.entrySet()){
            if (instrument.getValue().getName().length()>maxInstrumentNameLength) {
                maxInstrumentNameLength=instrument.getValue().getName().length();
            }
        }
        if (maxInstrumentNameLength< instrumentColumnNames[0].length()){
            instrumentColumnSizes[0]= instrumentColumnNames[0].length();
        }   else {
            instrumentColumnSizes[0]=maxInstrumentNameLength;
        }

    }

    private void printInstumentsTableHead() {
        System.out.println("  Instruments list:");
        for (int i = 0; i< instrumentColumnNames.length; i++) {
            System.out.print("| "+ instrumentColumnNames[i]);
            printSpaces(instrumentColumnSizes[i], instrumentColumnNames[i].length());
            System.out.print(" ");
        }
        System.out.println("|");
    }

    public List<File> gnomFileListSort(List<File> someList){
        if (someList.size()==1) return someList;
        int currentIndex=1;
        int uncheckedIndex=2;
        while (currentIndex< someList.size()){
            if (someList.get(currentIndex).getName().compareTo(someList.get(currentIndex-1).getName())<0) {
                File temp=someList.get(currentIndex);
                someList.set(currentIndex,someList.get(currentIndex-1));
                someList.set(currentIndex-1,temp);
                currentIndex--;
                if (currentIndex==0) {
                    currentIndex=uncheckedIndex;
                    uncheckedIndex++;
                }
            } else {
                currentIndex=uncheckedIndex;
                uncheckedIndex++;
            }
        }
        return someList;
    }

    public static void main(String[] args){
        CollectionsPrinter collectionsPrinter=new CollectionsPrinter();
        ArrayList<File> files = new ArrayList<>();
        files.add(new ImageFile("Ap"));
        files.add(new File("Broiler"));
        files.add(new File("Oi"));
        files.add(new File("Apple"));
        HashSet<Flower> flowers = new HashSet<>();
        flowers.add(new Flower("Some_flower"));
        flowers.add(new Rose("Chinese_rose"));
        Map<Integer,MusicalInstrument> instruments =new HashMap<Integer,MusicalInstrument>() {
        };
        instruments.put(collectionsPrinter.getMapIndex(),new MusicalInstrument("Stradivari"));
        instruments.put(collectionsPrinter.getMapIndex(),new MusicalInstrument("Stainway"));

        collectionsPrinter.printFileCollection(files);
        collectionsPrinter.printFlowerCollection(flowers);
        collectionsPrinter.printInstrumentCollection(instruments);
        collectionsPrinter.gnomFileListSort(files);
        collectionsPrinter.printFileCollection(files);




    }
}
