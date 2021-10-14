
# DynamicLayout
**DynamicLayout** é um gerenciador de layout swing que possui uma utilização extremamente descomplicada.

* **Responsividade:** Com o DynamicLayou você poderá desenvolver em swing sem se preocupar com responsividade dos elementos. Basta posicioná-los na sua janela que o DynamicLayout fará todos os cálculos para manter seus objetos swing com as mesmas proporções em relação ao seu objeto-pai.  
* **Facilidade:** Comece a trabalhar com o gerenciador de layout apenas com uma linha de código passada em objetos-pai

## Baixe o .jar do DynamicLayout

- [versão 1.0 - stable](https://github.com/JoaoVictorLacerda/DynamicLayout/raw/main/Jar/DynamicLayout_1.0.jar)
- [versão 1.1 - stable (recomendada)](https://github.com/JoaoVictorLacerda/DynamicLayout/raw/main/Jar/DynamicLayout_1.1.jar)
## Adicionar dependências ao seu repositório Maven
primeiro adicione o repositório do [jitpack](https://jitpack.io/)
```jsx
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```
Depois adicione a dependência.  
Versão 1.0:
```jsx
<dependency>
  <groupId>com.github.JoaoVictorLacerda</groupId>
  <artifactId>DynamicLayout-Maven</artifactId>
  <version>v1.0</version>
</dependency>
```
Versão 1.1 (Recomendada):
```jsx
<dependency>
  <groupId>com.github.JoaoVictorLacerda</groupId>
  <artifactId>DynamicLayout-Maven</artifactId>
  <version>v1.1</version>
</dependency>
```

## Nota da versão 1.1  
**O que há de novo?**    
Agora o DynamicLayout também cuidará do redimensionamento das fontes em todos componentes que possuírem um campo de texto. É importante ressaltar que o tamanho da fonte nunca poderá ultrapassar a altura de seu elemento pai.  
Ex: O texto dentro de um JLabel nunca será maior do que a altura do mesmo.
<p>
 <b>Versão 1.1:</b> <br>
 <img width= "300"  height="175" src="./Gifs/DemoV1.1.gif"> <br>
  <b>Versão 1.0:</b> <br>
 <img width= "300"  height="175" src="./Gifs/DevoV1.0.gif">

</p>


# Iniciando
#### Assista ao exemplo de uso do gerenciador de layout (Clique na imagem):
[![](./Imgs/exemploDeUso.jpg)](http://www.youtube.com/watch?v=SAlTZ1a0dNk "Assista o vídeo")     
- Coloque o .jar disponibilizado nesta documentação no classpath do seu projeto.  
Ao criar um elemento que terá filhos, basta passar o DynamicLayout como gerenciador de layout, usando o método:
~~~jsx
elementoPai.setLayout( new DynamicLayout( width-do-elemento-pai, height-do-elemento-pai ) );
~~~
- Ele recebe dois parâmetros inteiros para a orientação do posicionamento (irá pegar o tamanho de cada elemento e tirar a porcentagem do mesmo dentro do elemento pai ). Feito isso, o objeto será responsável por gerenciar os tamanhos e posicionamentos de todos os componentes filhos.

#### Veja um exemplo de implementação em um layout estático (Clique na imagem):
[![](./Imgs/exemploLayoutEstatico.jpg)](http://www.youtube.com/watch?v=tZQjtU_Smd0 "Assista o vídeo")
# Importante  
- Aviso 1 - Você precisará passar o layout antes de passar qualquer elemento filho dentro do elemento pai. Isso porque o gerenciador trabalha pegando todos os elementos a partir do ponto em que o mesmo foi definido.  

- Aviso 2 - Diferente de outros gerenciadores de layout, DynamicLayout precisa que o programador posicione os elementos na tela para que o algoritmo possa trabalhar com essas informações e calcular as posições e dimensões sempre que o elemento pai for redimensionado. Um exemplo de como posicionar elementos filhos dentro de elementos pai é a linha de código abaixo:
~~~jsx
elementoFilho.setBounds( localização x, localização y, width, height );
~~~ 
- Aviso 3 - Quando queremos colocar um JScrollPane em um JPanel, é comum definir um preferredSize passando-lhe uma nova dimensão que irá mudar as dimensões do JPanel, porém, só ficará visível quando implementarmos o JScrollPane. Nesse caso, é de extrema importância que o DynamicLayout seja alimentado com as novas dimensões passadas no preferredSize. Se isso não for implementado, o DynamicLayout passará a dispor elementos por toda área do JPanel. Um exemplo abaixo:
 ```jsx
seuPainel.setBounds( 230, 65, 440, 430 );  
seuPainel.setPreferredSize( new Dimension( 0, 630 ) ); 
sePainel.setLayout( new DynamicLayout( 440, 630 ) );  
```
Perceba que esse código só altera a altura do preferredSize, seguindo a lógica, você só irá precisar passar a altura "atualizada" no DynamicLayout.

# Recomendação

- Quando a tela for redimensionada para menor, existe uma possível chance das medidas dos componentesFilho(width e height)  
não conseguirem suportar o conteúdo do mesmo(uma vez que as medidas da tela estão diretamente relacionadas com as do componente filho).Para não correr o risco desse problema acontecer no seu projeto, faça uso da função JFrame.setMinimumSize().Essa função irá delimitar o tamanho mínimo que uma janela poderá chegar( ficará à critério do programador ).  

- O mais recomendado a ser feito é desenvolver com o DynamicLayout desde o zero. Pode ser que precise alterar as dimensões de alguns componentes ao usar o DynamicLayout em um projeto pronto(estático)

# Entendendo a lógica

Se um elemento filho que tem a largura de 10px e está dentro de um elemento pai  
que possui 100px de largura, logo, pode-se entender que o elemento filho ocupa  
10% do elemento pai. Quando o pai é redimensionado, a porcentagem não mudará,  
o elemento filho ainda possuirá 10% do pai, porém, quando o pai é redimensionado  
o 10% do filho não valerá mais 10. A mesma coisa acontece com a altura, localização x e y e as fontes (na versão 1.1)  
  
Situação exemplo:  
  
10% de 100 = 10;  
10% de 200 = 20.

# Projetos que fazem uso:
- [Jogo da velha - v1.0](https://github.com/thenbhd22/JogoDaVelhaEmJava_3.0-Swing)
- [Livraria Digital - v1.0](https://github.com/thenbhd22/LivrariaDigital)


