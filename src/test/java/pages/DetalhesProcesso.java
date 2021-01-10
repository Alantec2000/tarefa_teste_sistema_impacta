package pages;

import support.DriverQA;

public class DetalhesProcesso extends BasePage {
    public DetalhesProcesso(DriverQA stepDriver) {
        super(stepDriver);
    }

    public String obterMensagem() {
        return driver.getText("notice");
    }

    public void clicarEmVoltar() {
        driver.click(".ls-btn-primary-danger", "css");
    }

    public String obterTextoCampo(String campo) throws InterruptedException {
        Thread.sleep(1000);
        return driver.getText(campo);
    }
}
