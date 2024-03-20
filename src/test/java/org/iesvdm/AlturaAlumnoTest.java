package org.iesvdm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AlturaAlumnoTest {
    @Test
    void aniadeNombreTest1() {
        //When
        final String[] array = new String[10];
        int longInicial = array.length;
        String nombre = "Maria";

        //Do
        array[0]="Jose";
        String[] arrayActual = AlturaAlumno.aniadeNombre(array,nombre);

        //Then
        assertEquals(longInicial + 1 , arrayActual.length);
        assertTrue(arrayActual[arrayActual.length-1].equals(nombre));
    }

    @Test
    void aniadeNombreTest2() {
        //When
        final String[] array = new String[0];
        int longInicial = array.length;
        String nombre = "Maria";

        //Do
        String[] arrayActual = AlturaAlumno.aniadeNombre(array, nombre);

        //Then
        assertEquals(longInicial + 1, arrayActual.length);
        assertTrue(arrayActual[arrayActual.length - 1].equals(nombre));
    }


    @Test
    void modificarAlturaAlumnoTest1() {
        //When
        double[] array = {1.6, 1.9, 1.78};
        double[] array2 = Arrays.copyOf(array, array.length);
        int posicion = 1;
        double altura = 1.87;

        //Do
        AlturaAlumno.modificaAltura(array,posicion,altura);

        //Then
        assertTrue(altura == array[posicion]);
        for (int i = 0; i < array.length; i++) {
            if (i != posicion){
                assertEquals(array[i], array2[i]);
            }
        }
    }

    @Test
    void modificarAlturaAlumnoTestPosicion() {
        //When
        double[] array = {1.6, 1.9, 1.78};
        double[] array2 = Arrays.copyOf(array, array.length);
        int posicion = array2.length-1;
        double altura = 1.87;

        //Do
        AlturaAlumno.modificaAltura(array,posicion,altura);

        //Then
        assertEquals(altura, array[posicion]);
        assertEquals(array.length, array2.length);
    }

    @Test
    void calculaMaximoTest1() {
        //When
        double[] array = {1.6, 1.9, 1.78, 1.95, 1.83};
        double[] res = {3, 1.95};

        //Do Then
        assertArrayEquals(res, AlturaAlumno.calculaMaximo(array));
    }

    @Test
    void calculaMaximoTest2() {
        //When
        double[] array = {};
        double[] res = {0, 0};

        //Do Then
        assertArrayEquals(res, AlturaAlumno.calculaMaximo(array));
    }

    @Test
    void calculaMediaTest1() {
        //When
        double[] array = {1.6, 1.9, 1.78, 1.95, 1.83};
        double media = 0;

        //Do
        for (double v : array) {
            media = media + v;
        }
        media = media / array.length;

        //Then
        assertEquals(media, AlturaAlumno.calculaMedia(array));
    }

    @Test
    void calculaMediaTest2() {
        //When
        double[] array = {};
        double media  = 0;

        //Do Then
        assertEquals(media, AlturaAlumno.calculaMedia(array));
    }

    @Test
    void buscaNombreTest1() {
        //When
        String[] array = {"Juan", "Pedro", "Luis", "Maria", "Ana"};
        String nombre = "Pepe";

        //Do Then
        assertEquals(-1, AlturaAlumno.buscaNombre(array, nombre));
    }

    @Test
    void buscaNombreTest2() {
        //When
        String[] array = {"Juan", "Ana", "Luis"};
        String nombre = "Ana";

        //Do Then
        assertEquals(1, AlturaAlumno.buscaNombre(array, nombre));
    }

    @Test
    void buscaNombreTest3() {
        //When
        String[] array = {};
        String nombre = "Ana";

        //Do Then
        assertEquals(-1, AlturaAlumno.buscaNombre(array, nombre));
    }

    @Test
    void buscaNombreTest4() {
        //When
        String[] array = {"Juan", "Pedro", "Luis", "Maria", "Ana"};
        String nombre = "";

        //Do Then
        assertEquals(-1, AlturaAlumno.buscaNombre(array, null));
        assertEquals(-1, AlturaAlumno.buscaNombre(array, nombre));
    }

    @Test
    void mostrarTest1() {
        //When
        String[] array = {"Maria", "Juan", "Luis"};
        double[] alturas = {1.6, 1.8, 1.78};

        //Do Then
        assertDoesNotThrow(() -> AlturaAlumno.mostrar(array, alturas));
    }

    @Test
    void mostrarTest2() {
        //When
        String[] array = {"Maria", "Juan", "Luis"};
        double[] alturas = {1.6, 1.8};

        //Do Then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> AlturaAlumno.mostrar(array, alturas));
    }
}