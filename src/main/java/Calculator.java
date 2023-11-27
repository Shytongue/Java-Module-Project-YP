public class Calculator {
    int peopleCount, dividedSumFloored;
    String productsList = "Добавленные товары:\n";
    double productPriceSum, dividedSum;
    Calculator(int peopleCount) {
        this.peopleCount = peopleCount;
    }
    public void addProduct(Product product) {
        productsList += product.name + "\n";
        productPriceSum += product.price;
    }
    public void showProductsList() {
        System.out.println(productsList);
    }
    public void calculateDividedSum() {
        dividedSum = productPriceSum / peopleCount;
        dividedSumFloored = (int)Math.floor(dividedSum);
    }
    public void showDividedSum() {
        System.out.println(dividedSumOutput(dividedSumFloored, dividedSum));
    }
    public String dividedSumOutput(int dividedSumFloored, double dividedSum) {
        String output = "Сумма на каждого человека составляет " + String.format("%.2f", dividedSum);
        if (dividedSumFloored % 10 == 1) {
            if (dividedSumFloored % 100 != 11){
                return output + " рубль";
            }
        } else if (dividedSumFloored % 10 >= 2 & dividedSumFloored % 10 <= 4) {
            if (dividedSumFloored % 100 < 12 || dividedSumFloored % 100 > 14) {
                return output + " рубля";
            }
        }
        return output + " рублей";
    }
}
