package homework5;

public class TestEmployee {
    public static void main(String[] args) {

        Employee[] emplArray = new Employee[5];
        emplArray[0] = new Employee("Иван Сергеевич Рукавичкин", "Руководитель направления", "Rukavichkin@mywork.com", "89064242423", 250000, 38);
        emplArray[1] = new Employee("Михаил Аристархович Косорезов", "Начальник отдела", "Kosorezov@mywork.com", "89031212123", 200000, 45);
        emplArray[2] = new Employee("Александр Васильевич Сало", "Главный специалист", "Salo@mywork.com", "89162323415", 150000, 40);
        emplArray[3] = new Employee("Виталий Семенович Молотков", "Ведущий специалист", "molotok@mywork.com", "89651212123", 130000, 32);
        emplArray[4] = new Employee("Валентин Петрович Салтыков-Щедрин", "Специалист", "salt-shedrin@mywork.com", "89032532123", 100000, 54);

        for (int i = 0; i < emplArray.length; i++) {
            if (emplArray[i].getAge() > 40) {
                emplArray[i].printInfo();
            }
        }
    }
}
