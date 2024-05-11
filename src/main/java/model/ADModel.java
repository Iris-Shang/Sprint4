package model;

import java.util.ArrayList;

import org.springframework.web.client.RestClient;

import BBridge.Advertisement;
import BBridge.DSAD;
//import BBridge.Project;
//import BBridge.DSSkill; 
import BBridge.RDesc;
import BBridge.Reteam;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import BBridge.Skill;
import javafx.stage.Stage;

public class ADModel {
	public ArrayList<Advertisement> all;
	public Stage stage;
	StringProperty a1;
	StringProperty a2;
	ObservableList<Advertisement> allad = FXCollections.observableArrayList();
	
	public ADModel(Stage stage) 
	{
		this.all = readallAD();
		//this.allad.addAll(all);
		this.stage = stage;
		Advertisement a = all.get(0);
		Advertisement b = all.get(1);
		this.a1 =  new SimpleStringProperty(this,a.getContent(),a.getContent());
		this.a2 =  new SimpleStringProperty(this,b.getContent(),b.getContent());
		
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

	public StringProperty getA1() {
		return a1;
	}

	public void setA1(StringProperty a1) {
		this.a1 = a1;
	}

	public StringProperty getA2() {
		return a2;
	}

	public void setA2(StringProperty a2) {
		this.a2 = a2;
	}

	
	

}
