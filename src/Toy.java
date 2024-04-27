class Toy {
    private int id;
    private String name;
    private int quantity;
    private double frequency;

    // конструктор
    public Toy(int id, String name, int quantity, double frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    // метод для изменения веса (частоты выпадения игрушки)
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    // метод для уменьшения количества игрушек
    public void decreaseQuantity() {
        this.quantity--;
    }

    // геттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFrequency() {
        return frequency;
    }
}
