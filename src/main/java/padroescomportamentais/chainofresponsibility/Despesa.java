package padroescomportamentais.chainofresponsibility;

public class Despesa {

    private TipoDespesa tipoDespesa;

    public Despesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

}
