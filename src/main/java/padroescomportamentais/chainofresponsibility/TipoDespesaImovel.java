package padroescomportamentais.chainofresponsibility;

public class TipoDespesaImovel implements TipoDespesa {

    private static final TipoDespesaImovel tipoDespesaImovel = new TipoDespesaImovel();

    private TipoDespesaImovel() {}

    public static TipoDespesaImovel getTipoDespesaImovel() {
        return tipoDespesaImovel;
    }

}
