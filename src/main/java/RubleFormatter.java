public class RubleFormatter {
    public String formatterPayment(double payment) {
        return String.format("%.2f", payment);
    }

    public String rubleFormatter(double payment) {
        int intPayment = (int) payment;
        int twoLastNumbers = intPayment % 100;
        int lastNumber = intPayment % 10;

        if (twoLastNumbers >= 11 && twoLastNumbers <= 14) {
            return "рублей";
        }

        return switch (lastNumber) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };
    }
}
