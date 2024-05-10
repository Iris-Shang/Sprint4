package model;

import java.util.ArrayList;

import org.springframework.web.client.RestClient;

import BBridge.Advertisement;
import BBridge.DSAD;
//import BBridge.Project;
//import BBridge.DSSkill; 
import BBridge.RDesc;
import BBridge.Reteam;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import BBridge.Skill;
import javafx.stage.Stage;

public class ADModel {
	public ArrayList<Advertisement> all;
	public Stage stage;
	ObservableList<Advertisement> allad = FXCollections.observableArrayList();
	
	public ADModel(Stage stage) 
	{
		this.all = readallAD();
		this.allad.addAll(all);
		this.stage = stage;
	}
	
	public ArrayList<Advertisement> readallAD()
	{
		ArrayList<Advertisement> a = new ArrayList<Advertisement>();
		RestClient client = RestClient.create();
		String uriBase = "http://localhost:9000/v1/Project1/Advertisement";

		Reteam persons = client.get()
				  .uri(uriBase)
				  .retrieve()
				  .body(Reteam.class);
		ArrayList<RDesc> rdsec= persons.data();
		for (RDesc i : rdsec) 
		{
			String urib = i.location();
			DSAD read = client.get()
					  .uri(urib)
					  .retrieve()
					  .body(DSAD.class);

			a.add(read.data());
		

		}
		return a;
	}
	public void update() 
	{
		this.all = readallAD();
		this.allad.addAll(all);
		
	}

	public ArrayList<Advertisement> getAll() {
		return all;
	}

	public void setAll(ArrayList<Advertisement> all) {
		this.all = all;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public ObservableList<Advertisement> getAllad() {
		return allad;
	}

	public void setAllad(ObservableList<Advertisement> allad) {
		this.allad = allad;
	}
	
	

}
