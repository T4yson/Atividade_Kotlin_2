# Calculadora de Frete Industrial 📦

> Uma aplicação Android nativa desenvolvida em Kotlin que calcula automaticamente o valor do frete baseado na região de destino no Brasil.

## 📋 Visão Geral

**Atividade_Kotlin_2** é uma aplicação educacional e prática que demonstra a implementação de uma calculadora de frete com interface intuitiva e moderna. O aplicativo permite que usuários insiram o valor de uma mercadoria e a região de destino para obter instantaneamente o percentual de frete, valor total do frete e valor final com frete incluído.

---

## ✨ Principais Funcionalidades

### 1. **Cálculo Dinâmico de Frete**
   - Calcula automaticamente o valor do frete com base em percentuais específicos por região
   - Suporte a 5 regiões brasileiras: Sul, Sudeste, Centro-Oeste, Nordeste e Norte
   - Validação em tempo real de entrada de dados

### 2. **Interface Responsiva e Moderna**
   - Design Material Design 3 com tema dinâmico (claro/escuro)
   - Layout adaptável com `NestedScrollView` para diferentes tamanhos de tela
   - Componentes visuais refinados com `MaterialCardView` e `TextInputLayout`
   - Ícones intuitivos para melhor experiência do usuário

### 3. **Tratamento de Entrada Robusto**
   - Validação de campos vazios com feedback visual
   - Tratamento de entrada numérica com suporte a decimais
   - Normalização de texto (case-insensitive) para flexibilidade
   - Mensagens de erro localizadas em português

### 4. **Edge-to-Edge Display**
   - Suporte completo a insets de sistema (barras de status e navegação)
   - Aplicação moderna e compatível com Android moderno

### 5. **Teclado Virtual Inteligente**
   - Ocultamento automático do teclado após cálculo
   - Ajuste automático de layout quando teclado é exibido

---

## 🔧 Decisões de Arquitetura e Implementação

### **Estrutura de Projeto**
```
Atividade_Kotlin_2/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/atividade_kotlin_2/
│   │   │   │   └── MainActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── themes.xml
│   │   │   │   └── xml/
│   │   │   │       ├── backup_rules.xml
│   │   │   │       └── data_extraction_rules.xml
│   │   │   └── AndroidManifest.xml
│   │   └── androidTest/
│   └── build.gradle.kts
└── build.gradle.kts
```

### **Decisões Técnicas Principais**

#### 1. **Manutenção de Estado com ViewModel (Potencial)**
   - Atualmente, o projeto utiliza uma abordagem simples com Activity direta
   - Sugestão futura: Implementar ViewModel para persistência automática de dados em rotações de tela

#### 2. **Recuperação de Componentes via findViewById()**
   - Abordagem manual e didática, ideal para fins educacionais
   - Alternativa moderna: Migration para View Binding seria recomendada para projetos maiores

#### 3. **Estratégia de Percentuais por Região**
   ```kotlin
   val percentual = when (regiaoStr.lowercase()) {
       "sul" -> 0.05           // 5%
       "sudeste" -> 0.07       // 7%
       "centro-oeste", "centro oeste" -> 0.08  // 8%
       "nordeste" -> 0.10      // 10%
       "norte" -> 0.12         // 12%
       else -> tratarErro()
   }
   ```
   - Tabela simples e direta para cálculo
   - Aceita variações de entrada (ex: "centro-oeste" e "centro oeste")

#### 4. **Localização com Strings Resources**
   - Todas as strings externalizadas em `strings.xml`
   - Facilita tradução e manutenção futura
   - Padrão Android recomendado e best practice

#### 5. **Design Pattern: Constraint Layout + Material Components**
   - **ConstraintLayout** para posicionamento flexível
   - **MaterialCardView** para apresentação elegante dos resultados
   - **TextInputLayout** com prefixos e ícones para melhor UX
   - Espaçamentos consistentes (24dp base, incremental)

#### 6. **Validação em Duas Camadas**
   - Validação 1: Campos vazios (feedback: Toast)
   - Validação 2: Região não reconhecida (feedback: Toast)
   - Conversão segura com `toDoubleOrNull()` para valor monetário

#### 7. **Configuração Gradle Otimizada**
   - **Compilação**: Android Gradle Plugin com libs convenções
   - **Versão Android**: Target SDK 36, Min SDK 24 (ampla compatibilidade)
   - **Kotlin Code Style**: Oficial (padrão Kotlin)
   - **Configuration Cache**: Habilitado para builds mais rápidos

---

## 🎯 Requisitos do Sistema

- **Android Mínimo**: API 24 (Android 7.0)
- **Android Alvo**: API 36
- **Linguagem**: Kotlin
- **Build System**: Gradle 8.x com Version Catalog

---

## 🚀 Como Compilar e Executar

### Pré-requisitos
- Android Studio Jellyfish (2023.3.1) ou mais recente
- JDK 11+
- Android SDK com API Level 36 instalado

### Passos de Compilação
```bash
# Clone o repositório
git clone https://github.com/T4yson/Atividade_Kotlin_2.git
cd Atividade_Kotlin_2

# Build da aplicação
./gradlew assembleDebug

# Instalar em dispositivo/emulador
./gradlew installDebug

# Executar com Android Studio
# Abra o projeto em Android Studio e clique em "Run"
```

---

## 📱 Fluxo de Uso

1. **Insira a Região**: Digite a região de destino (Sul, Sudeste, Centro-Oeste, Nordeste, Norte)
2. **Insira o Valor**: Digite o valor da mercadoria em reais
3. **Calcule**: Clique no botão "Calcular Frete"
4. **Visualize Resultado**: O aplicativo exibe:
   - Percentual aplicado
   - Valor do frete em reais
   - Valor total com frete incluído

---

## 🧪 Testes

O projeto inclui testes instrumentalizados básicos em:
```
app/src/androidTest/java/com/example/atividade_kotlin_2/ExampleInstrumentedTest.kt
```

Para executar os testes:
```bash
./gradlew connectedAndroidTest
```

---

## 🎨 Paleta de Cores e Design

- **Fundo Principal**: `#F5F5F5` (cinza claro)
- **Texto Primário**: `#333333` (cinza escuro)
- **Texto Secundário**: `#555555`
- **Tema**: Material3 (Day/Night automático)
- **Componentes**: Material Design 3 com Material Components

---

## 📦 Dependências Principais

| Dependência | Versão | Propósito |
|-------------|--------|----------|
| `androidx.appcompat` | Latest | Compatibilidade com versões antigas |
| `androidx.constraintlayout` | Latest | Layout flexível |
| `com.google.android.material` | Latest | Componentes Material Design 3 |
| `androidx.activity:activity-ktx` | Latest | Extensões Kotlin para Activities |
| `androidx.core:core-ktx` | Latest | Core utilities para Kotlin |

> **Nota**: Versões específicas gerenciadas via Version Catalog (`libs.versions.toml`)

---

## 🔮 Melhorias Futuras (Roadmap)

- [ ] **ViewModel + LiveData**: Persistência de estado em rotações de tela
- [ ] **View Binding**: Migrar de `findViewById()` para Type-Safe view binding
- [ ] **Banco de Dados Local**: Histórico de cálculos com Room Database
- [ ] **Testes Unitários**: Cobertura de casos de cálculo
- [ ] **Tema Customizável**: Opções de coloração dinâmica
- [ ] **Suporte Multi-Idioma**: Localização em outros idiomas
- [ ] **API REST**: Integração com servidor de tabelas de frete dinâmicas
- [ ] **Análise de Dados**: Firebase Analytics para rastreamento de uso

---

## 📄 Licença

Este projeto é fornecido como atividade educacional.

---

## 👤 Autor

**T4yson**

- GitHub: [@T4yson](https://github.com/T4yson)
- Repositório: [Atividade_Kotlin_2](https://github.com/T4yson/Atividade_Kotlin_2)

Desenvolvido como atividade prática de Kotlin para Android, demonstrando conceitos fundamentais de desenvolvimento Android nativo, design responsivo e boas práticas de programação.

---

## 📞 Suporte

Para dúvidas, sugestões ou relatos de bugs, abra uma **Issue** neste repositório.

---

**Última atualização**: Junho de 2026 | **Status**: Ativo ✅

