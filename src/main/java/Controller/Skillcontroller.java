package Controller;

import model.ADModel;
import model.BBModel;
import model.ViewTransitionalModel;

import java.io.IOException;

import BBridge.Person;
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

public class Skillcontroller {

	
	BBModel model;
	ADModel ad;

    @FXML
    private Label Description;

    @FXML
    private Button Editbutton;

    @FXML
    private Label Namefield;

    @FXML
    private Label desclabel;
    @FXML
    private Label ADContent;

    @FXML
    private Button CloseADbutton;
    
    @FXML
    private ImageView image;
    
    @FXML
    private ListView<Person> skilledperson;

    @FXML
    private Label skinameLabel;
	public void setModel(BBModel newModel,ADModel ad)
	 {
		
	    model = newModel;
	    
	    //joblist.set
	   // Bindings.bindBidirectional(companyLabel.textProperty(),model.getCompany());
	   
	    skinameLabel.textProperty().bindBidirectional((model.getSkillname()));
	    desclabel.textProperty().bindBidirectional(model.getSkilldesc());
	    skilledperson.setItems(model.getSkilled());
	    this.ad = ad;
	    Image ima = new Image("https://t4.ftcdn.net/jpg/03/81/61/81/240_F_381618165_HFOJlcFKU6SwArADMkKNrZaHLde3IPLP.jpg");
	    image.setImage(ima);
	    ADContent.textProperty().bindBidirectional(ad.getA2());
	    image.setVisible(true);
	    ADContent.setVisible(true);
	    this.CloseADbutton.setVisible(true);
	  }
    @FXML
    void ClickonClose(ActionEvent event) {
    	ADContent.setVisible(false);
    	image.setVisible(false);
    	CloseADbutton.setVisible(false);

    }
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
    	    vm.showskilleditpage();
    	       
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
