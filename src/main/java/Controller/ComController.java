package Controller;


import java.io.IOException;

//import BBridge.Advertisement;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	    
	    comjoblist.setItems(model.getCompostjob());
	    comprolist.setItems(model.getCompostpro());
	    employeelist.setItems(model.getEmployeelist());
	    descLabel.textProperty().bindBidirectional(model.comdesc);
	    nameLabel.textProperty().bindBidirectional((model.getComname()));
	    this.ad = ad;
	    Image ima = new Image("https://t4.ftcdn.net/jpg/03/81/61/81/240_F_381618165_HFOJlcFKU6SwArADMkKNrZaHLde3IPLP.jpg");
	    image.setImage(ima);
	    ADContent.textProperty().bindBidirectional(ad.getA1());
	    image.setVisible(true);
	    ADContent.setVisible(true);
	    this.CloseADbutton.setVisible(true);
	    



	  }

    @FXML
    private Button Editbutton;

    @FXML
    private ListView<JobPosting> comjoblist;

    @FXML
    private Label ADContent;

    @FXML
    private Button CloseADbutton;
    
    @FXML
    private ImageView image;
    
    @FXML
    private Label descLabel;

    @FXML
    private ListView<Project> comprolist;

    @FXML
    private ListView<Person> employeelist;

    @FXML
    private Label nameLabel;
    
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