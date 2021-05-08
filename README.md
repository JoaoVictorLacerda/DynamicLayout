# DynamicLayout
## API de um Layout swing muito simples
### EM DESENVOLVIMENTO BUSCANDO MELHORIAS

#### Assista ao exemplo de uso do gerenciador de layout:
[![Exemplo](http://img.youtube.com/vi/SAlTZ1a0dNk/0.jpg)](http://www.youtube.com/watch?v=SAlTZ1a0dNk "Exemplo de Uso")

# Iniciando
Antes de entender como o algoritmo funciona, é necessário aprender a usá-lo.  
  
importe o jar para seu projeto ou use a classe disponível no repositório.  
  

Ao criar um elemento que terá filhos, basta passar o DynamicLayout como gerenciador de layout,  
usando o método: elementoPai.setLayout(new DynamicLayout(width do elemento pai, height do elemento pai )).  
Ele recebe dois parâmetros para a orientação do posicionamento (irá pegar o tamanho de cada elemento e tirar a porcentagem do mesmo dentro do elemento pai ).
  
Feito isso, a classe irá ser responsável por gerenciar os tamanhos e posicionamentos de todos os componentes filhos.
#### Veja um exemplo de implementação em um layout estático:
[![Implementação](http://img.youtube.com/vi/tZQjtU_Smd0/0.jpg)](http://www.youtube.com/watch?v=tZQjtU_Smd0 "Exemplo")
# Importante

Ao usar o DynamicLayout, você precisará passar um elementoFilho.setBounds() para que o código possa ser alimentado.  
Basicamente, o gerenciador funciona à base do setBounds. Ele é capaz de manter constância dos elementos  
quando o elemento pai é redimensionado.

Você precisará passar o layout antes de passar qualquer elemento filho dentro do elemento pai.  
Isso porque o gerenciador trabalha pegando todos os elementos apartir do ponto em que o mesmo foi definido

# Recomendação

Quando a tela for redimensionada para menor, existe uma possível chance das medidas dos componentesFilho(width e height)  
não conseguirem suportar o conteúdo do mesmo(uma vez que as medidas da tela estão diretamente relacionadas com as do componente filho).  
  
Para não correr o risco desse problema acontecer no seu projeto, faça uso da função JFrame.setMinimumSize().  
Essa função irá delimitar o tamanho mínimo que uma janela poderá chegar( ficará à critério do programador ).

  
# Entendendo a lógica

Se um elemento filho que tem a largura de 10px e está dentro de um elemento pai  
que possui 100px de largura, logo, pode-se entender que o elemento filho ocupa  
10% do elemento pai. Quando o pai é redimensionado, a porcentagem não mudará,  
o elemento filho ainda possuirá 10% do pai, porém, quando o pai é redimensionado  
o 10% do filho não valerá mais 10. 
  
Situação exemplo:  
  
10% de 100 = 10;  
10% de 200 = 20.
