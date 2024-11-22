
<p align="center" style="display: flex; justify-content: center;">
  <img src="https://media.discordapp.net/attachments/1304125766887276604/1308856876439572550/ecosage_logo.png?ex=674171b4&is=67402034&hm=fce0a632d43ddfa69bf2c509331b04008fef87cc0df3be406db82132534e282d&=&format=webp&quality=lossless&width=629&height=416" alt="EcoSage - LOGO" style="border-radius: 15px;" />
</p>

### EcoSage - Sistema de Gerenciamento de Energia 🌱

**Descrição do Projeto**  
EcoSage é um sistema desenvolvido em Java com o objetivo de gerenciar e otimizar o consumo de energia elétrica. Ele permite que os usuários registrem, monitorem e analisem equipamentos, categorias, consumo de energia e custos associados. Com EcoSage, é possível obter uma visão clara do consumo energético, contribuindo para a redução de gastos e impactos ambientais.

---

### Funcionalidades Principais
1. **Gerenciamento de Equipamentos**  
   - **Registrar novos equipamentos** com informações como nome, potência, uso médio diário e categoria.  
   - **Listar todos os equipamentos** cadastrados.  
   - **Visualizar detalhes** de um equipamento específico.  
   - **Editar informações** de equipamentos existentes.  
   - **Remover equipamentos** do sistema.

2. **Categorias de Equipamentos**  
   - **Criar categorias** para organizar equipamentos, como "Eletrodomésticos" ou "Eletrônicos".  
   - **Listar todas as categorias** cadastradas.  
   - **Atualizar informações** de uma categoria.  
   - **Excluir categorias** quando necessário.

3. **Monitoramento do Consumo de Energia**  
   - **Registrar períodos de consumo energético**, incluindo energia consumida, custo total e datas de início e fim.  
   - **Listar dados de consumo energético** para análise histórica.  
   - **Excluir registros** de consumo desatualizados ou irrelevantes.

4. **Planejamento de Consumo**  
   - **Definir metas** de consumo energético desejado, com base em períodos específicos.  
   - **Visualizar e editar metas** para acompanhar o progresso.  
   - **Excluir metas** quando necessário.

---

### Sobre o EcoSage AI

EcoSage AI é um chatbot desenvolvido para auxiliar o usuário em tarefas relacionadas à sustentabilidade e tecnologia. Ele utiliza a poderosa combinação de **Llama 3.2** e a **Groq API**, oferecendo respostas rápidas, precisas e adaptadas às necessidades do usuário.

#### Principais Características:
- **Llama 3.2**: Uma tecnologia avançada de linguagem natural que permite interações humanas e fluídas.
- **Groq API**: Gera a API Key para conectar com o Spring AI.

Essa parceria tecnológica garante que o EcoSage seja não apenas eficiente, mas também intuitivo, ajudando você em diversas áreas como planejamento sustentável, dúvidas técnicas e muito mais.

---

### Endpoints da API

### Swagger
 - `GET {{javaApi}}/swagger-ui/index.html` - Link da documentação no Swagger. 

#### **Equipamentos**
- `GET {{javaApi}}/equipment` - Listar todos os equipamentos.  
- `POST {{javaApi}}/equipment` - Registrar um novo equipamento.  
- `GET {{javaApi}}/equipment/{id}` - Visualizar um equipamento pelo ID.  
- `PUT {{javaApi}}/equipment/{id}` - Atualizar um equipamento pelo ID.  
- `DELETE {{javaApi}}/equipment/{id}` - Remover um equipamento pelo ID.  

#### **Categorias de Equipamentos**
- `GET {{javaApi}}/category` - Listar todas as categorias.  
- `POST {{javaApi}}/category` - Criar uma nova categoria.  
- `GET {{javaApi}}/category/{id}` - Visualizar uma categoria pelo ID.  
- `PUT {{javaApi}}/category/{id}` - Atualizar uma categoria pelo ID.  
- `DELETE {{javaApi}}/category/{id}` - Remover uma categoria pelo ID.  

#### **Consumo de Energia**
- `GET {{javaApi}}/energyUsage` - Listar todos os registros de consumo energético.  
- `POST {{javaApi}}/energyUsage` - Registrar um novo consumo energético.  
- `GET {{javaApi}}/energyUsage/{id}` - Visualizar consumo energético pelo ID.  
- `DELETE {{javaApi}}/energyUsage/{id}` - Remover um registro de consumo pelo ID.  

#### **Metas de Consumo**
- `GET {{javaApi}}/energyWantedUsage` - Listar todas as metas de consumo.  
- `POST {{javaApi}}/energyWantedUsage` - Registrar uma nova meta de consumo.  
- `GET {{javaApi}}/energyWantedUsage/{id}` - Visualizar uma meta de consumo pelo ID.  
- `PUT {{javaApi}}/energyWantedUsage/{id}` - Atualizar uma meta de consumo pelo ID.  
- `DELETE {{javaApi}}/energyWantedUsage/{id}` - Remover uma meta de consumo pelo ID.  

### **Chat**
- `GET {{javaApi}}/chat` - Manda a mensagem para o AI.
- `GET {{javaApi}}/chat/messages/user` - Visualiza as mensagens dos usuários. 
- `GET {{javaApi}}/chat/messages/ai` - Visualiza as respostas da IA. 
- `GET {{javaApi}}/chat/messages/user` - Limpa todas as mensagens. 

---

Confira o vídeo do nosso projeto no link abaixo:  
[Assista ao Pitch](https://youtu.be/)

Projeto C#: [GITHUB](https://github.com/IgorLuiz777/EcoSage-CSharp)

Interface: [GITHUB](https://github.com/IgorLuiz777/EcoSage-front)

Projeto Mobile: [GITHUB](https://github.com/lucasrychlicki/EcoSage)

Projeto IA: [GITHUB](https://github.com/CastanhoPh/Ecosage)

### Equipe:
- **Gustavo Monte (RM 551601)** - Compliance, Quality Assurance & Tests
- **Igor Luiz (RM 99809)** - Java Advanced | Advanced Business Development with .NET
- **Lucas Lima (RM 551253)** - Mobile Application Development | DevOps Tools & Cloud Computing
- **Murilo Caumo (RM 551247)** - Mastering Relational and Non-Relational Databases
- **Pedro Henrique (RM 551598)** - Disruptive Architectures: IoT, IoB & Generative AI

**Nota:** Embora cada membro tenha responsabilidades específicas, 
todos contribuem em todas as disciplinas e para o projeto como um todo.

---

### Como Contribuir
1. Faça um fork do repositório.  
2. Crie uma branch para sua feature (`git checkout -b minha-feature`).  
3. Faça commit das suas alterações (`git commit -m 'Adicionei uma nova feature'`).  
4. Faça o push para a branch (`git push origin minha-feature`).  
5. Abra um Pull Request.

---

### Link para Documentação da API no Postman  
[Documentação EcoSage no Postman](https://speeding-satellite-21324.postman.co/workspace/EcoSage~c63ec605-125c-4fa8-834e-029e70b07a58/collection/29257649-fc870dfb-cf85-4e4e-b8cd-dcddbb21bf8e?action=share&source=collection_link&creator=29257649)

---
