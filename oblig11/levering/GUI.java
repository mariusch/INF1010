/**
 * Obligatorisk oppgave 9,10,11
 * INF1010 - V15
 * Universitetet i Oslo
 *
 *
 * @author mariusch
 * @version 11.05.15
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;

public class GUI extends Application implements PropertyChangeListener {

    protected Sudoku spillet;
    protected GUIevents event;

    protected Stage window;
    protected Scene startScene, sudokuScene;
    protected GridPane[] losninger;
    protected BorderPane layout;
    protected Button startKnapp, velgFilKnapp, forrigeKnapp, nesteKnapp;
    protected Text label, antall;
    protected MenuItem menu11, menu21;

    private final String cssBoks = "-fx-border-color: black;\n"
            + "-fx-border-insets: -3;\n"
            + "-fx-border-width: 3;\n"
            + "-fx-border-style: solid;\n";

    private final String cssRute = "-fx-border-color: grey;\n"
            + "-fx-border-insets: -7;\n"
            + "-fx-border-width: 1;\n"
            + "-fx-padding: 4, 4, 4, 4;\n"
            + "-fx-border-style: solid;\n";

    protected int currentLosning;
    protected int antLosninger;

    public GUI() {
        spillet = new Sudoku();
        event = new GUIevents(this);
        currentLosning = 0;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.window = primaryStage;
        this.window.setTitle("Sudoku Løser");

        lagStartMeny();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("ferdig" == evt.getPropertyName()) {
            spillet = (Sudoku) evt.getSource();
            System.out.println("GUI registrerte at SwingWorker er ferdig. Fullførte: " + spillet.ferdig());
            if (spillet.ferdig()) {
                Platform.runLater(new Runnable() {
                    public void run() {
                        lagSudokuMeny();
                        window.setScene(sudokuScene);
                        window.show();
                    }
                });
            }
        }
    }

    public void lagStartMeny() {
        //Oppretter elementer
        velgFilKnapp = new Button();
        startKnapp = new Button();
        label = new Text();
        startKnapp.setOnAction(event);
        velgFilKnapp.setOnAction(event);
        velgFilKnapp.setText("Velg fil");
        startKnapp.setText("Start");
        startKnapp.setDisable(true);

        HBox knappLayout = new HBox(40);
        knappLayout.getChildren().addAll(velgFilKnapp, startKnapp, label);

        //Layout sin layout
        BorderPane border = new BorderPane();
        border.setTop(lagMeny());
        border.setCenter(knappLayout);

        startScene = new Scene(border, 650, 250);
        window.setScene(startScene);
        window.setMinWidth(370);
        window.setMinHeight(350);

        window.show();
    }

    public void lagSudokuMeny() {

        antLosninger = spillet.getBeholder().hentAntallLosninger();
        long tid = spillet.getTid();
        ArrayList<Losning> losninger = spillet.getBeholder().getLosninger();
        this.losninger = new GridPane[antLosninger];

        int teller = 0;

        for (Losning losning : losninger) {

            int sisteR = 1;
            int sisteK = 1;

            GridPane losningPanel = new GridPane();

            this.losninger[teller++] = losningPanel;

            losningPanel.setGridLinesVisible(false); //debugg
            losningPanel.setAlignment(Pos.CENTER);
            losningPanel.setPadding(new Insets(10, 10, 10, 10));
            losningPanel.setVgap(4);
            losningPanel.setHgap(4);

            Rute[][] brett = losning.getLosning();

            for (int i = 0; i < brett.length; i++) {
                Rute[] sub = brett[i];
                for (int j = 0; j < sub.length; j++) {
                    String verdi = Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "";
                    Label tekst = new Label(verdi);

                    if (sub[j] instanceof FastRute ) {
                        tekst.setStyle("-fx-text-fill: black;");
                    }
                    else {
                        tekst.setStyle("-fx-text-fill: gray;");

                    }
                    tekst.setFont(Font.font(26));
                    tekst.setMinWidth(26);
                    tekst.setAlignment(Pos.CENTER);

                    //Setter Rute border
                    final HBox ruteBoks = new HBox();
                    ruteBoks.getChildren().add(tekst);
                    ruteBoks.setAlignment(Pos.CENTER);
                    ruteBoks.setStyle(cssRute);

                    losningPanel.setMargin(ruteBoks, new Insets(5, 5, 5, 5));
                    losningPanel.setConstraints(ruteBoks, (j + 1), (i + 1));

                    losningPanel.getChildren().add(ruteBoks);
                }
            }

            //Deler inn Bokser
            int N = spillet.RADER * spillet.KOLONNER;
            int cnt = 0;
            int dekket = 0;

            for (int i = 0; i < N; i++) {

                if (dekket == N ){
                    sisteR = sisteR + spillet.RADER;
                    sisteK = 1;
                    cnt = 0;
                    dekket = 0;
                }

                HBox pictureRegion = new HBox();
                pictureRegion.setStyle(cssBoks);
                losningPanel.add(pictureRegion, sisteK, sisteR, (spillet.KOLONNER), (spillet.RADER));
                dekket = dekket + spillet.KOLONNER;

                if (cnt / spillet.KOLONNER == 0) {
                    sisteK = sisteK + spillet.KOLONNER;
                }
                cnt++;
            }
        }


        //Info layout og pagination
        forrigeKnapp = new Button("Forrige");
        nesteKnapp = new Button("Neste");
        forrigeKnapp.setMinSize(70,25);
        nesteKnapp.setMinSize(70, 25);
        forrigeKnapp.setOnAction(event);
        nesteKnapp.setOnAction(event);
        antall = new Text();
        antall.setText("Viser: " + (currentLosning + 1) + "/" + antLosninger);
        Text tidTekst = new Text();
        tidTekst.setText(tid + "ms");
        forrigeKnapp.setDisable(true);
        if (!(antLosninger > 1))
            nesteKnapp.setDisable(true);

        HBox infoLayout = new HBox(40);
        infoLayout.setPadding(new Insets(10, 0, 0, 0));
        infoLayout.setAlignment(Pos.CENTER);
        infoLayout.getChildren().addAll(forrigeKnapp, antall, tidTekst, nesteKnapp);

        //Layout sin layout
        layout = new BorderPane();
        layout.setTop(lagMeny());
        layout.setCenter(infoLayout);
        try {
            layout.setBottom(this.losninger[0]);
        } catch (ArrayIndexOutOfBoundsException e){
            layout.setCenter(new Text("Ingen løsning. Velg nytt brett."));
        }

        sudokuScene = new Scene(layout);
    }

    private MenuBar lagMeny() {
        //Meny
        final Menu menu1 = new Menu("Fil");
        final Menu menu2 = new Menu("Info");

        MenuBar menuBar = new MenuBar();

        menu11 = new MenuItem("Åpne...");
        menu21 = new MenuItem("Om");

        menu1.getItems().add(menu11);
        menu2.getItems().add(menu21);
        menu11.setOnAction(event);
        menu21.setOnAction(event);

        menuBar.setUseSystemMenuBar(true); //OS X

        menuBar.getMenus().addAll(menu1, menu2);

        return menuBar;

    }

    public void visOm() {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(window);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text("Laget av Marius Christensen \nVåren 2015 i INF1010\nUiO"));
        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public void nesteLosning() {
        Platform.runLater(new Runnable() {
            public void run() {
                layout.setBottom(losninger[currentLosning + 1]);
                currentLosning++;
                antall.setText("Viser: " + (currentLosning + 1) + "/" + antLosninger);

                if (currentLosning > 0)
                    forrigeKnapp.setDisable(false);
                if ((currentLosning + 1) == antLosninger)
                    nesteKnapp.setDisable(true);

                window.show();
            }
        });
    }

    public void forrigeLosning() {
        Platform.runLater(new Runnable() {
            public void run() {
                layout.setBottom(losninger[currentLosning + -1]);
                currentLosning--;
                antall.setText("Viser: " + (currentLosning + 1) + "/" + antLosninger);

                if (currentLosning == 0) {
                    forrigeKnapp.setDisable(true);
                    nesteKnapp.setDisable(false);
                }

                window.show();
            }
        });
    }

    public void opneFil() {
        FileChooser jfc = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Txt fil (*.txt)", "*.txt");
        jfc.getExtensionFilters().add(extFilter);
        jfc.setTitle("Åpne");
        File fil = jfc.showOpenDialog(window);

        if(fil != null) {
            String path = fil.getAbsolutePath();

            event.fil = path;
            startKnapp.setDisable(false);
            spillet = new Sudoku();
            spillet.lesFil(event.fil);
            spillet.addPropertyChangeListener(this);
            currentLosning = 0;
            spillet.execute();

        }
    }
}



