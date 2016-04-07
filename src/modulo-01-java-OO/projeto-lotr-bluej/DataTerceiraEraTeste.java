import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public  class DataTerceiraEraTeste {
	@Test
	public void EsteAnoDeveSerBissexto(){
		DataTerceiraEra data = new DataTerceiraEra(12,5,2016);
		assertEquals(true,data.ehBissexto());
	}
	@Test
	public void hojeEhDia(){
		DataTerceiraEra data = new DataTerceiraEra(7,4,2016);
		assertEquals(7,data.getDia());
		assertEquals(4,data.getMes());
		assertEquals(2016,data.getAno());
	}
	@Test
	public void Ano2100DeveSerBissexto(){
		DataTerceiraEra data = new DataTerceiraEra(12,5,2100);
		assertEquals(false,data.ehBissexto());
	}
	@Test
	public void Ano2002NaoDeveSerBissexto(){
		DataTerceiraEra data = new DataTerceiraEra(12,5,2002);
		assertEquals(false,data.ehBissexto());
	}
	@Test
	public void Ano416DeveSerBissexto(){
		DataTerceiraEra data = new DataTerceiraEra(12,5,416);
		assertEquals(true,data.ehBissexto());
	}
}