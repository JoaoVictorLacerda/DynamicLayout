# DynamicLayout: Um gerenciador de Layout swing muito simples  


## Baixe o .jar do DynamicLayout

[versão 1.0](https://github.com/JoaoVictorLacerda/DynamicLayout/raw/main/Jar/DynamicLayout_1.0.jar)  
[versão 1.1](https://github.com/JoaoVictorLacerda/DynamicLayout/raw/main/Jar/DynamicLayout_1.1.jar)

## Nota da versão 1.1  
O que há de novo?   
Agora o DynamicLayout também cuidará do redimensionamento das fontes em todos componentes que possuírem um campo de texto  
<p>
 <b>Versão 1.1:</b> <br>
 <img width= "500"  height="300" src="./Gifs/DemoV1.1.gif"> <br>
  <b>Versão 1.0:</b> <br>
 <img width= "500"  height="300" src="./Gifs/DevoV1.0.gif">

</p>


# Iniciando
#### Assista ao exemplo de uso do gerenciador de layout (Clique na imagem):
[![](./Imgs/exemploDeUso.jpg)](http://www.youtube.com/watch?v=SAlTZ1a0dNk "Assista o vídeo")  
Antes de entender como o algoritmo funciona, é necessário aprender a usá-lo.  
  
importe o jar disponível no repositório para seu projeto.  
  

Ao criar um elemento que terá filhos, basta passar o DynamicLayout como gerenciador de layout,  
usando o método:
~~~
elementoPai.setLayout( new DynamicLayout( width do elemento pai, height do elemento pai ) );
~~~
Ele recebe dois parâmetros para a orientação do posicionamento (irá pegar o tamanho de cada elemento e tirar a porcentagem do mesmo dentro do elemento pai ).  
Feito isso, a classe irá ser responsável por gerenciar os tamanhos e posicionamentos de todos os componentes filhos.

#### Veja um exemplo de implementação em um layout estático (Clique na imagem):
[![](./Imgs/exemplo.LayoutEstatico.jpg)](http://www.youtube.com/watch?v=tZQjtU_Smd0 "Assista o vídeo")
# Importante

Ao usar o DynamicLayout, você precisará passar essa linha de código em elementos filhos para que o algoritmo possa ser alimentado.
~~~
elementoFilho.setBounds( localização x, localização y, width, height );
~~~ 
O gerenciador funciona à base do setBounds pegando o ponto x, o ponto y, width e height.  
Ele é capaz de manter constância dos elementos quando o elemento pai é redimensionado.

Você precisará passar o layout antes de passar qualquer elemento filho dentro do elemento pai.  
Isso porque o gerenciador trabalha pegando todos os elementos apartir do ponto em que o mesmo foi definido

# Recomendação

Quando a tela for redimensionada para menor, existe uma possível chance das medidas dos componentesFilho(width e height)  
não conseguirem suportar o conteúdo do mesmo(uma vez que as medidas da tela estão diretamente relacionadas com as do componente filho).  
  
Para não correr o risco desse problema acontecer no seu projeto, faça uso da função JFrame.setMinimumSize().  
Essa função irá delimitar o tamanho mínimo que uma janela poderá chegar( ficará à critério do programador ).

# Caso específico

Quando usamos o DynamicLayout em um JPanel, por exemplo, e esse JPanel faz uso da função:

~~~
seuPainel.setPreferredSize( new Dimension( width, height ) );
~~~
É de extrema importância que o DinamicLayout seja alimentado com as dimensões novas que foram passadas no construtor do Dimension.  
Exemplo:  

seuPainel.panel.setBounds( 230, 65, 440, 430 );    
seuPainel.setPreferredSize( new Dimension( 0, 630 ) );    
sePainel.setLayout( new DynamicLayout( 440, 630 ) );  

Perceba que esse código só altera a altura do preferredSize, seguindo a lógica, você só irá precisar passar a altura "atualizada" no DynamicLayout.


# Entendendo a lógica

Se um elemento filho que tem a largura de 10px e está dentro de um elemento pai  
que possui 100px de largura, logo, pode-se entender que o elemento filho ocupa  
10% do elemento pai. Quando o pai é redimensionado, a porcentagem não mudará,  
o elemento filho ainda possuirá 10% do pai, porém, quando o pai é redimensionado  
o 10% do filho não valerá mais 10. A mesma coisa acontece com a altura e a localização x e y  
  
Situação exemplo:  
  
10% de 100 = 10;  
10% de 200 = 20.

# Projetos que fazem uso:
- [x] Jogo da velha: https://github.com/thenbhd22/JogoDaVelhaEmJava_3.0-Swing. (Versão 1.0)   
- [x] Livraria Digital: https://github.com/thenbhd22/LivrariaDigital   (Versão 1.0)



