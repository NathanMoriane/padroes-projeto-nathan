// ==========================================
// TRABALHO PRÁTICO: PADRÕES DE PROJETO EM JAVA
// Aluno: Nathan Gramond Moriane
// ==========================================

// Padrão 1: Singleton (Garante apenas uma instância)
class ConfiguracaoSistema {
    private static ConfiguracaoSistema instancia;
    private String modoAmbiente;

    private ConfiguracaoSistema() {
        this.modoAmbiente = "Produção";
    }

    public static synchronized ConfiguracaoSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracaoSistema();
        }
        return instancia;
    }

    public String getModoAmbiente() { return modoAmbiente; }
}

// Padrão 2: Factory Method (Criação de objetos desacoplada)
interface Notificacao {
    void enviar(String mensagem);
}

class NotificacaoEmail implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando E-MAIL: " + mensagem);
    }
}

class NotificacaoSMS implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}

class FabricaNotificacao {
    public static Notificacao criarNotificacao(tipo) { // Simplificado para demonstração
        return new NotificacaoEmail();
    }
    
    public static Notificacao criarPorTipo(String tipo) {
        if ("SMS".equalsIgnoreCase(tipo)) return new NotificacaoSMS();
        return new NotificacaoEmail();
    }
}

// Classe Principal para testes dos Padrões
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testando Padrões de Projeto ===");

        // Testando Singleton
        ConfiguracaoSistema config1 = ConfiguracaoSistema.getInstancia();
        System.out.println("Modo do Sistema (Singleton): " + config1.getModoAmbiente());

        // Testando Factory Method
        Notificacao notif = FabricaNotificacao.criarPorTipo("SMS");
        notif.enviar("Seu trabalho foi processado com sucesso!");
    }
}
