package padroescomportamentais.chainofresponsibility;

public class TipoDespesaViagem implements TipoDespesa {

    private static final TipoDespesaViagem tipoDespesaViagem = new TipoDespesaViagem();

    private TipoDespesaViagem() {}

    public static TipoDespesaViagem getTipoDespesaViagem() {
        return tipoDespesaViagem;
    }

}
