package padroescomportamentais.chainofresponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class DespesaTeste {

    Aprovador supervisor;

    @BeforeEach
    public void setUp(){
        // Supervisor -> Gerente -> Diretor -> Presidente
        supervisor = new AprovadorSupervisor(
                new AprovadorGerente(
                        new AprovadorDiretor(
                                new AprovadorPresidente(null))));
    }


    @Test
    public void supervisorDeveAprovarMaterial(){
        Despesa despesa = new Despesa(TipoDespesaMaterial.getTipoDespesaMaterial());
        assertEquals("Supervisor", supervisor.aprovarDespesa(despesa));
    }

    @Test
    public void gerenteDeveAprovarViagem(){
        Despesa despesa = new Despesa(TipoDespesaViagem.getTipoDespesaViagem());
        assertEquals("Gerente", supervisor.aprovarDespesa(despesa));
    }

    @Test
    public void gerenteDeveAprovarTreinamento(){
        Despesa despesa = new Despesa(TipoDespesaTreinamento.getTipoDespesaTreinamento());
        assertEquals("Gerente", supervisor.aprovarDespesa(despesa));
    }

    @Test
    public void diretorDeveAprovarEquipamento(){
        Despesa despesa = new Despesa(TipoDespesaEquipamento.getTipoDespesaEquipamento());
        assertEquals("Diretor", supervisor.aprovarDespesa(despesa));
    }

    @Test
    public void presidenteDeveAprovarImovel(){
        Despesa despesa = new Despesa(TipoDespesaImovel.getTipoDespesaImovel());
        assertEquals("Presidente", supervisor.aprovarDespesa(despesa));
    }

    @Test
    public void ninguemDeveAprovarDespesaPessoal(){
        Despesa despesa = new Despesa(TipoDespesaPessoal.getTipoDespesaPessoal());
        assertEquals("Sem aprovação", supervisor.aprovarDespesa(despesa));
    }


    @Test
    public void supervisorSemSuperiorNaoDeveAprovarViagem(){
        Aprovador sozinho = new AprovadorSupervisor(null);
        Despesa despesa = new Despesa(TipoDespesaViagem.getTipoDespesaViagem());
        assertEquals("Sem aprovação", sozinho.aprovarDespesa(despesa));
    }

    @Test
    public void gerenteSemSuperiorNaoDeveAprovarMaterial(){
        Aprovador sozinho = new AprovadorGerente(null);
        Despesa despesa = new Despesa(TipoDespesaMaterial.getTipoDespesaMaterial());
        assertEquals("Sem aprovação", sozinho.aprovarDespesa(despesa));
    }

    @Test
    public void diretorSemSuperiorNaoDeveAprovarImovel(){
        Aprovador sozinho = new AprovadorDiretor(null);
        Despesa despesa = new Despesa(TipoDespesaImovel.getTipoDespesaImovel());
        assertEquals("Sem aprovação", sozinho.aprovarDespesa(despesa));
    }

    @Test
    public void presidenteSemSuperiorNaoDeveAprovarMaterial(){
        Aprovador sozinho = new AprovadorPresidente(null);
        Despesa despesa = new Despesa(TipoDespesaMaterial.getTipoDespesaMaterial());
        assertEquals("Sem aprovação", sozinho.aprovarDespesa(despesa));
    }

    // A cadeia pode começar em qualquer ponto

    @Test
    public void cadeiaComecandoNoDiretorNaoDeveChegarAoSupervisor(){
        Aprovador diretor = new AprovadorDiretor(new AprovadorPresidente(null));
        Despesa despesa = new Despesa(TipoDespesaMaterial.getTipoDespesaMaterial());
        assertEquals("Sem aprovação", diretor.aprovarDespesa(despesa));
    }

    @Test
    public void cadeiaCurtaDeveRepassarAteOFim(){
        Aprovador cadeia = new AprovadorSupervisor(new AprovadorGerente(null));
        assertEquals("Gerente",
                cadeia.aprovarDespesa(new Despesa(TipoDespesaTreinamento.getTipoDespesaTreinamento())));
        assertEquals("Sem aprovação",
                cadeia.aprovarDespesa(new Despesa(TipoDespesaImovel.getTipoDespesaImovel())));
    }

    @Test
    public void ordemDaCadeiaNaoDeveAlterarQuemAprova(){
        // Cadeia invertida: Presidente -> Diretor -> Gerente -> Supervisor
        Aprovador invertida = new AprovadorPresidente(
                new AprovadorDiretor(
                        new AprovadorGerente(
                                new AprovadorSupervisor(null))));

        Despesa despesa = new Despesa(TipoDespesaMaterial.getTipoDespesaMaterial());
        assertEquals("Supervisor", invertida.aprovarDespesa(despesa));
    }

    // Montagem pelo setter

    @Test
    public void deveMontarACadeiaPeloSetter(){
        Aprovador gerente = new AprovadorGerente(null);
        Aprovador supervisorSolto = new AprovadorSupervisor(null);
        supervisorSolto.setAprovadorSuperior(gerente);

        assertSame(gerente, supervisorSolto.getAprovadorSuperior());
        assertEquals("Gerente",
                supervisorSolto.aprovarDespesa(new Despesa(TipoDespesaViagem.getTipoDespesaViagem())));
    }

    @Test
    public void aprovadorNovoSemSuperiorNaoDeveTerSuperior(){
        assertNull(new AprovadorPresidente(null).getAprovadorSuperior());
    }

    // Despesa

    @Test
    public void deveTrocarOTipoDaDespesaEReprocessar(){
        Despesa despesa = new Despesa(TipoDespesaMaterial.getTipoDespesaMaterial());
        assertEquals("Supervisor", supervisor.aprovarDespesa(despesa));

        despesa.setTipoDespesa(TipoDespesaImovel.getTipoDespesaImovel());
        assertEquals("Presidente", supervisor.aprovarDespesa(despesa));
    }

    @Test
    public void tiposDeDespesaDevemSerSingletons(){
        assertSame(TipoDespesaViagem.getTipoDespesaViagem(), TipoDespesaViagem.getTipoDespesaViagem());
    }

    @Test
    public void despesasDoMesmoTipoDevemTerOMesmoAprovador(){
        Despesa a = new Despesa(TipoDespesaEquipamento.getTipoDespesaEquipamento());
        Despesa b = new Despesa(TipoDespesaEquipamento.getTipoDespesaEquipamento());
        assertEquals(supervisor.aprovarDespesa(a), supervisor.aprovarDespesa(b));
    }
}
