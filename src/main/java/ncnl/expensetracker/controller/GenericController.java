package ncnl.expensetracker.controller;

import ncnl.expensetracker.views.FXMLManager;

public abstract class GenericController {
    protected FXMLManager fxmlManager;

    public void setFxmlManager(FXMLManager fxmlManager) {
        this.fxmlManager = fxmlManager;
    }
}
