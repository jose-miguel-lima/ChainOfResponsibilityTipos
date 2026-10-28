package padroescomportamentais.chainofresponsibility;

public class AprovadorGerente extends Aprovador {

    public AprovadorGerente(Aprovador superior) {
        tiposAprovados.add(TipoDespesaViagem.getTipoDespesaViagem());
        tiposAprovados.add(TipoDespesaTreinamento.getTipoDespesaTreinamento());
        setAprovadorSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Gerente";
    }

}
