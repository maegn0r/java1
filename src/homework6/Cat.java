package homework6;

public class Cat extends Animal {
    private final static int RUN_DISTANCE_MAX = 200;
    private static int catCount = 0;

    @Override
    public void swim(int distance) {
        System.out.printf("%s плавать не умеет (или умеет, но ненавидит).%n%n", this.getName());
    }

    @Override
    public void run(int distance) {
        if (distance <= RUN_DISTANCE_MAX) {
            System.out.printf("%s пробежал %d метров.%n", this.getName(), distance);
        } else
            System.out.printf("%s начинает забег на %d метров, однако пробежав %d метров бедняга %s падает без сил. Судя по всему, %d метров - это предел кошачьей выносливости.%n", this.getName(), distance, RUN_DISTANCE_MAX, this.getName(), RUN_DISTANCE_MAX);
    }

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

}