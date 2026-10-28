package padroescomportamentais.chainofresponsibility;

public class TipoDespesaPessoal implements TipoDespesa {

    private static final TipoDespesaPessoal tipoDespesaPessoal = new TipoDespesaPessoal();

    private TipoDespesaPessoal() {}

    public static TipoDespesaPessoal getTipoDespesaPessoal() {
        return tipoDespesaPessoal;
    }

}
