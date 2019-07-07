package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private DirectedWeightedPseudograph<String , DefaultWeightedEdge> graph;
	private ExtFlightDelaysDAO dao;
	
	
	public Model() {
		
		this.graph = new DirectedWeightedPseudograph<>(DefaultWeightedEdge.class);
		this.dao = new ExtFlightDelaysDAO();
	}

	
	public void creaGrafo() {
		
		Graphs.addAllVertices(this.graph, dao.loadAllStates());
		System.out.println("vertici creati: " + this.graph.vertexSet().size());
		
		for ( VerticiPeso vp : dao.loadVerticiPeso()) {
			
			Graphs.addEdge(this.graph, vp.getV1(), vp.getV2(), vp.getPeso());
			
		}
		System.out.println("archi creati: " + this.graph.edgeSet().size());

	}
	
		
	public Collection<String> ordinaVertici() {
//		List<String> res= new ArrayList<>();
		
		TreeMap<String , String> map = new TreeMap<>();
		
		for (String string : this.graph.vertexSet()) {
			
			map.put(string, string);
			
		}
		return map.keySet();
	}
	
	
	
	public List<VerticiPeso> output(String stato){
		
		List<VerticiPeso> res = new ArrayList<>();
		List<VerticiPeso> list = dao.loadVerticiPeso();
		
		for (VerticiPeso verticiPeso : list) {
			if(stato.compareTo(verticiPeso.getV1())==0) {
				res.add(verticiPeso);
			}
			
		}
		return res;
	}


	public String ResString (String stato) {
		StringBuilder builder = new StringBuilder();
    	List<VerticiPeso> list = output(stato);
    	Collections.sort(list);
//    	builder.append(list.get(0).getV1());
    	builder.append(stato);
    	builder.append("\n");

    	
    	for (VerticiPeso verticiPeso : list) {
    		builder.append("stato adiacente: ");
    		builder.append(verticiPeso.getV2());
    		builder.append("\n");
    		builder.append("numero velivoli: ");
    		builder.append(verticiPeso.getPeso());
    		builder.append("\n");
    		builder.append("\n");

    	}
		return     	builder.toString();
	}

	

}
