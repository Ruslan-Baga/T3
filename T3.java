import java.util.Scanner;

public class T3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String text = scanner.nextLine();

    try {
        String result = "\""+ actionPower(text)+"\"";
        System.out.println(result);
    } catch (Exception e) {
        System.out.println("Ошибка: " + e.getMessage());
        }
    }
    static String actionPower(String text) throws Exception {
            char action;
            String[] data;

            if (text.contains(" + ")) {
                data = text.split(" \\+ ");
                action = '+';
            } else if (text.contains(" - ")) {
                data = text.split(" - ");
                action = '-';
            } else if (text.contains(" * ")) {
                data = text.split(" \\* ");
                action = '*';
            } else if (text.contains(" / ")) {
                data = text.split(" / ");
                action = '/';
            } else {
                throw new Exception("Некорректный знак действия");
            }
            if (action == '*' || action == '/') {
                if (data[1].contains("\"")) throw new Exception("При умножении или делении первым аргументом должна быть строка, а вторым аргументом целое число");
            }
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].replace("\"", "");
                if (action != '+')check2(data[i]);


                if (data[0].length() > 10 || data[1].length()> 10) throw new Exception("Строка должна быть длинной не более 10 символов");
            }
            String result = check(data, action);
            if (result.length() > 40) {
                result = result.substring(0, 40) + "...";
            }
            return result;}

    static void check2(String text) throws Exception {


                    try {
                        int number = Integer.parseInt(text);

                        if (number < 1 || number > 10) throw new Exception("Число должно быть от 1 до 10");
                    } catch (NumberFormatException e) {
                    }
        }
    static String check(String data[], char action) throws Exception {

            switch (action) {
                case '+':
                    return data[0].replace("\"", "") + data[1].replace("\"", "");
                case '-':
                    int index = data[0].indexOf(data[1]);
                    if (index == -1) {
                        return data[0];
                    } else {
                        String result = data[0].substring(0, index);
                        result += data[0].substring(index + data[1].length());
                        return (result);
                    }
                case '*':
                    int umn = Integer.parseInt(data[1]);
                    String result = "";
                    for (int i = 0; i < umn; i++) {
                        result += data[0];
                    }
                    return (result);
                case '/':
                    int del = data[0].length() / Integer.parseInt(data[1]);
                    result = data[0].substring(0, del);
                    if (del == 0) throw new Exception("Деление на ноль");
                    return (result);
                default:
                    return "";}
            }
}
