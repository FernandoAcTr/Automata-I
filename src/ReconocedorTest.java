public class ReconocedorTest {

    public static void main(String[] args){
        Reconocedor r = new Reconocedor();

        System.out.println("-123                    "+ r.reconocer("-123"));
        System.out.println("123.123                 "+ r.reconocer("123.123"));
        System.out.println("+123.123                "+ r.reconocer("+123.123"));
        System.out.println("-123.234E-03            "+ r.reconocer("-123.234E-03"));
        System.out.println("123.23e-23              "+ r.reconocer("123.23e-23"));
        System.out.println("123456789.123456789e+99 "+ r.reconocer("123456789.123456789e+99"));
        System.out.println("ave                     "+ r.reconocer("ave"));
        System.out.println("_X                      "+ r.reconocer("_X"));
        System.out.println("$                       "+ r.reconocer("$"));
        System.out.println("ave35                   "+ r.reconocer("ave35"));
        System.out.println("JAVA_HOME               "+ r.reconocer("JAVA_HOME"));
        System.out.println("Objeto                  "+ r.reconocer("Objeto"));
        System.out.println("Objeto$                 "+ r.reconocer("Objeto$"));
        System.out.println("_ABC_DEF                "+ r.reconocer("_ABC_DEF"));
        System.out.println("-abc34                  "+ r.reconocer("-abc34"));
        System.out.println("-123.fg                 "+ r.reconocer("-123.fg"));
        System.out.println("123.123.123             "+ r.reconocer("123.123.123"));
        System.out.println("-+.                     "+ r.reconocer("-+."));
        System.out.println("java-abc                "+ r.reconocer("java-abc"));
        System.out.println("1234+4567               "+ r.reconocer("1234+4567"));
        System.out.println("123.23E+99.5            "+ r.reconocer("123.23E+99.5"));
        System.out.println("125E+88e-99             "+ r.reconocer("125E+88e-99"));


    }
}
