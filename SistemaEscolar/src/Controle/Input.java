package Controle;

import java.io.*;

/**
 * A classe Input fornece métodos para ler dados da entrada padrão (teclado).
 * Ela suporta leitura de strings, inteiros, números de ponto flutuante, booleanos e caracteres.
 * 
 * @author Daniel Porto
 */
public class Input {
    
    // BufferedReader para ler entradas do teclado
    private static BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Lê uma linha de texto da entrada padrão.
     *
     * @return A linha de texto lida.
     */
    public static String readString() {
        String line = "0";
        try {
            line = inReader.readLine();
        } catch (IOException e) {
            System.err.println("Erro ao obter entrada. Erro: " + e.getMessage());
        }
        return line;
    }

    /**
     * Exibe uma mensagem e lê uma linha de texto da entrada padrão.
     *
     * @param mensagem A mensagem a ser exibida antes da leitura.
     * @return A linha de texto lida.
     */
    public static String readString(String mensagem) {
        System.out.print(mensagem);
        return readString();
    }

    /**
     * Lê um número inteiro da entrada padrão.
     *
     * @return O número inteiro lido.
     */
    public static int readInt() {
        return Integer.parseInt(readString());
    }

    /**
     * Exibe uma mensagem e lê um número inteiro da entrada padrão.
     *
     * @param mensagem A mensagem a ser exibida antes da leitura.
     * @return O número inteiro lido.
     */
    public static int readInt(String mensagem) {
        System.out.print(mensagem);
        return readInt();
    }

    /**
     * Lê um número de ponto flutuante da entrada padrão.
     *
     * @return O número de ponto flutuante lido.
     */
    public static double readDouble() {
        return Double.parseDouble(readString());
    }

    /**
     * Exibe uma mensagem e lê um número de ponto flutuante da entrada padrão.
     *
     * @param mensagem A mensagem a ser exibida antes da leitura.
     * @return O número de ponto flutuante lido.
     */
    public static double readDouble(String mensagem) {
        System.out.print(mensagem);
        return readDouble();
    }

    /**
     * Lê um valor booleano da entrada padrão.
     *
     * @return O valor booleano lido.
     */
    public static boolean readBoolean() {
        return Boolean.valueOf(readString()).booleanValue();
    }

    /**
     * Exibe uma mensagem e lê um valor booleano da entrada padrão.
     *
     * @param mensagem A mensagem a ser exibida antes da leitura.
     * @return O valor booleano lido.
     */
    public static boolean readBoolean(String mensagem) {
        System.out.print(mensagem);
        return readBoolean();
    }

    /**
     * Lê um caractere da entrada padrão.
     *
     * @return O caractere lido.
     */
    public static char readChar() {
        return readString().charAt(0);
    }

    /**
     * Exibe uma mensagem e lê um caractere da entrada padrão.
     *
     * @param mensagem A mensagem a ser exibida antes da leitura.
     * @return O caractere lido.
     */
    public static char readChar(String mensagem) {
        System.out.print(mensagem);
        return readChar();
    }
}
