package homework7;

public class MainClass {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(100, 400);
        System.out.println("Количество еды в миске - " + bowl.getFood() + " единиц.");
        Cat[] cats = {
                new Cat("Барсик", 100),
                new Cat("Пушок", 300),
                new Cat("Мурзик", 200),
                new Cat("Васька", 200),
                new Cat("Геннадий", 150),
                new Cat("Черныш", 2000),
        };
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].getName() + " подходит к миске и пробует покушать.");
            cats[i].eat(bowl);
            cats[i].catInfo();
            bowl.info();
        }
    }
}