import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConvierteMoneda convierte = new ConvierteMoneda();
        System.out.println("*******************************");
        System.out.println("""
                Bienvenido al conversor de Monedas:

                1) Dolar a Peso Argentino
                2) Peso argentino a Dolar
                3) Dolar a Real Brasileño
                4) Real Brasileño a Dolar
                5) Dolar a Peso Colombiano
                6) Peso Colombiano a Dolar
                7) Salir
                
                Elija una opcion Valida
                
                *******************************""");

        try {
            var opcion = Integer.valueOf(lectura.nextLine());
            System.out.println("Ingrese el monto a convertir: ");
            double valor = Double.valueOf(lectura.nextLine());

            Conversor conversor = null;

            switch (opcion) {
                case 1:
                    conversor = convierte.convierteMoneda("USD", "ARS", valor);
                    break;
                case 2:
                    conversor = convierte.convierteMoneda("ARS", "USD", valor);
                    break;
                case 3:
                    conversor = convierte.convierteMoneda("USD", "BRL", valor);
                    break;
                case 4:
                    conversor = convierte.convierteMoneda("BRL", "USD", valor);
                    break;
                case 5:
                    conversor = convierte.convierteMoneda("USD", "COP", valor);
                    break;
                case 6:
                    conversor = convierte.convierteMoneda("COP", "USD", valor);
                    break;
                case 7:
                    break;
                default:
                    throw new IllegalStateException("Valor invalido");
            }
            System.out.println("El Valor "+valor+" ["+ conversor.base_code()+"] equivale a "+conversor.conversion_result()+"[" + conversor.target_code()+"]" );
            System.out.println("A una tasa de cambio de: " + conversor.conversion_rate());
        }catch (RuntimeException e) {
            System.out.println("Finalizando la aplicacion");
        }

    }
}

