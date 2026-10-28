package padroescomportamentais.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public abstract class Aprovador {

    protected final List<TipoDespesa> tiposAprovados = new ArrayList<>();
    private Aprovador aprovadorSuperior;

    public Aprovador getAprovadorSuperior() {
        return aprovadorSuperior;
    }

    public void setAprovadorSuperior(Aprovador aprovadorSuperior) {
        this.aprovadorSuperior = aprovadorSuperior;
    }

    public abstract String getDescricaoCargo();

    public String aprovarDespesa(Despesa despesa) {
        if (tiposAprovados.contains(despesa.getTipoDespesa())) {
            return getDescricaoCargo();
        }
        if (aprovadorSuperior != null) {
            return aprovadorSuperior.aprovarDespesa(despesa);
        }
        return "Sem aprovação";
    }

}
