package it.polito.tdp.extflightdelays.model;


public class VerticiPeso implements Comparable<VerticiPeso>{
	
	private String v1;
	private String v2;
	private int peso;
	
	
	public VerticiPeso(String v1, String v2, int peso) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.peso = peso;
	}


	public String getV1() {
		return v1;
	}


	public String getV2() {
		return v2;
	}


	public int getPeso() {
		return peso;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");
		builder.append(v1);
		builder.append("Stato: ");
		builder.append(v2);
		builder.append(" numero velivoli: ");
		builder.append(peso);
		return builder.toString();
	}


	@Override
	public int compareTo(VerticiPeso o) {
		int d1 = peso;
		int d2 = o.getPeso();
		
		if(d1<d2)
			return 1;
		else if(d1>d2)
			return -1;
		else
			return 0;

	}
	
	

}
