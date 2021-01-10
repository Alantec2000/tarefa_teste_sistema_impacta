package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.*;
import support.BaseSteps;

public class CrudProcessoSteps extends BaseSteps {

    private HomePage homePage = new HomePage(driver);
    private MenuLateral menuLateral = new MenuLateral(driver);
    private ListaProcessosPage listaProcessosPage = new ListaProcessosPage(driver);
    private FormularioNovoProcessoPage formularioNovoProcesso = new FormularioNovoProcessoPage(driver);
    private DetalhesProcessoPage detalhesProcesso = new DetalhesProcessoPage(driver);

    @Dado("^que o usuário esteja na página inicial$")
    public void queOUsuarioEstejaNaPaginaInicial() {
        homePage.open();
    }

    @E("^que o usuário clique no menu processo$")
    public void queOUsuarioCliqueNoMenuProcesso() {
        menuLateral.irParaProcessos();
    }

    @E("^que o usuário clique no botão novo processo$")
    public void queOUsuarioCliqueNoBotaoNovoProcesso() {
        listaProcessosPage.abrirFormularioNovoProcesso();
    }

    @E("^que o usuário preencha os campos do formulário$")
    public void queOUsuarioPreenchaOsCamposDoFormulario() {
        formularioNovoProcesso.preencherCampos();
    }

    @Quando("^o usuário pressionar o botão salvar$")
    public void oUsuarioPressioneOBotaoSalvar() {
        formularioNovoProcesso.clicarSalvar();
        formularioNovoProcesso.salvarCodigoDoNovoProcesso();
    }

    @Entao("^O usuário deve ver a mensagem \"([^\"]*)\"$")
    public void oUsuarioDeveVerAMensagem(String mensagem) {
        Assert.assertEquals(mensagem, detalhesProcesso.obterMensagem());
    }

    @E("^o usuário pressiona o botão voltar$")
    public void oUsuarioPressionaOBotaoVoltar() {
        detalhesProcesso.clicarEmVoltar();
    }

    @E("^o usuário preencha o campo \"([^\"]*)\" com o valor \"([^\"]*)\"$")
    public void oUsuarioPreenchaOCampoComOValor(String campo, String valor) throws Throwable {
        formularioNovoProcesso.preencherCampo(campo, valor);
    }

    @E("^o usuário clique no campo \"([^\"]*)\"$")
    public void oUsuarioCliqueNoCampoComOValor(String campo) throws Throwable {
        formularioNovoProcesso.preencherCampoRadio(campo);
    }

    @E("^o usuário selecione o campo \"([^\"]*)\" com o valor \"([^\"]*)\"$")
    public void oUsuarioSelecioneOCampoComOValor(String campo, String valor) throws Throwable {
        formularioNovoProcesso.preencherSelect(campo, valor);
    }

    @E("^o usuário pressiona o botão para editar o novo processo$")
    public void oUsuarioPressionaOBotaoParaEditarONovoProcesso() {
        listaProcessosPage.abrirEdicaoProcesso(formularioNovoProcesso.getCodigo());
    }

    @Entao("^o usuário deveria ver o campo \"([^\"]*)\" com o valor \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerOCampoComOValor(String campo, String valor) throws Throwable {
        Assert.assertEquals(valor, detalhesProcesso.obterTextoCampo(campo));
    }

    @E("^o usuário pressiona o botão para apagar o novo processo$")
    public void oUsuarioPressionaOBotaoParaApagarONovoProcesso() {
        listaProcessosPage.apagarProcesso(formularioNovoProcesso.getCodigo());
    }

    @Quando("^o usuário confirma que quer apagar o processo$")
    public void oUsuarioConfirmaQueQuerApagarOProcesso() {
        listaProcessosPage.confirmarRemocaoProcesso();
    }

    @Entao("^o usuário não deveria mais ver o novo processo na lista$")
    public void oUsuarioNaoDeveriaMaisVerONovoProcessoNaLista() {
        Assert.assertFalse(listaProcessosPage.processoExiste(formularioNovoProcesso.getCodigo()));
    }

    @Quando("^o usuário pressiona o botão para mostrar o novo processo$")
    public void oUsuárioPressionaOBotãoParaMostrarONovoProcesso() {
        listaProcessosPage.mostrarProcesso(formularioNovoProcesso.getCodigo());
    }

    @E("^o usuário preencha o campo \"([^\"]*)\", do tipo \"([^\"]*)\", com o valor \"([^\"]*)\"$")
    public void oUsuárioPreenchaOCampoDoTipoTipoComOValor(String campo, String tipo, String valor) throws Throwable {
        switch (tipo) {
            case "text":
                formularioNovoProcesso.preencherCampo(campo, valor);
                break;
            case "select":
                formularioNovoProcesso.preencherSelect(campo, valor);
                break;
            case "radio":
                formularioNovoProcesso.preencherCampoRadioPorValor(valor);
                break;
            default:
                throw new Exception("Tipo \"" + tipo + "\"não previsto!");
        }
    }
}
