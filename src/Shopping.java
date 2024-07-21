import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");

        String[] shoppingList = new String[8];

        Scanner scanner = new Scanner(System.in);

        int productCount = 0;

        while (true) {

            System.out.println("Выберите одну из команд");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt();
            scanner.nextLine();

            if (actionNumber == 1) {
                if (productCount < shoppingList.length) {
                    System.out.println("Введите название товара (если в названии товара присутствует пробел - замените его на '_':");
                    String productName = scanner.next();
                    boolean isDuplicate = false;

                    for (int i = 0; i < productCount; i++) {
                        if (shoppingList[i].equals(productName)) {
                            isDuplicate = true;
                            break;
                        }
                    }
                    if (isDuplicate) {
                        System.out.println("Товар " + productName + " уже есть в списке");
                    } else {
                        shoppingList[productCount] = productName;
                        productCount++;
                        System.out.println("Товар " + productName + " добавлен в список под номером " + productCount);
                    }
                } else {
                    System.out.println("Отложите покупку до следующего раза!");
                }
            } else if (actionNumber == 2) {
                if (productCount == 0) {
                    System.out.println("Продукты отсутствуют");
                } else {
                    System.out.println("Список продуктов:");
                    for (int i = 0; i < productCount; i++) {
                        System.out.println((i + 1) + ". " + shoppingList[i]);
                    }
                }
            } else if (actionNumber == 3) {
                for (int i = 0; i < productCount; i++) {
                    shoppingList[i] = null;
                }
                productCount = 0;
                System.out.println("Список пуст");
            } else if (actionNumber == 4) {
                System.out.println("Работа завершена");
                scanner.close();
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}
