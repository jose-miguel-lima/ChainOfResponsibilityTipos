package padroescomportamentais.chainofresponsibility;

public class AprovadorPresidente extends Aprovador {

    public AprovadorPresidente(Aprovador superior) {
        tiposAprovados.add(TipoDespesaImovel.getTipoDespesaImovel());
        setAprovadorSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Presidente";
    }

}
