import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DwarfTest
{
    private final double DELTA = 0.0;
    @Test
    public void verificaVida(){
        Dwarf dwarf=new Dwarf("dwarf");
        assertEquals(110,dwarf.getVida(),DELTA);
    } 
    @Test
    public void verificaNome(){
        Dwarf dwarf=new Dwarf("dwarf");
        assertEquals("dwarf",dwarf.getNome());
    } 
    @Test
    public void perdeVida(){
        DataTerceiraEra meuAniversario = new DataTerceiraEra(1,2,2025);
        Dwarf dwarf=new Dwarf("dwarf",meuAniversario);
        dwarf.perderVida();
        assertEquals(100,dwarf.getVida(),DELTA);
    }
    @Test
    public void dwarfNasceVivo(){
        Dwarf dwarf=new Dwarf("Balin");
        assertEquals(Status.VIVO,dwarf.getStatus());
    }
    @Test
    public void TomeiFlechadaEMorri(){
        Dwarf dwarf = new Dwarf("Batman");
        dwarf.perderVida();
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida();      
        assertEquals(Status.MORTO,dwarf.getStatus());
    }
    @Test
    public void perdeuMaisDoQueDevia(){
        Dwarf dwarf=new Dwarf("Robin");
        dwarf.perderVida();
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida();
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 
        dwarf.perderVida(); 

        assertEquals(Status.MORTO,dwarf.getStatus());
        assertEquals(0,dwarf.getVida(),DELTA);
    }  
    @Test
    public void recebiExpPorTomar3Flechada(){
        DataTerceiraEra meuAniversario = new DataTerceiraEra(1,2,2016);
        Dwarf dwarf=new Dwarf("dwarf",meuAniversario);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        assertEquals(2,dwarf.getExp());
        assertEquals(90,dwarf.getVida(),DELTA);
    }
    @Test
    public void godMod(){
        DataTerceiraEra meuAniversario = new DataTerceiraEra(1,2,2015);
        Dwarf dwarf=new Dwarf("Seixas",meuAniversario);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        assertEquals(110,dwarf.getVida(),DELTA);
        assertEquals(0,dwarf.getExp());
    }
    @Test
    public void adicionarUmItemInventario() {
        Dwarf dwarf = new Dwarf("dwarf");
        Item espada = new Item(1, "espada");
        dwarf.adicionarItem(espada);
        assertEquals(espada, dwarf.getInventario().getItens().get(0));
        assertEquals(1, dwarf.getInventario().getItens().size());
    }
    @Test
    public void adicionarDoisItensNoInventario() {
        Dwarf dwarf = new Dwarf("dwarf");
        Item escudo = new Item(1, "Escudo");
        Item adagas = new Item(3, "Adagas");
        dwarf.adicionarItem(escudo);
        dwarf.adicionarItem(adagas);
        assertEquals(escudo, dwarf.getInventario().getItens().get(0));
        assertEquals(adagas, dwarf.getInventario().getItens().get(1));
        assertEquals(2, dwarf.getInventario().getItens().size());
    }
    @Test
    public void adicionarItemEPerderNoInventario() {
        Dwarf dwarf = new Dwarf("dwarf");
        Item escudo = new Item(1, "Escudo");
        dwarf.adicionarItem(escudo);
        dwarf.perderItem(escudo);
        assertEquals(0, dwarf.getInventario().getItens().size());
    }
    @Test
    public void dwarfNascimentoDefault() {
        Dwarf dwarf = new Dwarf("dwarf");
        assertEquals(1, dwarf.getDataNascimento().getDia());
        assertEquals(1, dwarf.getDataNascimento().getMes());
        assertEquals(1, dwarf.getDataNascimento().getAno());
    }    
    @Test
    public void dwarfComDataNascimento() {
        Dwarf dwarf = new Dwarf("dwarf", new DataTerceiraEra(20, 8, 1876));
        assertEquals(20, dwarf.getDataNascimento().getDia());
        assertEquals(8, dwarf.getDataNascimento().getMes());
        assertEquals(1876, dwarf.getDataNascimento().getAno());
    }    
    @Test
    public void dwarfNascimentoNulo() {
        Dwarf dwarf = new Dwarf("dwarf", null);
        assertNull(dwarf.getDataNascimento());
    }    
    @Test
    public void gerarNumeroAnoBissextoVidaEntre80e90() {
        Dwarf fabricin = new Dwarf("Fabricin", new DataTerceiraEra(01, 01, 2016));
        fabricin.perderVida();
        fabricin.perderVida();
        fabricin.perderVida(); 

    }    
    @Test
    public void gerarNumeroAnoNaoBissextoNomeSeixas() {
        Dwarf meireles = new Dwarf("Meireles", new DataTerceiraEra(01, 01, 2015));
        assertEquals(33.0, meireles.getNumeroSorte(), 0.00001);
    }    
    @Test
    public void gera101() {
        Dwarf dwarf = new Dwarf("dwarf");
        assertEquals(101.0, dwarf.getNumeroSorte(), 0.00001);
    }    
    @Test
    public void dwarfRecebeFlechaComNumeroSorteNegativo() {
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,1,2000));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        assertEquals(2, dwarf.getExp());
        assertEquals(90, dwarf.getVida(), DELTA);   
    }
    @Test
    public void dwarfSoFlechada(){
        Dwarf dwarf = new Dwarf("dwarf");
        dwarf.perderVida();
        assertEquals(100, dwarf.getVida(), DELTA);
        assertEquals(0, dwarf.getExp());
    }
    @Test
    public void tenhoUmEscudoEAdagasPrint(){
        Dwarf dwarf = new Dwarf("dwarf");
        Item escudo = new Item(1, "Escudo");
        Item adagas = new Item(3, "Adagas");
        dwarf.adicionarItem(escudo);
        dwarf.adicionarItem(adagas);
        assertEquals("Escudo,Adagas", dwarf.getInventario().getDescricoesItens());
    }
    @Test
    public void tireiSorte(){
        DataTerceiraEra nasci = new DataTerceiraEra(1,4,2016);
        Dwarf dwarf = new Dwarf("dwarf",nasci);
        Item escudo = new Item(1, "Escudo");
        Item adagas = new Item(3, "Adagas");
        dwarf.adicionarItem(escudo);
        dwarf.adicionarItem(adagas);
        for(int i=0;i<5;i++){
            dwarf.perderVida();            
        }
        dwarf.tentarSorte();
        assertEquals(1001,dwarf.getInventario().getItens().get(0).getQuantidade());
        assertEquals(1003,dwarf.getInventario().getItens().get(1).getQuantidade());
    }
    @Test
    public void naoTireiSorte(){
        DataTerceiraEra nasci = new DataTerceiraEra(1,4,2015);
        Dwarf dwarf = new Dwarf("dwarf",nasci);
        Item escudo = new Item(1, "Escudo");
        Item adagas = new Item(3, "Adagas");
        dwarf.adicionarItem(escudo);
        dwarf.adicionarItem(adagas);
        for(int i=0;i<5;i++){
            dwarf.perderVida();            
        }
        dwarf.tentarSorte();
        assertEquals(1,dwarf.getInventario().getItens().get(0).getQuantidade());
        assertEquals(3,dwarf.getInventario().getItens().get(1).getQuantidade());
    }
    @Test
    public void tenhoMaisAdagas(){
        Dwarf dwarf = new Dwarf("dwarf");
        Item escudo = new Item(1, "Escudo");
        Item adagas = new Item(3, "Adagas");
        dwarf.adicionarItem(escudo);
        dwarf.adicionarItem(adagas);
        assertEquals(adagas, dwarf.getInventario().retornaMaiorQuant());
    }
    @Test
    public void soIqual(){
        Dwarf dwarf = new Dwarf("dwarf");
        Item escudo = new Item(1, "Escudo");
        Item adagas = new Item(1, "Adagas");
        Item peitoral = new Item(1, "Peitoral");
        dwarf.adicionarItem(escudo);
        dwarf.adicionarItem(adagas);
        dwarf.adicionarItem(peitoral);
        assertEquals("Peitoral", dwarf.getInventario().retornaMaiorQuant().getDescricao());
    }
    @Test
    public void ordenandoItens(){
        Dwarf dwarf = new Dwarf("dwarf");
        Item escudo = new Item(3, "Escudo");
        Item adagas = new Item(5, "Adagas");
        Item peitoral = new Item(1, "Peitoral");
        dwarf.adicionarItem(escudo);
        dwarf.adicionarItem(adagas);
        dwarf.adicionarItem(peitoral);
        assertEquals("Escudo,Adagas,Peitoral", dwarf.getInventario().getDescricoesItens());
        dwarf.getInventario().ordenarItens();
        assertEquals("Peitoral,Escudo,Adagas", dwarf.getInventario().getDescricoesItens());
    }
    @Test
    public void primeiroDwarfTemMenosVida(){
        Dwarf dwarf1 = new Dwarf("dwarf");
        Dwarf dwarf2 = new Dwarf("dwarf");
        dwarf1.perderVida();
        assertEquals(dwarf1,Dwarf.descobrirMenosVida(dwarf1,dwarf2));        
    }
    @Test
    public void segundoDwarfTemMenosVida(){
        Dwarf dwarf1 = new Dwarf("dwarf");
        Dwarf dwarf2 = new Dwarf("dwarf");
        dwarf2.perderVida();
        assertEquals(dwarf2,Dwarf.descobrirMenosVida(dwarf1,dwarf2));        
    }
    @Test
    public void dwafrsTemMesmaVida(){
        Dwarf dwarf1 = new Dwarf("dwarf");
        Dwarf dwarf2 = new Dwarf("dwarf");
        assertEquals(dwarf2,Dwarf.descobrirMenosVida(dwarf1,dwarf2));        
    }
}
