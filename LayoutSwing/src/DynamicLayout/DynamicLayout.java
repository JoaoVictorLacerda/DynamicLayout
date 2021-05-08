package DynamicLayout;

import java.awt.*;
import java.util.ArrayList;

public class DynamicLayout implements LayoutManager2{
    /**
     * @author João Victor Lacerda de Queiroz
     */

    private ArrayList<Component> elementos = new ArrayList<Component>();
    private ArrayList<Integer> percentsWid = new ArrayList<Integer>();
    private ArrayList<Integer> percentsHeig = new ArrayList<Integer>();
    private ArrayList<Integer> percentsPositionsX = new ArrayList<Integer>();
    private ArrayList<Integer> percentsPositionsY = new ArrayList<Integer>();

    int width,height;

    public DynamicLayout(int width, int height){
        this.width = width;
        this.height=height;
    }
    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        addLayoutComponent((String)constraints, comp);

    }
    @Deprecated
    public void addLayoutComponent(String name, Component comp) {
        synchronized (comp.getTreeLock()) {
            /**
             * Esse array de elementos é responsável por guardar todos os filhos
             * de um pai que implementou o DynamicLayout (Seja um JFrame ou um JPanel).
             *
             * Com esses componentes armazenados em um arrayList, é possível trabalhar
             * com seus tamanhos e posições separadamente
             */
            elementos.add(comp);
            /**
             * Os outros ArrayLists são usados no armazenamento da porcentagem
             * de um x elemento de acordo com o seu elemento pai.
             *
             * Basicamente, o gerenciador funciona em cima disso!
             * Se um elemento filho que tem a largura de 10px e está dentro de um elemento pai
             * que possui 100px de largura, logo, pode-se entender que o elemento filho ocupa
             * 10% do elemento pai. Quando o pai é redimensionado, a porcentagem não mudará,
             * o elemento filho ainda possuirá 10% do pai; porém, quando o pai é redimensionado
             * os 10% do filho não valerá mais 10.
             *
             * Ex: 10% de 100 = 10;
             *     10% de 200 = 20.
             *
             * E o mesmo vale para as posições x e y
             *
             */
            percentsWid.add(this.getPercent(this.width,comp.getWidth()));
            percentsHeig.add(this.getPercent(this.height, comp.getHeight()));

            this.percentsPositionsX.add(this.getPercent(this.width,
                    (int) comp.getLocation().getX()));

            this.percentsPositionsY.add(this.getPercent(this.height,
                    (int) comp.getLocation().getY()));

        }
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public void layoutContainer(Container target) {
        int height = target.getHeight();
        int width = target.getWidth();
        int cont =0;
        for (Component c: this.elementos) {
            int widthFinal = geraTamanhoWid(width, cont);
            int heightFinal = geraTamanhoHeig(height, cont);

            c.setBounds(geraPositionX(width,cont),
                    geraPositionY(height,cont),
                    widthFinal,
                    heightFinal);
            cont++;
        }


    }

    private int getPercent(int tamPai, int tamFilho){
        return  (tamFilho*100)/tamPai;
    }

    private int geraPositionX(int tamPai,int cont){
        return (this.percentsPositionsX.get(cont)*tamPai)/100;
    }

    private int geraPositionY(int tamPai,int cont){
        return (this.percentsPositionsY.get(cont)*tamPai)/100;
    }
    private int geraTamanhoWid(int tamPai, int cont){
        return ((this.percentsWid.get(cont) * (tamPai))/100);
    }

    private int geraTamanhoHeig(int tamPai, int cont){
        return ((this.percentsHeig.get(cont) * tamPai)/100);
    }
    //métodos não utilizados 07/05/2021
    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }
    @Override
    public void invalidateLayout(Container target) {
    }
    @Override
    public float getLayoutAlignmentX(Container parent) {
        return 0;
    }
    @Override
    public float getLayoutAlignmentY(Container parent) {
        return 0;
    }
    @Override
    public void removeLayoutComponent(Component comp) {
    }

}
