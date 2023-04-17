package toys;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class main {
    static ArrayList<toy> toyses = new ArrayList<>();
    static Scanner user_input = new Scanner(System.in);
    static Random random = new Random();
    static Queue<toy> queue = new LinkedList<>(); 

    public static void main (String[] args) {
        System.out.println("Создай игрушку");
        for (int i = 0; i < 5; i++) {
            toy toy = toy_maker();
            toyses.add(toy);
        }
        lottery(toyses);
        take_prize(queue);
    }

    public static toy toy_maker() {
        System.out.println("Введите id игрушки ");
        int id = user_input.nextInt();
        user_input.nextLine();
        System.out.println("Введите название игрушки ");
        String name = user_input.nextLine();
        System.out.println("Введите количество ");
        int count = user_input.nextInt();
        System.out.println("Введите частоту ");
        int frequency = user_input.nextInt();
        toy toy = new toy(id, name, count, frequency); 
        return toy;
    }

    public static void lottery(ArrayList<toy> toyses) {
        int winner = random.nextInt(toyses.size());
        toy prize = toyses.get(winner);
        prize.takeWin();
        queue.add(prize);
    }

    public static void take_prize(Queue<toy> queue) {
        toy toy = queue.remove();
        try {
            PrintWriter writer = new PrintWriter(new File("/out.txt"));
            writer.write(toy.getName());
            writer.write(toy.getCount());
            writer.close();
            System.out.println("Gift");
        } catch (FileNotFoundException e) {
            System.out.println("Err");
            e.printStackTrace();
        }
    }
}