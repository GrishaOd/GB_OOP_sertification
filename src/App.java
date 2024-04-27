import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy(1, "Кукла", 10, 20));
        toys.add(new Toy(2, "Мяч", 15, 30));
        toys.add(new Toy(3, "Погремушка", 17, 25));
        // добавьте другие игрушки по необходимости

        // розыгрыш
        List<Toy> prizeToys = new ArrayList<>();
        Random random = new Random();
        double totalFrequency = toys.stream().mapToDouble(Toy::getFrequency).sum();
        double randomValue = random.nextDouble() * totalFrequency;
        for (Toy toy : toys) {
            randomValue -= toy.getFrequency();
            if (randomValue <= 0) {
                prizeToys.add(toy);
                toy.decreaseQuantity();
                break;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt"))) {
            for (Toy toy : prizeToys) {
                writer.write("Призовая игрушка: " + toy.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Результат записан в prize_toys.txt");
    }
}