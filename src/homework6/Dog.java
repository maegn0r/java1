package homework6;

public class Dog extends Animal {
    private final static int SWIM_DISTANCE_MAX = 10;
    private final static int RUN_DISTANCE_MAX = 500;
    private static int dogCount = 0;

    @Override
    public void swim(int distance) {
        if (distance <= SWIM_DISTANCE_MAX) {
            System.out.printf("%s проплыл %d метров.%n", this.getName(), distance);
        } else {
            double noMoreSwim = SWIM_DISTANCE_MAX * 1.0 / 2;
            System.out.printf("%s начинает заплыв на %d метров, однако проплыв %.1f метров бедняга %s разворачивается и плывет назад.%nГлядя на мокрую и обессиленную собаку становится понятно, что проплытые в общем %d метров - это предел собачьей выносливости.%n%n", this.getName(), distance, noMoreSwim, this.getName(), SWIM_DISTANCE_MAX);
        }
    }

    @Override
    public void run(int distance) {
        if (distance <= RUN_DISTANCE_MAX) {
            System.out.printf("%s пробежал %d метров.%n", this.getName(), distance);
        } else
            System.out.printf("%s начинает забег на %d метров, однако после пробежки %d метров бедняга %s падает без сил. Судя по всему, %d метров - это предел собачьей выносливости.%n", this.getName(), distance, RUN_DISTANCE_MAX, this.getName(), RUN_DISTANCE_MAX);
    }

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}


















