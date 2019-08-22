package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JDialog;

import aplicacao.Arquivo;
import aplicacao.Avrdude;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;

public class SampleController implements Initializable {

	/**
	 * fx:controller="application.SampleController"
	 */
	private final int FLASH = 1;
	private final int EEPROM = 2;
	@FXML
	private AnchorPane anchor;

	@FXML
	private Pane painelPrincipal;

	@FXML
	private AnchorPane painelCentral;

	@FXML
	private Text text1;

	@FXML
	private ComboBox<String> select1;

	@FXML
	private ComboBox<String> select2;

	@FXML
	private Text text2;

	@FXML
	private Text text3;

	@FXML
	private ComboBox<String> select3;

	@FXML
	private TextField inputhex;

	@FXML
	private Button searchhex;

	@FXML
	private Button gravarhex;

	@FXML
	private TextField inputeep;

	@FXML
	private Button searcheep;

	@FXML
	private Button gravareep;

	@FXML
	private TextArea output;
	
	@FXML
	private TitledPane titledpane1;
	 
	@FXML
	private TitledPane titledpane2;
	 
	@FXML
	private TitledPane titledpane3;
	
	@FXML
	private TitledPane titledpane4;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		// painelCentral.setBorder(new Border(new BorderStroke(Color.BLACK,
		// BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		
		Avrdude avrdude = new Avrdude();
		avrdude.listarGravadores();
		avrdude.listarUc();
		ObservableList<String> options = FXCollections.observableArrayList(avrdude.getListaDeGravadores());
		select1.setItems(options);
		select1.getSelectionModel().select(86);

		ObservableList<String> options2 = FXCollections.observableArrayList(avrdude.getListaDeUc());
		select2.setItems(options2);
		select2.getSelectionModel().select(56);

		ObservableList<String> options3 = FXCollections.observableArrayList(avrdude.getListaDePortas());
		select3.setItems(options3);
		select3.getSelectionModel().select(0);
		
		if(!avrdude.exists()) {
			Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Atenção");
            dialogoErro.setHeaderText("AVRDUDE!");
            dialogoErro.setContentText("Instale o avrdude v6.2 ou versão superior.");
            dialogoErro.showAndWait();
            System.exit(0);
		}
		
		
		searchhex.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Arquivo arquivo = new Arquivo();
				String path = arquivo.selecionarArquivo(FLASH);
				inputhex.setText(path);
			}
		});
		searcheep.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Arquivo arquivo = new Arquivo();
				String path = arquivo.selecionarArquivo(EEPROM);
				inputeep.setText(path);
			}
		});

		gravarhex.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				output.setText("Aguarde....");

				if (!inputhex.getText().isEmpty() && inputhex.getText() != "") {
					new Thread() {

						@Override
						public void run() {

							String path = inputhex.getText();
							String gravador = select1.getSelectionModel().getSelectedItem().toString();
							String microcontrolador = select2.getSelectionModel().getSelectedItem().toString();
							String porta = select3.getSelectionModel().getSelectedItem().toString();

							avrdude.setPorta(porta);
							avrdude.setGravador(gravador);
							avrdude.setMicrocontrolador(microcontrolador);
							avrdude.setArquivo(path);
							output.setText(avrdude.gravarArquivo(FLASH));

						}
					}.start();

				}else {
					Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
		            dialogoErro.setTitle("Atenção");
		            dialogoErro.setHeaderText("Erro ao carregar arquivo!");
		            dialogoErro.setContentText("Você precisa selecionar o arquivo a ser gravado.");
		            dialogoErro.showAndWait();
		            output.setText("");
				}
			}
		});

		gravareep.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				output.setText("Aguarde....");
				if (!inputeep.getText().isEmpty() && inputeep.getText() != "") {
					
					new Thread() {

						@Override
						public void run() {
							String path = inputeep.getText();
							String gravador = select1.getSelectionModel().getSelectedItem().toString();
							String microcontrolador = select2.getSelectionModel().getSelectedItem().toString();
							String porta = select3.getSelectionModel().getSelectedItem().toString();

							avrdude.setPorta(porta);
							avrdude.setGravador(gravador);
							avrdude.setMicrocontrolador(microcontrolador);
							avrdude.setArquivo(path);
							output.setText(avrdude.gravarArquivo(EEPROM));

						}
					}.start();

				}else {
					Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
		            dialogoErro.setTitle("Atenção");
		            dialogoErro.setHeaderText("Erro ao carregar arquivo!");
		            dialogoErro.setContentText("Você precisa selecionar o arquivo a ser gravado.");
		            dialogoErro.showAndWait();
		            output.setText("");
				}
			}
		});

	}

}
