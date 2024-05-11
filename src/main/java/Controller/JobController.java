package Controller;
import java.io.IOException;

import BBridge.Person;
import BBridge.Skill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import main.BB;
import model.ADModel;
import model.BBModel;
import model.ViewTransitionalModel;

public class JobController
{
	BBModel model;
	ADModel ad;
	public void setModel(BBModel newModel,ADModel ad)
	 {
	    model = newModel;
	    skilllist.setItems(model.getJobskilllist());
	    skilllist.setEditable(false);
	    appliedpersonlist.setItems(model.getJobapplist());
	    descriptionlabel.textProperty().bindBidirectional(model.getJobdescription());
	    nameLabel.textProperty().bindBidirectional(model.getJobname());
	    companylabel.textProperty().bindBidirectional((model.getJobCompany()));
	    this.ad = ad;
	    Image ima = new Image("https://t4.ftcdn.net/jpg/03/81/61/81/240_F_381618165_HFOJlcFKU6SwArADMkKNrZaHLde3IPLP.jpg");
	    image.setImage(ima);
	    ADContent.textProperty().bindBidirectional(ad.getA1());
	    image.setVisible(true);
	    ADContent.setVisible(true);
	    this.CloseADbutton.setVisible(true);
	 }

    @FXML
    private ListView<Person> appliedpersonlist;
    
    @FXML
    private ImageView image;
    @FXML
    private Label companylabel;
    @FXML
    private Label ADContent;

    @FXML
    private Button CloseADbutton;
    @FXML
    private Label descriptionlabel;

    @FXML
    private Button editbutton;

    @FXML
    private Label nameLabel;

    @FXML
    private ListView<Skill> skilllist;
    
    @FXML
    void ClickonClose(ActionEvent event) {
    	ADContent.setVisible(false);
    	image.setVisible(false);
    	CloseADbutton.setVisible(false);

    }
    @FXML
    void editbuttononclick(ActionEvent event) {
    	//skilllist.setEditable(true);
        FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(BB.class.getResource("../main/Mainview.fxml"));
	    BorderPane view;
		try
		{
			view = loader.load();
    	    Maincontroller cont = loader.getController();
    	    ViewTransitionalModel vm =new ViewTransitionalModel(view,model,ad); 
    	    cont.setModel(vm);
    	    vm.showjobeditpage();
    	       
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
