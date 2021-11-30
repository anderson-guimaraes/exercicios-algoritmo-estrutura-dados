package L09.Arvore;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

  public void inserir(T info) {
    NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(info);

    if (estaVazia()) {
      setRaiz(novo);
    } else {
      NoArvoreBinaria<T> p = getRaiz();
      NoArvoreBinaria<T> pai;

      while (true) {
        pai = p;
        if (info.compareTo(p.getInfo()) < 0) {
          p = p.getEsquerda();
          if (p == null) {
            pai.setEsquerda(novo);
            return;
          }
        } else {
          p = p.getDireita();
          if (p == null) {
            pai.setDireita(novo);
            return;
          }
        }
      }
    }
  }

  @Override
  public NoArvoreBinaria<T> buscar(T info) {
    NoArvoreBinaria<T> p;

    p = getRaiz();

    while (p != null && !p.getInfo().equals(info)) {
      if (info.compareTo(p.getInfo()) < 0) {
        p = p.getEsquerda();
      } else {
        p = p.getDireita();
      }
    }
    return p;
  }
}
