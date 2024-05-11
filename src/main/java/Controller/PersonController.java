package Controller;

import java.io.IOException;

import BBridge.JobPosting;
import BBridge.Project;
import BBridge.Skill;
//import javafx.beans.binding.Bindings;
//import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.BB;
import model.ADModel;
import model.BBModel;
import model.ViewTransitionalModel;

public class PersonController
{
	
	BBModel model;
	ADModel ad;
	public void setModel(BBModel newModel,ADModel ad)
	 {
		
	    model = newModel;
	    //companyLabel.setText(model.getCompany());
	    joblist.setItems(model.getJoblist());
	    projectlist.setItems(model.getProlist());
	    skillslist.setItems(model.getSkilllist());
	    //joblist.set
	   // Bindings.bindBidirectional(companyLabel.textProperty(),model.getCompany());
	    companyLabel.textProperty().bindBidirectional((model.getCompany()));
	    nameLabel.textProperty().bindBidirectional(model.getName());
	    occupatationlabel.textProperty().bindBidirectional(model.getOccupatation());
	    this.ad = ad;
	    Image ima = new Image("https://t4.ftcdn.net/jpg/03/81/61/81/240_F_381618165_HFOJlcFKU6SwArADMkKNrZaHLde3IPLP.jpg");
	    image.setImage(ima);
	    ADContent.textProperty().bindBidirectional(ad.getA2());
	    image.setVisible(true);
	    ADContent.setVisible(true);
	    this.CloseADbutton.setVisible(true);
 
	  }
    @FXML
    private Button Editbutton;

    @FXML
    private Label companyLabel;

    @FXML
    private ListView<JobPosting> joblist;

    @FXML
    private Label nameLabel;

    @FXML
    private Label ADContent;

    @FXML
    private Button CloseADbutton;
    
    @FXML
    private ImageView image;
    @FXML
    private Label occupatationlabel;
 
    @FXML
    private ListView<Project> projectlist;

    @FXML
    private ListView<Skill> skillslist;
    @FXML
    void ClickonClose(ActionEvent event) {
    	ADContent.setVisible(false);
    	image.setVisible(false);
    	CloseADbutton.setVisible(false);

    }
    @FXML
    void handleEditProfileButtonAction(ActionEvent event) {
    	projectlist.setEditable(true);
    	skillslist.setEditable(true);
    	joblist.setEditable(true);
        FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(BB.class.getResource("../main/Mainview.fxml"));
	    BorderPane view;
		try
		{
			view = loader.load();
    	    Maincontroller cont = loader.getController();
    	    ViewTransitionalModel vm =new ViewTransitionalModel(view,model,ad); 
    	    cont.setModel(vm);
    	    vm.showpersoneditpage();
    	       
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
