import L01.ListaEstatica;

public class App {

    public static void main(String[] args) throws Exception {
        Lista01();
    }

    
    public static void Lista01() {
        ListaEstatica lista01 = new ListaEstatica();
        lista01.inserir(5);
        lista01.inserir(10);
        lista01.inserir(15);
        lista01.inserir(20);
        System.out.println(lista01.toString());
    }

    

}
