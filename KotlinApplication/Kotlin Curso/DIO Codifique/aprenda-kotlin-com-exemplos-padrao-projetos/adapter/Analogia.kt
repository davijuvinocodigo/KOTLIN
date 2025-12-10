/**

    Padrão Adapter em Kotlin
    O que é o Padrão Adapter?
    O Adapter é um padrão de projeto estrutural que permite que objetos com interfaces incompatíveis trabalhem juntos. 
    Ele atua como um "adaptador" entre duas interfaces diferentes, convertendo a interface de uma classe em outra interface esperada pelo cliente.

    Analogia Prática
    Pense em um adaptador de tomada de viagem: 
    você tem um carregador com plugue americano (interface A) e precisa conectá-lo a uma tomada brasileira (interface B). 
    O adaptador faz a conversão entre os dois formatos.

*/




/*
    Quando usar o padrão Adapter
    Integração com código legado: Quando você precisa usar classes antigas em um novo sistema
    Trabalhar com bibliotecas de terceiros: Quando a biblioteca tem uma interface diferente da esperada
    Unificação de interfaces: Quando você tem várias classes com funcionalidades similares mas interfaces diferentes

    Testes: Para criar mocks ou stubs durante testes

    Vantagens
    Separação de preocupações: O código de adaptação fica isolado
    Reutilização: Permite reutilizar classes existentes
    Flexibilidade: Facilita a troca de implementações
    Compatibilidade: Permite integrar sistemas com interfaces incompatíveis

    Tipos de Adapter
    Adapter de Classe (herança): Usa herança para adaptar (menos comum em Kotlin)
    Adapter de Objeto (composição): Usa composição (mais flexível, usado no exemplo)

    O padrão Adapter é amplamente utilizado em desenvolvimento Android para adaptar dados a ListViews/RecyclerViews, mas também é útil em qualquer 
    situação onde você precisa fazer interfaces incompatíveis trabalharem juntas.

*/