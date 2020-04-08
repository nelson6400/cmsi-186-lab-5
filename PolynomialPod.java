public class PolynomialPod extends Pod {
    public PolynomialPod(String name, double... coefficients) {
        super(name, t -> calculatePolynomial(coefficients, t));
    }
    private static double calculatePolynomial(double[] coefficients, double x) {
        var result = 0.0;
        for (var i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }
}