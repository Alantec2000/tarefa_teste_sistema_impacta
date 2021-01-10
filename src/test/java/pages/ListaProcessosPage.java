package pages;

import support.DriverQA;

public class ListaProcessosPage extends BasePage {
    public ListaProcessosPage(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void abrirFormularioNovoProcesso() {
        driver.click("btn-novo");
    }

    public void abrirEdicaoProcesso(String codigo) {
        driver.click("btn-edit_" + codigo);
    }

    public void apagarProcesso(String codigo) {
        driver.click("btn-delete_" + codigo);
    }

    public void confirmarRemocaoProcesso() {
        driver.ChooseOkOnNextConfirmation();
    }

    public boolean processoExiste(String codigo) {
        return driver.isDisplayed("btn-delete_" + codigo);
    }

    public void mostrarProcesso(String codigo) {
        driver.click("btn-show_" + codigo);
    }
}
