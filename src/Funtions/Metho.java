/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funtions;

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import javax.swing.SwingUtilities;
import Formulario.CapturahuellaDigital;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabian Andres
 */
public class Metho{

    public static void main(String[] args) {

        //Debugging
        Metho fecha = new Metho();

        String feActual = fecha.fechaActual();
        String horaActual = fecha.MostrarHora();
        System.out.println(feActual);
        System.out.println(horaActual);
    }
     private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();
    private String dia;
    private String mes;
    private String anio;
    public String horas;
    public String minutos;
    public String segundos;

    public String fechaActual() {

        Calendar c1 = Calendar.getInstance();
        dia = Integer.toString(c1.get(Calendar.DATE));
        mes = Integer.toString(c1.get(Calendar.MONTH));
        anio = Integer.toString(c1.get(Calendar.YEAR));

        int mees = Integer.parseInt(getMes());
        return getDia() + "/" + (mees + 1) + "/" + getAnio();

    }

    public String Anio() {

        Calendar anios = Calendar.getInstance();
        anio = Integer.toString(anios.get(Calendar.YEAR));
        return anio;
    }

    public String Mes() {

        Calendar mess = Calendar.getInstance();
        mes = Integer.toString(mess.get(Calendar.MONTH));
        int mesid = Integer.parseInt(getMes());
        int mes = Integer.parseInt(getMes()) + 1;
        String ms = String.valueOf(mes);
        return ms;
    }

    public String Dia() {

        Calendar dias = Calendar.getInstance();
        dia = Integer.toString(dias.get(Calendar.DATE));
        return dia;
    }

    public String MostrarHora() {

        Calendar c1 = Calendar.getInstance();
        horas = Integer.toString(c1.get(Calendar.HOUR));
        minutos = Integer.toString(c1.get(Calendar.MINUTE));
        segundos = Integer.toString(c1.get(Calendar.SECOND));

        return horas + ":" + minutos + ":" + segundos;
    }
    
    

    public void NombreHuella() {
       
      
    }
    

    public void MostrarNombre() {

    }

    public String getDia() {
        return dia;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @return the anio
     */
    public String getAnio() {
        return anio;
    }

}
