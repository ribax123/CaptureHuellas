/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funtions;

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;

public class Metho {

    public static void main(String[] args) {

        //Debugging
        Metho fecha = new Metho();
        String horaActual = fecha.MostrarHora();
        System.out.println(horaActual);
    }

    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();
    private String dia;
    private String mes;
    private String anio;
    public String horas;
    public String minutos;
    public String segundos;

    public void fechaActual(JLabel fecha) {

        Calendar c1 = Calendar.getInstance();
        
        dia = Integer.toString(c1.get(Calendar.DATE));
        mes = Integer.toString(c1.get(Calendar.MONTH));
        anio = Integer.toString(c1.get(Calendar.YEAR));

        int mees = Integer.parseInt(getMes());
        fecha.setText(getDia() + "/" + (mees + 1) + "/" + getAnio());

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

    public void diaSemana(JLabel diaa) {
        String DIA[] = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};

        Calendar calendario = Calendar.getInstance();

        String fecha = DIA[calendario.get(Calendar.DAY_OF_WEEK) - 1];

        diaa.setText(fecha);

    }

    public String HoraMilitar() {

        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    public void reloj(JLabel relojHora, JLabel diaa, JLabel fecha) {
        Thread hilo = new Thread() {
            public void run() {
                while (true) {
                    DateFormat hora = new SimpleDateFormat("HH:mm:ss");
                    String horaDos = hora.format(new Date()).toString();
                    relojHora.setText(horaDos);

                    diaSemana(diaa);
                    fechaActual(fecha);
                }
            }
        };
        hilo.start();
    }
}
