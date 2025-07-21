public class Tienda{
public static void main(String args[]){
    // Crear Agricultores
    Agricultor juan = new Agricultor("Juan Gonzalez", 45, "Manzana", "Boyacá", 12);
    Agricultor maria = new Agricultor("Maria Fernandez", 30, "Banano", "Antioquia", 5);
    Agricultor antonia = new Agricultor("Antonia Ramirez", 52, "Gulupa", "Tolima", 15);

    // Crear Frutas
    Frutas manzana = new Frutas("Manzana", "Octubre", 10,4, 7, 0.3, 14000);
    Frutas banano = new Frutas("Banano", "Julio",10, 3, 5, 0.2, 2000);    
    Frutas gulupa = new Frutas("Gulupa", "Marzo",10,3,6,0.5,3000);

    //Uso de métodos para agricultores
    juan.evaluarCosecha(manzana);
    juan.mostrarEstado();
    juan.cosecharFruta();
    juan.cosecharFruta();
    juan.cosecharFruta();
    juan.venderFrutas(manzana, 2); // cantidad de fruta a vender en Kg
    juan.consultarInventario();
    juan.consultarGanancias();
    
    maria.evaluarCosecha(banano);
    maria.mostrarEstado();
    maria.simularDiasCosecha(3, 10);
    maria.venderFrutas(banano, 20); // cantidad de fruta a vender en Kg
    maria.venderFrutas(banano, 15); // cantidad de fruta a vender en Kg
    maria.venderFrutas(banano, 10); // cantidad de fruta a vender en Kg
    maria.consultarInventario();
    maria.consultarGanancias();

    antonia.evaluarCosecha(gulupa);
    antonia.mostrarEstado();
    antonia.simularDiasCosecha(5, 20);
    antonia.venderFrutas(gulupa, 30); // cantidad de fruta a vender en Kg
    antonia.consultarInventario();
    antonia.consultarGanancias();
    antonia.venderFrutas(gulupa,60); // cantidad de fruta a vender en Kg
    antonia.consultarInventario();
    antonia.consultarGanancias();

    //Uso de métodos para manzana
    System.out.println("---------------------------------------------------");   
    manzana.mostrarInformacion();
    manzana.verificarMadurez();
    manzana.evaluarFrescura();
    manzana.pasarDias(6); // Cuantos dias pasaran?
    manzana.verificarMadurez();
    manzana.evaluarFrescura();

    //Uso de métodos para banano
    banano.mostrarInformacion();
    banano.pesar(3);
    String mesActual = "Julio";
    banano.aplicarDescuentoTemporada(mesActual);

    //Uso de métodos para gulupa
    gulupa.mostrarInformacion();
    gulupa.simularDiaEspecifico(3); // Simular por cuantos dias?
    gulupa.aplicarDescuentoTemporada(mesActual);
    System.out.println("Precio actual: $"+gulupa.calcularPrecio());
    System.out.println("-----------------------------");
}

}