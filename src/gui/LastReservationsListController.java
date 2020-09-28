package gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import facade.Facade;
import gui.listeners.DataChangeListener;
import gui.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Reservation;

public class LastReservationsListController implements Initializable, DataChangeListener {

	private ObservableList<Reservation> obsList;

	@FXML
	private TableView<Reservation> tableViewReservation;

	@FXML
	private TableColumn<Reservation, String> tableColumnId;
	
	@FXML
	private TableColumn<Reservation, LocalDate> tableColumnReservationDate;
	
	@FXML
	private TableColumn<Reservation, String> tableColumnUser;

	@FXML
	private TableColumn<Reservation, String> tableColumnBook;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		iniatializeNodes();
	}

	private void iniatializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnReservationDate.setCellValueFactory(new PropertyValueFactory<>("reservationDate"));
		Utils.formatTableColumnDate(tableColumnReservationDate, "dd/MM/yyyy");
		tableColumnUser.setCellValueFactory(new PropertyValueFactory<>("userName"));
		tableColumnBook.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));

		var stage = (Stage) Main.getMainScene().getWindow();
		tableViewReservation.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateTableView() {

		Facade.inicializar();
		List<Reservation> list = Facade.listLastReservations();
		obsList = FXCollections.observableArrayList(list);
		tableViewReservation.setItems(obsList);
		Facade.finalizar();
	}

	
	@Override
	public void onDataChanged() {
		updateTableView();
	}

}
