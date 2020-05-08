import java.util.Arrays;

public class Reconocedor {
    
    private final char[] L = {'a','b','c', 'd','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                        'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','$','_'};
    private final char[] N = {'0','1','2','3','4','5','6','7','8','9'};
    private final char[] S = {'-','+'};
    private final char[] E = {'e', 'E'};

    private final int[] F = {1,2,3,4}; //conjunto de estados finales
    private final int q0 = 5;
    private int estado;
    private int index;

    public Reconocedor(){
        Arrays.sort(L);
        Arrays.sort(N);
        Arrays.sort(S);
        Arrays.sort(E);
        estado = q0;
    }

    private boolean isL(char c){
        return Arrays.binarySearch(L, c) >= 0;
    }

    public boolean isN(char c){
        return Arrays.binarySearch(N, c) >= 0;
    }

    public boolean isS(char c){
        return Arrays.binarySearch(S, c) >= 0;
    }

    public boolean isE(char c){
        return Arrays.binarySearch(E, c) >= 0;
    }

    private boolean pertenece(char c){
        boolean r = true;

        switch (estado){
            case 1:
                if(isN(c) || isL(c))
                    estado = 1;
                else
                    r = false;
                break;
            case 2:
                if(isN(c))
                    estado = 2;
                else if(c == '.')
                    estado = 7;
                else
                    r = false;
                break;
            case 3:
                if(isN(c))
                    estado = 3;
                else if(isE(c))
                    estado = 8;
                else
                    r = false;
                break;
            case 4:
                if (isN(c))
                    estado = 4;
                else
                    r = false;
                break;
            case 5:
                if(isL(c))
                    estado = 1;
                else if(isS(c))
                    estado = 6;
                else {
                    estado = 6;
                    index--;
                }
                break;
            case 6:
                if(isN(c))
                    estado = 2;
                else
                    r = false;
                break;
            case 7:
                if (isN(c))
                    estado = 3;
                else
                    r = false;
                break;
            case 8:
                if(isS(c))
                    estado = 9;
                else {
                    estado = 9;
                    index--;
                }
                break;
            case 9:
                if(isN(c))
                    estado = 4;
                else
                    r = false;
        }

        return r;
    }

    public boolean reconocer(String cadena){
        estado = q0;

        for (index = 0; index < cadena.length(); index++) {
            char c = cadena.charAt(index);
            if (!pertenece(c))
                return false;
        }


        for (int aceptado : F)
            if (estado == aceptado)
                return true;

        return false;
    }
}


