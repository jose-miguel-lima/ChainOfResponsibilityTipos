package padroescomportamentais.chainofresponsibility;

public class AprovadorSupervisor extends Aprovador {

    public AprovadorSupervisor(Aprovador superior) {
        tiposAprovados.add(TipoDespesaMaterial.getTipoDespesaMaterial());
        setAprovadorSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Supervisor";
    }

}
