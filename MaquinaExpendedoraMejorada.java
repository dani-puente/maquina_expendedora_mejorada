public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Billetes vendidos
    private int billetesVendidos;
    // Indica si tiene premio o no la maquina
    private boolean tienePremio;
    // Numero maximo de billetes que puede vender
    private int numeroMaximoBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean conPremio, int topeBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        tienePremio = conPremio;
        numeroMaximoBilletes = topeBilletes;

    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(billetesVendidos < numeroMaximoBilletes){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            } 
        } else{
            System.out.println("Se ha alcanzado el número máximo de billetes que se pueden vender.");
        }

    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if(billetesVendidos < numeroMaximoBilletes){
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                billetesVendidos ++;
                if(tienePremio == true && (billetesVendidos%3 == 0)){
                    System.out.println("¡NO TIRES EL BILLETE, TIENES UN " + 10*precioBillete/100 + " EURO(S) DE DESCUENTO EN EL ESTABLECIMIENTO QUE TU ELIJAS!");
                }
            }

            else {
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");

            }
        } else{
            System.out.println("Se ha alcanzado el número máximo de billetes que se pueden vender.");
        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }

    /**
     * Vacia todo el dinero de la maquina
     */
    public int vaciarDineroDeLaMaquina(){
        int dineroEnMaquina = totalDineroAcumulado;
        if(balanceClienteActual != 0){
            System.out.println("¡HAY UNA OPERACION EN CURSO!");
            dineroEnMaquina = -1; 
        } else{
            totalDineroAcumulado = 0;
        }
        return dineroEnMaquina;
    }

    /**
     * Indica el numero de billetes que se han vendido
     */
    public int getNumeroBilletesVendidos(){
        return billetesVendidos;
    }

    /**
     * Imprime por pantalla el numero de billetes vendidos
     */
    public void imprimeNumeroBilletesVendidos(){
        System.out.println("Se han vendido " + billetesVendidos + " billetes.");
    }
}
