package padroescomportamentais.chainofresponsibility;

public class TipoDespesaEquipamento implements TipoDespesa {

    private static final TipoDespesaEquipamento tipoDespesaEquipamento = new TipoDespesaEquipamento();

    private TipoDespesaEquipamento() {}

    public static TipoDespesaEquipamento getTipoDespesaEquipamento() {
        return tipoDespesaEquipamento;
    }

}
