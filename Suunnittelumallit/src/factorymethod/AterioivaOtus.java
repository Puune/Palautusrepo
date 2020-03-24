package factorymethod;

public abstract class AterioivaOtus {

    Juoma juoma = null;

    public abstract Juoma createJuoma();


    public void aterioi(){
        syö();
        juo();
    }

    public void syö(){
        System.out.println("Kyll�p�s ruoka maistuukin hyv�lt�");
    }


    public void juo(){
        if (juoma == null)
            juoma = createJuoma();
        System.out.println("Aterian j�lkeen " + juoma + " tekee ter��");
    }
}
