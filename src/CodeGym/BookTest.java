package CodeGym;

//import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

class BookTest {
    public static void main(String[] args) {

        ProgrammingBook programmingBook0 = new ProgrammingBook(10, "Conan", "mm", 50000, "English", "C");
        ProgrammingBook programmingBook1 = new ProgrammingBook(11, "Gia tri cuoc song", "Jack", 50000, "Spanish", "D");
        ProgrammingBook programmingBook2 = new ProgrammingBook(12, "Muu hen ke ban noi cong so", "PVT", 100000, "Java", "E");
        ProgrammingBook programmingBook3 = new ProgrammingBook(13, "Lam giau khong kho", "NTD", 120000, "English", "D");
        ProgrammingBook programmingBook4 = new ProgrammingBook(14, "Cracking code", "NTD", 150000, "Java", "A");


        FictionBook fictionBook0 = new FictionBook(15, "Cuoc song thoi nay", "SSS", 60000, "Thoi dai cuoc song");
        FictionBook fictionBook1 = new FictionBook(16, "Style autumn", "Chanel", 80000, "Bo su tap mua thu");
        FictionBook fictionBook2 = new FictionBook(17, "xxx", "aaa", 90000, "K");
        FictionBook fictionBook3 = new FictionBook(18, "the first in Java", "HTV", 90000, "E");
        FictionBook fictionBook4 = new FictionBook(19, "Co so du lieu", "AD", 100000, "H");


        ArrayList<Book> BookList = new ArrayList<>();
        BookList.add(programmingBook0);
        BookList.add(programmingBook1);
        BookList.add(programmingBook2);
        BookList.add(programmingBook3);
        BookList.add(programmingBook4);
        BookList.add(fictionBook0);
        BookList.add(fictionBook1);
        BookList.add(fictionBook2);
        BookList.add(fictionBook3);
        BookList.add(fictionBook4);

        int sum = 0;
        for (int i = 0; i < BookList.size(); i++) {
            sum += BookList.get(i).getPrice();
        }
        System.out.print(sum + "VND" + "\n");
        System.out.println("--------------------------------");

        Scanner input = new Scanner(System.in);
        System.out.println("nhap bookcode cuon sach ban muon tim: ");
        int value = input.nextInt();

        for (Book book : BookList) {
            if (book.getBookCode() == value) {
                System.out.println("Gia cua cuon : " + book.getName() + " la: " + book.getPrice() + "VND");
            }
        }
//        bubbleSort(BookList);
//        System.out.println("Mang sau khi sap xep:" + bubbleSort(BookList));
//        System.out.println("Mang sau khi sap xep:" + selectionSort(BookList));
//        System.out.println("Mang sau khi sap xep:" + insertionSort(BookList));


        System.out.println("ten cuon sach la:" + binarySearch(BookList, "Co so du lieu", 0, BookList.size()-1));
    }

    public static ArrayList bubbleSort(ArrayList<Book> list) {
        for (int k = 1; k < list.size(); k++) {
            for (int i = 0; i < list.size() - k; i++) {
                if (list.get(i).getPrice() > list.get(i + 1).getPrice()) {
                    Book tmp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, tmp);
                }
            }
        }
        return list;
    }

    public static ArrayList selectionSort(ArrayList<Book> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Book CurrentMin = list.get(i);
            int CurrentMinIndex = list.indexOf(list.get(i));
            for (int j = i + 1; j < list.size(); j++) {
                if (CurrentMin.getPrice() > list.get(j).getPrice()) {
                    CurrentMin = list.get(j);
                    CurrentMinIndex = list.indexOf(list.get(j));
                }
            }
            if (CurrentMinIndex != i) {
                list.set(CurrentMinIndex, list.get(i));
                list.set(i, CurrentMin);
            }
        }
        return list;
    }

    public static ArrayList insertionSort(ArrayList<Book> list) {
        for (int i = 1; i < list.size(); i++) {
            Book tmp = list.get(i);
            int k;
            for (k = i - 1; k >= 0 && list.get(k).getPrice() > tmp.getPrice(); k--) {
                list.set(k + 1, list.get(k));
            }
            list.set(k + 1, tmp);
        }
        return list;
    }

    public static double binarySearch(ArrayList<Book> list, String name,int low, int high) {
        for (int i = 1; i < list.size(); i++) {
            Book tmp = list.get(i);
            int k;
            for (k = i - 1; k >= 0 && list.get(k).getName().length() > tmp.getName().length(); k--) {
                list.set(k + 1, list.get(k));
            }
            list.set(k + 1, tmp);
        }

        if (high >= low) {
            int mid = low + (high - low) / 2;
            int result = name.compareTo(list.get(mid).getName());
            if (result == 0) {
                return list.get(mid).getPrice();
            } else if (result > 0) {
                return binarySearch(list,name,mid+1, high);
            } else {
                return binarySearch(list, name, low, mid -1);
            }

        }
        return -1;
    }
}