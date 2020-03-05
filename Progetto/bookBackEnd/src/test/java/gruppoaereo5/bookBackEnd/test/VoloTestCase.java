package gruppoaereo5.bookBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gruppoaereo5.bookBackEnd.dao.VoloDAO;
import gruppoaereo5.bookBackEnd.dto.Volo;

public class VoloTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static VoloDAO voloDAO;
	private Volo volo;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("gruppo5.bookBackEnd");
		context.refresh();
		
		voloDAO = (VoloDAO)context.getBean("voloDAO");
	}
	
	@Test
	public void testaddVolo() {
		volo = new Volo();
		volo.setCodice_volo("e1");
		volo.setAereo("fisa");
		volo.setCitta_partenza("Milano");
		volo.setCitta_arrivo("Roma");
		volo.setData_partenza("2010-02-12");
		volo.setData_arrivo("2010-02-12");
		volo.setOra_partenza("22:33:00");
		volo.setOra_arrivo("22:33:00");
		volo.setKmTratta(122.22);
		volo.setPrezzo(33.3);
		volo.setPuntiOttenuti(44);
		
		assertEquals("Successo!", true, voloDAO.add(volo));
	}
	

}
