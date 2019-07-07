package it.polito.tdp.extflightdelays.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.creaGrafo();
		
		System.out.println(model.ordinaVertici().toString());
		
		System.out.println(model.ResString("VT"));
	}

}
