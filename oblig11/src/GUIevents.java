/**
 * Obligatorisk oppgave 9,10,11
 * INF1010 - V15
 * Universitetet i Oslo
 *
 *
 * @author mariusch
 * @version 11.05.15
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

import java.io.File;

public class GUIevents implements EventHandler<ActionEvent> {

    protected GUI gui;

    protected String fil = null;
    protected boolean running = false;

    protected Sudoku spillet;

    public GUIevents(GUI gui) {
        this.gui = gui;
        spillet = gui.spillet;
    }

    public void handle(ActionEvent e) {
        if(e.getSource() == gui.startKnapp) {
            if (running) {
                spillet.cancel(true);
                gui.label.setText("Stoppet");
                gui.startKnapp.setText("Start løser");
                gui.velgFilKnapp.setDisable(false);
                running = false;
            } else {
                gui.label.setText("Finner løsning...");
                gui.startKnapp.setText("Avbryt");
                gui.velgFilKnapp.setDisable(true);

                spillet = new Sudoku();
                spillet.lesFil(fil);
                spillet.addPropertyChangeListener(gui);
                spillet.execute();

                running = true;
            }

        } else if (e.getSource() == gui.velgFilKnapp) {
            FileChooser jfc = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Txt fil (*.txt)", "*.txt");
            jfc.getExtensionFilters().add(extFilter);
            jfc.setTitle("Åpne");
            File fil = jfc.showOpenDialog(gui.window);

            if(fil != null) {
                String path = fil.getAbsolutePath();

                this.fil = path;
                gui.startKnapp.setDisable(false);
                gui.label.setText(path);

            }
        } else if (e.getSource() == gui.nesteKnapp) {
            gui.nesteLosning();
        } else if (e.getSource() == gui.forrigeKnapp) {
            gui.forrigeLosning();
        } else if (e.getSource() == gui.menu11) {
            gui.opneFil();
        } else if (e.getSource() == gui.menu21) {
            gui.visOm();
        }
    }

}