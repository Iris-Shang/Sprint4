package Controller;

import java.io.IOException;
//import java.util.ArrayList;

import BBridge.Person;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.BB;
import model.ADModel;
import model.BBModel;
import model.ViewTransitionalModel;
import javafx.scene.input.MouseEvent;

public class LoginController {
    BBModel model;
    ADModel ad;
    

    public void setModel(BBModel model,ADModel ad) {
    	this.model = model;
    	this.ad = ad;
    }
    @FXML
    private Button loginbutton;

    @FXML
    private TextField useridarea;

    @FXML
    private PasswordField userpasswordarea;

    @FXML
    public void handleLoginButtonAction() {
    	
    	
        // Handle login logic here
        Integer userId = Integer.parseInt(useridarea.getText());
        String password = userpasswordarea.getText();

        // Validate user credentials and go on
        
        if (isValidUser(userId, password)) {
            // Navigate to the next view (e.g., User Personal view)
        	
            System.out.println("Login successful. Redirecting to User Personal view...");
            FXMLLoader loader = new FXMLLoader();
    	    loader.setLocation(BB.class.getResource("../main/Mainview.fxml"));
    	    BorderPane view;
			try
			{
				view = loader.load();
	    	    Maincontroller cont = loader.getController();
	    	    ViewTransitionalModel vm =new ViewTransitionalModel(view,model,ad); 
	    	    cont.setModel(vm);
	    	    vm.showpage1();
	    	       
	    	    Scene s = new Scene(view);
	    	    model.stage.setScene(s);
	    	    model.stage.show();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            
        } else {
            // Display error message or handle invalid credentials
            System.out.println("Invalid credentials. Please try again.");
        }
    }
    

    @FXML
    void clickonuseridarea(MouseEvent event) {
    	useridarea.clear();
    }

    @FXML
    void clickonuserpasswordarea(MouseEvent event) {
    	userpasswordarea.clear();
    }

    private boolean isValidUser(Integer userId, String password)
	{
		Person user = this.model.p.findanperson(userId);
		if (user == null) {
			System.out.println("Userwrong. Please try again.");
			return false;}
		if (!user.getPassword().equals(password)) 
		{
			 System.out.println("Password wrong. Please try again.");
			return false;
		}
		this.model.p = user;
		return true; 
	}


}