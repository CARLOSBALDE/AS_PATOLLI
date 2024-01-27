package Logica;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;

public class Dados {

    boolean[] dados = new boolean[5];
    int contado = 0;

    public boolean[] TirarDados() {
        Random random = new Random();
        boolean variable1 = random.nextBoolean();
        boolean variable2 = random.nextBoolean();
        boolean variable3 = random.nextBoolean();
        boolean variable4 = random.nextBoolean();
        boolean variable5 = random.nextBoolean();

        dados[0] = variable1;
        dados[1] = variable2;
        dados[2] = variable3;
        dados[3] = variable4;
        dados[4] = variable5;

        return dados;
    }

    public int NumeroCañas() {
        TirarDados();

        for (int i = 0; i < dados.length; i++) {

            if (dados[i] == true) {
                contado++;
            }
        }

        return contado;
    }

    public int AvanzarCasillas() {
        
        contado=0;
        int con = NumeroCañas();

        if (con == 5) {
            return 10;

        }
        if (con == 0) {
            return 0;
        }

        return con;
    }

}
