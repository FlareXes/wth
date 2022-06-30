package com.fireflaredb.bds;

import com.fireflaredb.bds.Models.ViewsController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InsiderController implements Initializable {
    @FXML
    public Tab memberTab;
    @FXML
    public Tab publicTab;
    @FXML
    public TableView<ClusterTableView> publicTableView;
    public TableColumn snoCol;
    public TableColumn donerCol;
    public TableColumn contactCol;
    public TableColumn bgCol;
    public TableColumn ageCol;
    public TableColumn emailCol;
    public TableColumn addressCol;

    public ObservableList<ClusterTableView> getObservableList() throws RuntimeException {

        ArrayList<Object> clusterArrays = null;
        try {
            clusterArrays = new ViewsController().readCluster();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String id = "", age = "";
        String doner = "";
        String contact = "";
        String bg = "";
        String address = "";
        String email = "";

        for (Object userC : clusterArrays) {
            ArrayList<String> clusterArray = (ArrayList<String>) userC;
            id = clusterArray.get(1);
            age = clusterArray.get(1);
            contact = clusterArray.get(2);
            doner = clusterArray.get(3);
            bg = clusterArray.get(4);
            address = clusterArray.get(5);
            email = clusterArray.get(6);
        }

        return FXCollections.observableArrayList(
                new ClusterTableView(id, doner, contact, bg, age, email, address)
        );
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        memberTab.setDisable(!GlobalVariables.getUserVerified());

        snoCol.setCellValueFactory(new PropertyValueFactory<>("sno"));
        donerCol.setCellValueFactory(new PropertyValueFactory<>("doner"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        bgCol.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        ArrayList<Object> clusterArrays = null;
        try {
            clusterArrays = new ViewsController().readCluster();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String id = "";
        String age = "";
        String doner = "";
        String contact = "";
        String bg = "";
        String address = "";
        String email = "";
        ObservableList datos = FXCollections.observableArrayList();

        for (Object userC : clusterArrays) {
            ArrayList<String> clusterArray = (ArrayList<String>) userC;
            id = clusterArray.get(0);
            age = clusterArray.get(1);
            contact = clusterArray.get(2);
            doner = clusterArray.get(3);
            bg = clusterArray.get(4);
            address = clusterArray.get(5);
            email = clusterArray.get(6);
            datos.add(new ClusterTableView(id, doner, contact, bg, age, email, address));
        }
        publicTableView.setItems(datos);
    }
}
