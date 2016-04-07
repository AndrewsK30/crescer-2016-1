class DataTerceiraEra {
	private int dia;
	private int mes;
	private int ano;
	//exe 1.2 e 1.1
	public DataTerceiraEra (int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	// exe 1.1
	public int getDia(){
		return dia;
	}
	public int getMes(){
		return mes;
	}
	public int getAno(){
		return ano;
	}
	public boolean ehBissexto(){
	return ano%4==0;
	}
}
