public class Frutas{
    String nombre;
    String temporada;
    int diasCosechados;
    int madurez; // de 1 a 10
    int frescura; // de 0 a 10
    double peso; // en kilos
    double precioPorKilo; // precio por kilo

    Frutas(String nombre, String temporada, int diasCosechados, int madurez, int frescura, double peso, double precioPorKilo){
        this.nombre = nombre;
        this.temporada = temporada;
        this.diasCosechados = 0;
        this.madurez = madurez;
        this.frescura = frescura;
        this.peso = peso;
        this.precioPorKilo = precioPorKilo;
        calcularPrecio();
    }

    //1. Muestra informacion de la fruta
    public void mostrarInformacion() {
        System.out.println("--------------------------------");
        System.out.println(" INFORMACIÓN ACTUAL DE LA FRUTA ");
        System.out.println("Fruta: " + nombre);
        System.out.println("Temporada: " + temporada);
        System.out.println("Madurez: " + madurez + " (1-10)");
        System.out.println("Frescura: " + frescura + " (0-10)");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Precio por kilo: $" + precioPorKilo);
        System.out.println("Precio actual: $" + calcularPrecio());
        System.out.println("--------------------------------");
    }
    
    //2. Evalua frescura de la fruta
    public void evaluarFrescura() {
        if (frescura >= 6) {
            System.out.println(nombre + " está fresca.");
        } else if (frescura==0){
            System.out.println(nombre + " NO está fresca, NO se debe comer.");
        } else {
            System.out.println(nombre + " no está muy fresca.");
        }
    } 

    //3. Verifica madurez de la fruta
    public void verificarMadurez() {
    if (madurez == 10) {
        System.out.println(nombre + " está podrida.");
    }else if (madurez >= 5 && madurez <= 9) {
        System.out.println(nombre + " está madura.");
    }else if (madurez >= 1 && madurez <= 4) {
        System.out.println(nombre + " no está muy madura.");
    }else{
        System.out.println("Nivel de madurez inválido.");
        }
    }
    
    //4. Simulación de maduración con el paso de x días despues de cosechado
    public void pasarDias(int dias) {
        int contador = 1;
            System.out.println("-----------------------------");
            System.out.println("    Simulación Maduración    ");
            System.out.println("-----------------------------");
        while (contador <= dias) {
            System.out.println("Día " + contador + ":");
            //aumentar madurez
            if (madurez < 10) {
                madurez=madurez+1;
                // Por cada punto de madurez por encima de 5, se reduce la frescura en 1
                if (madurez > 5) {
                    frescura = frescura - 1;
                    if (frescura < 0) {
                        frescura = 0;
                    }
                }
            }
            // Fruta podrida cuando madurez >=10
            if (madurez >= 10) {
                madurez = 10;
                frescura = 0;
                precioPorKilo = 0;
            }
            // Imprime estado del día
            System.out.println("Madurez actual: " + madurez);
            verificarMadurez();
            System.out.println("Frescura actual: " + frescura);
            evaluarFrescura(); 
            // Calcular precio total según frescura sin afectar precioPorKilo original
            double precioTotal = precioPorKilo * peso;
            if (madurez < 10 && frescura < 6) {
                int puntosDebajo = 6 - frescura;
                double descuento = puntosDebajo * 200;
                precioTotal =precioTotal - descuento;
                if (precioTotal < 0) {
                precioTotal = 0;
                }
            }
            System.out.println("Precio total actual: $" + precioTotal);
            System.out.println("--------------------------");

            // Si ya está podrida, se detiene la simulación anticipadamente
            if (madurez == 10) {
             break;
            }
            contador=contador+1;
        }
    }
    //4.1. Cómo estaria la fruta despues de x dias
public void simularDiaEspecifico(int diaObjetivo) {
    int madurezSimulada = madurez;
    int frescuraSimulada = frescura;
    double precioKiloSimulado = precioPorKilo;
    double pesoSimulado = peso;
    for (int dia = 1; dia <= diaObjetivo; dia=dia+1) {
        // Aumentar madurez
        if (madurezSimulada < 10) {
            madurezSimulada++;
            // Por cada punto de madurez mayor a 5, se reduce la frescura
            if (madurezSimulada > 5) {
                frescuraSimulada--;
                if (frescuraSimulada < 0) {
                    frescuraSimulada = 0;
                }
            }
        }
        // Si ya está podrida
        if (madurezSimulada >= 10) {
            madurezSimulada = 10;
            frescuraSimulada = 0;
            precioKiloSimulado = 0;
        }
    }
    // Calcular el precio total (descuento por frescura si es menor a 6)
    double precioTotal = precioKiloSimulado * pesoSimulado;
    if (madurezSimulada < 10 && frescuraSimulada < 6) {
        int puntosDebajo = 6 - frescuraSimulada;
        double descuento = puntosDebajo * 200;
        precioTotal -= descuento;
        if (precioTotal < 0) {
            precioTotal = 0;
        }
    }
    // Mostrar el estado del día solicitado
    System.out.println("-----------------------------");
    System.out.println("     Día " + diaObjetivo + " (simulado)");
    System.out.println("-----------------------------");
    System.out.println("Madurez simluada: " + madurezSimulada);
    System.out.println("Frescura simulada: " + frescuraSimulada);
    System.out.println("Precio total simulado: $" + precioTotal);
    System.out.println("-----------------------------");
}
    //5. Calcular precio 
    public double calcularPrecio() {
        double precioBase = peso * precioPorKilo;
        // Si frescura es menor a 6, se reduce el precio $200 por cada punto debajo de 6
        if (frescura <= 6) {
            int Descuento = 6 - frescura;
            precioBase = precioBase - (Descuento * 200);
            if (precioBase < 0){
                precioBase = 0;
            }
        }
        return precioBase;
    }

    //6. Comprobar el precio de los kilos ingresados
    public void pesar(double kilos) {
        System.out.println("El precio de "+kilos+" kilo(s) de " + nombre + " es de: $" + (kilos*precioPorKilo));
    }

    //7. Verificar si está en temporada
    public boolean esDeTemporada(String mes) {
        return temporada.equalsIgnoreCase(mes);
    }
    public double aplicarDescuentoTemporada(String mes) {
    // Si está en temporada, se reduce 10% el precio como promoción
    if (esDeTemporada(mes)) {
        System.out.println("La fruta está en temporada.");
        double precioConDescuento = precioPorKilo * 0.9;
        System.out.println("Precio por Kilo con descuento de temporada es de: $" + precioConDescuento);
        return precioConDescuento;
    } else {
        System.out.println("La fruta NO está en temporada.");
        System.out.println("Precio por Kilo sin descuento: $" + precioPorKilo);
        return precioPorKilo;
        }
    }
    public int getMadurez() {
        return madurez;
    }
     public int getFrescura() {
        return frescura;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPeso() {
        return peso;
    }
    public double getPrecioPorKilo() {
        return precioPorKilo;
    }

}