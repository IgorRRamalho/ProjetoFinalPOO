package Controle;

public class Utilitarios {

    void limparTelaConsole(){
       
            // Verifica o sistema operacional para determinar o comando apropriado
            String os = System.getProperty("os.name").toLowerCase();
    
            // Comando para limpar a tela
            String comandoLimparTela = "";
    
            if (os.contains("win")) {
                comandoLimparTela = "cls"; // Windows
            } else {
                comandoLimparTela = "clear"; // Unix/Linux/Mac
            }
    
            // Tenta limpar a tela usando o comando apropriado
            try {
                ProcessBuilder processo = new ProcessBuilder(comandoLimparTela);
                processo.inheritIO().start().waitFor();
            } catch (Exception e) {
                System.out.println("Não foi possível limpar a tela.");
            }
    

    }
     
}
