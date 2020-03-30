package factorymethod;

public abstract class AterioivaOtus {

    Juoma juoma = null;

    public abstract Juoma createJuoma();


    public void aterioi(){
        syö();
        juo();
    }

    public void syö(){
        System.out.println("Kyllï¿½pï¿½s ruoka maistuukin hyvï¿½ltï¿½");
    }


    public void juo(){
        if (juoma == null)
            juoma = createJuoma();
        System.out.println("Aterian jï¿½lkeen " + juoma + " tekee terï¿½ï¿½");
    }
}
