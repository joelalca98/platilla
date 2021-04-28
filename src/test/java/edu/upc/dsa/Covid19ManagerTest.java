package edu.upc.dsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Covid19ManagerTest {

    @Before
    public void setUp(){

        Covid19ManagerImpl.getInstance().addBrote("Brote1");
        Covid19ManagerImpl.getInstance().addBrote("Brote2");
        Covid19ManagerImpl.getInstance().addCaso("Majo","garcia","CASO1",new Date(1998,6,4),new Date(2020,6,4),"confirmado","femenino","majogarcia@gmail.com","9842389","alado de casa" );



    }




    @After
    public void tearDown() { Covid19ManagerImpl.getInstance().delete();}



    @Test
    public void crearBrote(){
        Covid19ManagerImpl.getInstance().addBrote("Brote3");
        assertEquals(3,Covid19ManagerImpl.getInstance().sizeBrotes());


    }

    @Test
    public void addBrote() {
        Covid19ManagerImpl.getInstance().addCaso("Kevin","Alcalde","Brote2",new Date(1995,7,24),new Date(2020,6,4),"confirmado","masculino","kevin.alca@gmail.com","423423523","travLesCorts");
       assertEquals(2,Covid19ManagerImpl.getInstance().sizeCasos());

    }


}
