package pages;

import support.DriverQA;

import java.util.Random;

public class FormularioNovoProcesso extends BasePage {
    private String codigo;

    public FormularioNovoProcesso(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void preencherCampos() {
        preencherVara();
        preencherNumeroProcesso();
        preencherNatureza();
        preencherPartes();
        preencherUrgente();
        preencherArbitramento();
        preencherAssistenteSocial();
        preencherDataEntrada();
        preencherDataSaida();
        preencherDataAgendamento();
        preencherStatus();
        preencherObservacao();
    }

    public void preencherObservacao() {
        driver.sendKeys("Só observando", "#processo_observacao", "css");
    }

    public void preencherStatus() {
        driver.sendKeys("arquivado", "#processo_status", "css");
    }

    public void preencherDataAgendamento() {
        driver.sendKeys("2020-10-12", "#processo_data_agendamento", "css");
    }

    public void preencherDataSaida() {
        driver.sendKeys("2020-12-25", "#processo_data_saida", "css");
    }

    public void preencherDataEntrada() {
        driver.sendKeys("2020-12-20", "#processo_data_entrada", "css");
    }

    public void preencherAssistenteSocial() {
        driver.sendKeys("Mãe", "#processo_assistente_social", "css");
    }

    public void preencherArbitramento() {
        int randInt = new Random().nextInt();
        String arbitramentoId = randInt % 2 == 0 ? "#processo_arbitramento_n" : "#processo_arbitramento_s";
        driver.click(arbitramentoId, "css");
    }

    public void preencherUrgente() {
        driver.selectByText("Sim", "#processo_urgente", "css");
    }

    public void preencherPartes() {
        driver.sendKeys("varias", "#processo_partes", "css");
    }

    public void preencherVara() {
        driver.sendKeys("Vareta", "#processo_vara", "css");
    }

    public void preencherNumeroProcesso() {
        driver.sendKeys("2345678", "#processo_numero_processo", "css");
    }

    public void preencherNatureza() {
        driver.sendKeys("Humana", "#processo_natureza", "css");
    }

    public void clicarSalvar() {
        driver.click("btn-save");
    }

    public void preencherCampo(String campo, String valor) {
        driver.sendKeys(valor, campo);
    }

    public void preencherCampoRadio(String campo) {
        driver.click(campo);
    }

    public void preencherCampoRadioPorValor(String valor) {
        String campo;
        valor = valor.toLowerCase();
        if (valor.equals("sim") || valor.equals("s")) {
            campo = "processo_arbitramento_s";
        } else {
            campo = "processo_arbitramento_n";
        }
        driver.click(campo);
    }

    public void preencherSelect(String campo, String valor) {
        driver.selectByText(valor, campo);
    }

    public void salvarCodigoDoNovoProcesso() {
        codigo = driver.getText("codigo");
    }

    public String getCodigo() {
        return codigo;
    }
}
