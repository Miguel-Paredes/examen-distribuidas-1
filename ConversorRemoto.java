import java.rmi.Remote;

public interface ConversorRemoto extends Remote{
    double celsiusToFahrenheit(double celsius) throws Exception;
    double fahrenheitToCelsius(double fahrenheit) throws Exception;
}