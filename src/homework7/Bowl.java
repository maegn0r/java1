package homework7;

public class Bowl {
    private int food;
    private int capacity;

    public Bowl(int food, int capacity) {
        this.food = food;
        if (this.food < 0) {
            this.food = Math.abs(this.food);
            System.out.println("Поскольку в миску положили отрицательное количество еды - параметру \"количество еды в миске\" было присвоено значение по модулю.");
        }
        this.capacity = capacity;
        if (this.capacity < 0) {
            this.capacity = Math.abs(this.capacity);
            System.out.println("Поскольку была указана отрицательная вместительность миски - этому параметру было присвоено значение по модулю.");
        }
        if (this.food > this.capacity) {
            this.food = this.capacity;
            System.out.println("Остальная еда вывалилась из миски. В следующий раз надо взять тару побольше.");
        }
    }

    public void decreaseFood(int n) {
        if ((food - n) >= 0) food -= n;
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("В миске осталось " + food + " единиц еды.");
    }

    public void moreFood() {
        food = capacity;
        System.out.println("Миска пополнена до максимума " + capacity + ".");
    }
}
