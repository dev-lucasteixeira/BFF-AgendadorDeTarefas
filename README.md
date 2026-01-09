# 🚀 Task Scheduler Ecosystem — Cloud Native BFF Edition

Este ecossistema representa uma arquitetura de microsserviços moderna, projetada para escalabilidade, desacoplamento e resiliência. O coração do projeto é este **BFF (Backend For Frontend)**, que atua como um orquestrador inteligente, protegendo a infraestrutura de backend e otimizando a experiência do cliente final.

---

## 🏗️ Arquitetura do Sistema (System Design)

O ecossistema foi decomposto em domínios de contexto delimitados (*Bounded Contexts*), comunicando-se de forma síncrona (REST/Feign) e assíncrona (RabbitMQ/AMQP).



### 🛰️ 1. BFF Gateway (Este Repositório)
* **Papel**: Ponto único de entrada, segurança e composição de dados.
* **Infraestrutura**: Operando via **Docker** para garantir portabilidade e isolamento total de ambiente.
* **Tecnologia**: Java 17/24, Spring Boot 3.5.x.

### 🔐 2. Identity Service (MS-Usuario)
* **Papel**: Autoridade de segurança e gestão de identidades.
* **Segurança**: Emissão de tokens **JWT** com criptografia de ponta a ponta.
* **Repositório**: [User Management Service](https://github.com/dev-lucasteixeira/User-Management-Service)

### 📅 3. Scheduler Engine (MS-Agendador)
* **Papel**: Core Business. Gerencia o ciclo de vida das tarefas e regras de agendamento cronológico.
* **Comunicação**: Publica eventos de tarefas agendadas no Broker de mensageria ao atingir o gatilho de execução.
* **Repositório**: [Projeto Agendador Tarefas](https://github.com/dev-lucasteixeira/Projeto-AgendadorTarefas)

### ✉️ 4. Notification Worker (MS-Notificacao)
* **Papel**: Worker especializado no disparo de e-mails em tempo real.
* **Resiliência**: Consumidor assíncrono de filas **RabbitMQ**, garantindo entrega garantida (At-least-once delivery).
* **Repositório**: [Projeto Notificação](https://github.com/dev-lucasteixeira/Projeto-Notificacao)

---

## 🛠️ Stack Tecnológica & Engenharia de Software

### 📡 Mensageria & Integração
* **RabbitMQ (AMQP)**: Utilizado como espinha dorsal para o desacoplamento. O Agendador não conhece o serviço de e-mail; ele apenas emite eventos, permitindo que o sistema suporte picos de carga sem degradação de performance.
* **Spring Cloud OpenFeign**: Abstração de chamadas HTTP síncronas, tornando a integração entre o BFF e o Agendador declarativa e limpa.

### 🛡️ Segurança e Propagação de Contexto
* **JWT Propagation Interceptor**: Desenvolvemos um `FeignAuthInterceptor` customizado.
    * **Desafio**: Resolver o problema de perda de contexto de segurança em saltos de rede entre serviços.
    * **Solução**: O interceptor captura o token do contexto atual, realiza o *sanitizing* (correção automática de prefixos como "Bearer Bearer") e o injeta na requisição de saída.
* **Stateless Auth**: Arquitetura livre de estado no servidor, permitindo escalabilidade horizontal imediata.

### 💎 Qualidade de Código (Clean Code & Sonar)
* **SonarQube Compliance**: O projeto mantém o selo de qualidade "Sonar Way".
    * **Utility Class Pattern**: Proteção contra instanciação indevida de classes estáticas usando construtores privados e `IllegalStateException`.
    * **Imutabilidade**: Implementação de DTOs resilientes com Lombok `@Value` e `@Builder`.

---

## 🚀 Fluxo de Dados (Step-by-Step)

1.  **Handshake**: O cliente obtém o token JWT no **MS-Usuario**.
2.  **Request**: O cliente envia o token para o **BFF** ao interagir com as tarefas.
3.  **Propagation**: O **BFF** trata o token via Interceptor e o encaminha para o **MS-Agendador**.
4.  **Event Generation**: O **MS-Agendador** persiste a tarefa e, no momento exato, posta um evento no **RabbitMQ**.
5.  **Consumption**: O **MS-Notificacao** consome a fila e processa o envio do e-mail de forma assíncrona.
