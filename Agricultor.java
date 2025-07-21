public class Agricultor {
    private String nombre;
    private int edad;
    private String tipoCultivo;
    private String ubicacion;
    private int añosExperiencia;
    private int cantidadFrutasCosechadas;
    private double dineroGanado;

    public Agricultor(String nombre, int edad, String tipoCultivo, String ubicacion, int añosExperiencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoCultivo = tipoCultivo;
        this.ubicacion = ubicacion;
        this.añosExperiencia = añosExperiencia;
        this.cantidadFrutasCosechadas = 0;
        this.dineroGanado = 0.0;

    }

    // 1. Mostrar estado del agricultor
    public void mostrarEstado() {
        System.out.println("--------------------------------");
        System.out.println("   INFORMACIÓN DEL AGRICULTOR   ");
        System.out.println("Agricultor: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Cultivo: " + tipoCultivo);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Experiencia: " + añosExperiencia + " años");
        System.out.println("Frutas cosechadas (kg): " + cantidadFrutasCosechadas);
        System.out.println("Dinero ganado: $" + dineroGanado);
        System.out.println("--------------------------------");
    }
    // 2. Evaluar si una fruta está lista para cosecha
    public void evaluarCosecha(Frutas frutas) {
    System.out.println("---------------------------------");
    System.out.println("  EVALUACIÓN COSECHA DE " + frutas.getNombre());
    System.out.println("(Madurez: " + frutas.getMadurez() + ", Frescura: " + frutas.getFrescura() + ")");
    if (frutas.getMadurez() >= 3 && frutas.getFrescura() >= 5) {
        System.out.println(frutas.getNombre() + ": Lista para cosechar.");
    } else {
        System.out.println(frutas.getNombre() + ": Aún no está lista para cosechar.");
    }
    System.out.println("---------------------------------");
    }
    //3. Registrar una nueva cosechada de frutas
    public void cosecharFruta() {
        cantidadFrutasCosechadas=cantidadFrutasCosechadas+1;
        System.out.println("Kg de frutas cosechadas: " + cantidadFrutasCosechadas);
        System.out.println("---------------------------------");
    }
    //4. Calcular ganancias de frutas cosechadas
    public void venderFrutas(Frutas fruta, int kilosAVender) {
    if (kilosAVender > cantidadFrutasCosechadas) {
        System.out.println("No se puede vender " + kilosAVender + " Kg de " + fruta.getNombre());
        System.out.println("Solo hay " + cantidadFrutasCosechadas + " Kg disponibles.");
        return; // Cancelar la venta
    }
    double venta = kilosAVender * fruta.getPrecioPorKilo();
    dineroGanado += venta;
    cantidadFrutasCosechadas -= kilosAVender;
    System.out.println("Vendidos " + kilosAVender + " Kg de " + fruta.getNombre());
    System.out.println("Precio por Kg: $" + fruta.getPrecioPorKilo());
    System.out.println("Total vendido: $" + venta);
    System.out.println("Kg restantes: " + cantidadFrutasCosechadas);
    }
    // 5. Simula varias jornadas de cosecha: FOR
    public void simularDiasCosecha(int dias, int kgPorDia) {
        for (int i = 1; i <= dias; i++) {
            cantidadFrutasCosechadas = cantidadFrutasCosechadas + kgPorDia;
            System.out.println("Día " + i +": "+ kgPorDia +" Kg cosechados ");
        }
    }
    // 6. Consultar inventario actual
    public void consultarInventario() {
    System.out.println("Inventario disponible: " + cantidadFrutasCosechadas + " Kg de frutas.");
    System.out.println("--------------------------------");
    }
    // 7. Consultar ganancias totales
    public void consultarGanancias() {
    System.out.println("Ganancias acumuladas: $" + dineroGanado);
    System.out.println("--------------------------------");
    }

}