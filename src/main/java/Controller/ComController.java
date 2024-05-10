package Controller;


import java.io.IOException;

import BBridge.Advertisement;
import BBridge.JobPosting;
import BBridge.Person;
import BBridge.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import main.BB;
import model.ADModel;
import model.BBModel;
import model.ViewTransitionalModel;

public class ComController {
	
	BBModel model;
	ADModel ad;
	public void setModel(BBModel newModel,ADModel ad)
	 {
		
	    model = newModel;
	    this.ad = ad;
	    comjoblist.setItems(model.getCompostjob());
	    comprolist.setItems(model.getCompostpro());
	    employeelist.setItems(model.getEmployeelist());
	    ADList.setItems(ad.getAllad());
	    descLabel.textProperty().bindBidirectional(model.comdesc);
	    nameLabel.textProperty().bindBidirectional((model.getComname()));



	  }

    @FXML
    private Button Editbutton;

    @FXML
    private ListView<JobPosting> comjoblist;

    @FXML
    private ListView<Advertisement> ADList;
    
    @FXML
    private Label descLabel;

    @FXML
    private ListView<Project> comprolist;

    @FXML
    private ListView<Person> employeelist;

    @FXML
    private Label nameLabel;

    @FXML
    void handleEditProfileButtonAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(BB.class.getResource("../main/Mainview.fxml"));
	    BorderPane view;
		try
		{
			view = loader.load();
    	    Maincontroller cont = loader.getController();
    	    ViewTransitionalModel vm =new ViewTransitionalModel(view,model,ad); 
    	    cont.setModel(vm);
    	    vm.showcomeditpage();
    	       
    	    Scene s = new Scene(view);
    	    model.stage.setScene(s);
    	    model.stage.show();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	

    }


}