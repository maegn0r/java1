package homework7;

public class Cat {
    private String name;
    private int appetite;
    private int defaultAppetite = 0;
    private boolean satiety = false;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        if (appetite <= 0) {
            this.appetite = defaultAppetite;
            this.satiety = true;
            System.out.println("Поскольку был создан кот с нулевым или отрицательным аппетитом, значение поля аппетит изменено на \"по умолчанию\", кот в этом случае считается сытым. ");
        }
    }

    public void eat(Bowl p) {
        if (appetite <= p.getFood()) {
            p.decreaseFood(appetite);
            satiety = true;
        } else {
            System.out.println(name + "с грустью смотрит на то, как мало еды в миске. Дно видно. Надо бы положить еще...");
            p.moreFood();
            if (appetite <= p.getFood()) {
                p.decreaseFood(appetite);
                satiety = true;
            } else System.out.println("Ну и кот! Это тигр какой-то... Этому коту нужна миска побольше.");
        }
    }

    public void catInfo() {
        if (satiety) {
            System.out.println(name + " наелся.");
        } else System.out.println(name + " остался голодным.");
    }

    public String getName() {
        return name;
    }
}