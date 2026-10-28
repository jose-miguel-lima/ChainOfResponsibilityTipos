package padroescomportamentais.chainofresponsibility;

public class AprovadorDiretor extends Aprovador {

    public AprovadorDiretor(Aprovador superior) {
        tiposAprovados.add(TipoDespesaEquipamento.getTipoDespesaEquipamento());
        setAprovadorSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Diretor";
    }

}
