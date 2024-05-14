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

        switch (lastNumber) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
