package Controller;

//import BBridge.Advertisement;
import BBridge.Entity;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.ADModel;
import model.BBModel;

public class EntityController
{
	BBModel model;
	ADModel ad;
    @FXML
    private ListView<Entity> Entitylistview;
	public void setModel(BBModel newModel,	ADModel ad)
	 {
		this.ad = ad;
	    model = newModel;
	    Entitylistview.setItems(model.getEntlist());
	 //   System.exit(1);
	 }

}
