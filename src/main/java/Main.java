import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        People.people();
    }

    public static class People{
        public static int amount;
        public static void people(){
            while (true){
                System.out.println("На сколько человек делить счёт?");
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    amount = scanner.nextInt();
                }
                else {
                    System.out.println("Пожалуйста, введите корректное значение");
                    continue;
                }
                if (amount <= 1){
                    System.out.println("Пожалуйста, введите значение больше 1");
                }
                else {
                    Calculate.calculate();
                    break;
                }
            }
        }
    }

    public static class Calculate{
        public static double count = 0;
        public static double toPay;
        public static String product1 = "";
        public static String ending(double number) {
            int numberInt = (int) number;
            int lastFigure = numberInt % 10;
            String correctForm = "";
            if (lastFigure == 1) {
                correctForm = "рубль";
            } else if ((1 < lastFigure) && (lastFigure <= 4)) {
                correctForm = "рубля";
            } else if (((5 <= lastFigure) && (lastFigure <= 9)) || (0 == lastFigure)) {
                correctForm = "рублей";
            }
            return correctForm;
        }
        public static void calculate() {
            while(true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите название продукта: ");
                String product = scanner.next();
                product1 += product + "\n";
                System.out.println("Введите стоимость продукта в формате 'рубли,копейки' [10,45, 11,40]");
                double cost = scanner.nextDouble();
                System.out.println(product + " успешно добавлено");
                count += cost;
                System.out.printf("Общая стоимость: " + "%.2f.\n",count);
                exit();
                break;
            }
        }
        private static void exit() {
            while(true){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Вы хотите добавить новый товар?");
                String stop = scanner.next();
                String stop1 = "завершить";
                String stop2 = "да";
                toPay = count / People.amount;
                if (stop1.equalsIgnoreCase(stop)){
                    Result.result();
                    break;
                }
                else if (stop2.equalsIgnoreCase(stop)){
                    calculate();
                    break;
                }
                else{
                    System.out.println("Вы ввели неверное значение");
                    continue;
                }
            }
        }
    }
    public static class Result{
        public static void result(){
            System.out.println("Блюд в счете:" + "\n" + Calculate.product1);
            System.out.printf("Финальная стоимость: " +  "%.2f " + Calculate.ending(Calculate.count) + "\n", Calculate.count);
            System.out.printf("Каждому нужно заплатить: " + "%.2f " + Calculate.ending(Calculate.toPay),Calculate.toPay);

        }
    }

}
