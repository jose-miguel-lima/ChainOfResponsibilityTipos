package padroescomportamentais.chainofresponsibility;

public class TipoDespesaTreinamento implements TipoDespesa {

    private static final TipoDespesaTreinamento tipoDespesaTreinamento = new TipoDespesaTreinamento();

    private TipoDespesaTreinamento() {}

    public static TipoDespesaTreinamento getTipoDespesaTreinamento() {
        return tipoDespesaTreinamento;
    }

}
