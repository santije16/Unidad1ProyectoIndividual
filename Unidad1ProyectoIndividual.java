/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.unidad1proyectoindividual;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Santiago Jiménez Escobar
 * Trabajo individual 1 – SANTIAGO JIMENEZ ESCOBAR

Problemática: Tener un control detallado de información sobre el desempleo y la calidad de vida de 
* las personas que permitan promover acciones en pro del crecimiento económico inclusivo 
* y sostenible de todos. Esta problemática estaría alineada con los objetivos de desarrollo sostenible.

Datos que se requieren
Nombre de la persona
Apellido de la persona
Edad
Genero
Estado laboral: Empleado, Desempleado, siendo empreado True, desempleado False.
Estrato: 1, 2, 3, 4, 5. Siendo 1 bajo, 2 medio bajo, 3 medio, 4 medio alto, 5 alto.
Numero de hijos
Nivel de Escolaridad: Primaria, Secundaria, Tecnico, Profesional
Salario devengado

Estructura de datos
Nombre de la persona – Tipo String
Apellido de la persona - Tipo String
Edad – Tipo Integer
Genero – Tipo Character
Estado laboral – Tipo boolean
Estrato – Tipo Integer
Número de hijos: Tipo Integer
Nivel de Escolaridad – Tipo Character
Salario devengado – Tipo Double

 */
public class Unidad1ProyectoIndividual {

    public static void main(String[] args) {
        record InformacionEmpleado(String nombres, String apellidos, Integer edad, Character genero, boolean estadoLaboral, Integer estrato, Integer numeroHijos,  String nivelEscolaridad, Double salario){
        }
        
        List<InformacionEmpleado> lista = new ArrayList<>();
        
        lista.add(new InformacionEmpleado("Pedro", "Carmona", 34, 'M', true, 3, 4, "Profesional", 2300000.13));
        lista.add(new InformacionEmpleado("Camilo", "Perez", 43, 'M', true, 4, 2, "Tecnico", 1500000.34));
        lista.add(new InformacionEmpleado("Maria", "Montoya", 24, 'F', false, 3, 1, "Tecnico",0D));
        lista.add(new InformacionEmpleado("Camila", "Jaramillo", 25, 'F', true, 5, 0, "Profesional", 4000000D));
        lista.add(new InformacionEmpleado("Sofia", "", 54, 'F', false, 1, 3, "Profesional", 0D));
        lista.add(new InformacionEmpleado("Pedro", "Escobar", 37, 'M', false, 3, 1, "Secundaria", 0D));
        lista.add(new InformacionEmpleado("Santiago", "Aristisabal", 19, 'M', false, 2, 1, "Primaria", 0D));
        lista.add(new InformacionEmpleado("Carolina", "Ortiz", 26, 'F', true, 2, 0, "Profesional", 2345666.32));
        lista.add(new InformacionEmpleado("Martha", "Gonzalez", 54, 'F', true, 1, 5, "Profesional", 3670000D));
        lista.add(new InformacionEmpleado("Gabriela", "Garcia", 42, 'F', false, 4, 2, "Primaria", 0D));
        lista.add(new InformacionEmpleado("Ragina", "Gonzalez", 34, 'F', true, 3, 4, "Profesional", 2300000.1));
        lista.add(new InformacionEmpleado("Sebastian", "Muñoz", 29, 'M', true, 3, 0, "Secundaria", 3988800D));
        lista.add(new InformacionEmpleado("Gladis", "Ocampo", 26, 'F', false, 2, 3, "Profesional", 0D));
        lista.add(new InformacionEmpleado("Socorro", "Jimenez", 18, 'F', true, 3, 0, "Primaria", 1160000D));
        lista.add(new InformacionEmpleado("Alirio", "Perez", 67, 'M', true, 5, 3, "Profesional", 5100000D));
        lista.add(new InformacionEmpleado("Camila", "Carmona", 34, 'F', true, 3, 4, "Profesional", 2300000.43));
        lista.add(new InformacionEmpleado("Manuela", "Gomez", 28, 'F', true, 4, 0, "Secundaria", 2000000D));
        lista.add(new InformacionEmpleado("Sofia", "Perez", 23, 'F', false, 2, 3, "Tecnico", 0D));
        lista.add(new InformacionEmpleado("Carlos", "Lopez", 32, 'M', true, 2, 5, "Tecnico", 1300000D));
        lista.add(new InformacionEmpleado("Santiago", "Gonzalez", 29, 'M', true, 3, 0, "Profesional", 2300000.54));
        
        System.out.println("GENERACION DE DATOS EN PANTALLA");
        int numTotalPersonas=0;
        for(InformacionEmpleado informacionEmpleado : lista) {
            System.out.println(informacionEmpleado.nombres +" "+ informacionEmpleado.apellidos+" | "+informacionEmpleado.edad
                    +" | "+informacionEmpleado.genero+" | "+informacionEmpleado.estadoLaboral+" | "+informacionEmpleado.estrato
                    +" | "+informacionEmpleado.numeroHijos+" | "+informacionEmpleado.nivelEscolaridad+" | "+informacionEmpleado.salario);
            numTotalPersonas += 1;
        }
        System.out.println();
        
        //GENERACION DE DATOS ESTADISTICOS
        
        // PROMEDIO DE EDAD, ESTRATO, NUMERO DE HIJOS Y SALARIO DE LAS PERSONAS
        BigDecimal promEdad = BigDecimal.ZERO;
        BigDecimal promEstrato = BigDecimal.ZERO;
        BigDecimal promNumHijos = BigDecimal.ZERO;
        BigDecimal promSalario = BigDecimal.ZERO;
        
        for(InformacionEmpleado informacionEmpleado : lista) {
            promEdad = promEdad.add(new BigDecimal(informacionEmpleado.edad));
            promEstrato = promEstrato.add(new BigDecimal(informacionEmpleado.estrato));
            promNumHijos = promNumHijos.add(new BigDecimal(informacionEmpleado.numeroHijos));
            promSalario = promSalario.add(new BigDecimal(informacionEmpleado.salario));
        }
        
        promEdad = promEdad.divide(BigDecimal.valueOf(numTotalPersonas));
        promEstrato = promEstrato.divide(BigDecimal.valueOf(numTotalPersonas));
        promNumHijos = promNumHijos.divide(BigDecimal.valueOf(numTotalPersonas));
        promSalario = promSalario.divide(BigDecimal.valueOf(numTotalPersonas));
        
        System.out.println("Del total de personas que equivale a "+numTotalPersonas+" personas, el promedio de edad es de "
                + ""+promEdad.setScale(0, RoundingMode.HALF_UP)+" años");
        System.out.println("Del total de personas que equivale a "+numTotalPersonas+" personas, el promedio de estrato es de "
                + ""+promEstrato.setScale(0, RoundingMode.HALF_UP));
        System.out.println("Del total de personas que equivale a "+numTotalPersonas+" personas, el promedio de numero de hijos es de "
                + ""+promNumHijos.setScale(0, RoundingMode.HALF_UP));
        System.out.println("Del total de personas que equivale a "+numTotalPersonas+" personas, el promedio de salario es de "
                + ""+promSalario.setScale(2, RoundingMode.HALF_UP)+" pesos Colombianos");
        
        
        //MODA DEL NIVEL DE ESTUDIO
        int contarPrimaria=0;
        int contarSecundaria=0;
        int contarTecnico=0;
        int ContarProfecional=0;
        for(InformacionEmpleado informacionEmpleado : lista) {
            if (informacionEmpleado.nivelEscolaridad.equals("Primaria")){
                contarPrimaria +=1;
            } else if (informacionEmpleado.nivelEscolaridad.equals("Secundaria")) {
                contarSecundaria +=1;
            } else if (informacionEmpleado.nivelEscolaridad.equals("Tecnico")) {
                contarTecnico +=1;
            } else {
                ContarProfecional += 1;
            }
        }
        
        String modaNivelEdu="";
        int mayorModa=0;
        if (contarPrimaria>contarSecundaria && contarPrimaria>contarTecnico && contarPrimaria>ContarProfecional){
            modaNivelEdu="Primaria";
            mayorModa = contarPrimaria;
        } else if (contarSecundaria>contarPrimaria && contarSecundaria>contarTecnico && contarSecundaria>ContarProfecional) {
            modaNivelEdu="Secundaria";
            mayorModa = contarSecundaria;
        } else if (contarTecnico>contarPrimaria && contarTecnico>contarSecundaria && contarTecnico>ContarProfecional) {
            modaNivelEdu="Tecnico";
            mayorModa = contarTecnico;
        } else {
            modaNivelEdu="Profecional";
            mayorModa = ContarProfecional;
        }
        System.out.println("Se puede concluir que del total de personas que equivalen a "+numTotalPersonas+", "
                + "la moda en cuando el nivel Educativo es "
                + ""+modaNivelEdu+" que equivale a "+mayorModa+" personas");
        
        
        //MEDIANA DE LA EDAD, ESTRATO Y NUMERO DE HIJOS
        List<Integer> listEdad = new ArrayList<>();
        List<Integer> listEstrato = new ArrayList<>();
        List<Integer> listNumHijos = new ArrayList<>();
        
        for(InformacionEmpleado informacionEmpleado : lista) {
            listEdad.add(informacionEmpleado.edad);
            listEstrato.add(informacionEmpleado.estrato);
            listNumHijos.add(informacionEmpleado.numeroHijos);
        }
        
        Collections.sort(listEdad);
        Collections.sort(listEstrato);
        Collections.sort(listNumHijos);
               
        int nEntre2;
        int nEntre2Mas1;
        Double medianaEdad;
        Double medianaEstrato;
        Double medianaNumHijos;
        nEntre2 = (numTotalPersonas/2)-1;
        nEntre2Mas1 = (numTotalPersonas/2);
        medianaEdad = (listEdad.get(nEntre2)+listEdad.get(nEntre2Mas1))/2D;
        medianaEstrato = (listEstrato.get(nEntre2)+listEstrato.get(nEntre2Mas1))/2D;
        medianaNumHijos = (listNumHijos.get(nEntre2)+listNumHijos.get(nEntre2Mas1))/2D;
        
        System.out.println("La mediana de la edad de las personas es "+medianaEdad);
        System.out.println("La mediana del estrato de las personas es "+medianaEstrato);
        System.out.println("La mediana del numero de hijos de las personas es "+medianaNumHijos);
        
        // PORCENTAJE DE HOMBRES Y DE MUJERES
        int contarHombres = 0;
        int contarMujeres = 0;
        double porcentajeHombres=0;
        double porcentajeMujeres=0;

        for(InformacionEmpleado informacionEmpleado : lista) {
            if (informacionEmpleado.genero.equals('M')) {
                contarHombres +=1;
            } else {
                contarMujeres +=1;
            }
        }
        
        porcentajeHombres = contarHombres/(double)(numTotalPersonas);
        porcentajeMujeres = contarMujeres/(double)numTotalPersonas;

        System.out.println("El total de personas que equivalen a "+numTotalPersonas+ ", el porcentaje de hombres"
                + " equivale a el "+(porcentajeHombres*100)+"% que equivale a " +contarHombres+ " hombres");
        System.out.println("El total de personas que equivalen a "+numTotalPersonas+ ", el porcentaje de mujeres"
                + " equivale a el "+(porcentajeMujeres*100)+"% que equivale a "+contarMujeres+ " mujeres");
    }
}
