package padroescomportamentais.chainofresponsibility;

public class TipoDespesaMaterial implements TipoDespesa {

    private static final TipoDespesaMaterial tipoDespesaMaterial = new TipoDespesaMaterial();

    private TipoDespesaMaterial() {}

    public static TipoDespesaMaterial getTipoDespesaMaterial() {
        return tipoDespesaMaterial;
    }

}
