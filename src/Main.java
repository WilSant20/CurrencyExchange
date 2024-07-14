import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner lecture = new Scanner(System.in);
        System.out.println("Bienvenido al Conversor de monedas");
        while (true){
            System.out.println("""
                    ****************************************************
                    Escriba el codigo de la moneda que desea convertir:
                    Aqui algunos ejemplos:
                    ARS - Peso Argentino
                    EUR - Euro
                    BOB - Boliviano
                    BRL - Real Brasileño
                    CAD - Dolar Canadiense
                    CLP - Peso Chileno
                    CNY - Renminbi Chino
                    COP - Peso Colombiano
                    USD - Dolar Estadounidense
                    JPY - Yen Japones
                    MXN - Peso Mexicano
                    GBP - Libra Esterlina
                    VEF - Bolívar Venezolano
                    KRW - Won Surcoreano
                    RUB - Rublo Ruso
                    CHF - Franco Suizo
                    GTQ - Quetzal Guatemalteco
                    PEN - Nuevo Sol Peruano
                                    
                    Escribar 'Salir' Para salir de la conversion
                    ****************************************************
                    """
            );
            String fromCurrency = lecture.nextLine().toUpperCase();
            if (fromCurrency.equalsIgnoreCase("salir")){
                break;
            }
            System.out.print("Ingresa la cantidad que deseas convertir: ");
            BigDecimal amount = lecture.nextBigDecimal();
            lecture.nextLine(); //consumir la linea pendiente
            System.out.print("Ingresa el código de la moneda a la que desea convertir: ");
            String toCurrency = lecture.nextLine().toUpperCase();


            String request = new CurrencyRequest(fromCurrency).getJson();
            CurrencyConverter converter = new CurrencyConverter(fromCurrency, request, amount, toCurrency);

            System.out.println(fromCurrency + " " + amount + " equivale a: " + toCurrency + " "
                    + converter.getConvertedValue());

            System.out.println("¿Quieres continuar con el programa?\nEscribe Salir si quieres terminar con el programa");
            fromCurrency = lecture.nextLine();
            if (fromCurrency.equalsIgnoreCase("salir")){
                break;
            }

        }
        System.out.println("Finalizó el programa!");
    }
}