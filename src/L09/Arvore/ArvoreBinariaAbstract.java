package L09.Arvore;

public abstract class ArvoreBinariaAbstract<T> {

  private NoArvoreBinaria<T> raiz;

  public ArvoreBinariaAbstract() {
    raiz = null;
  }

  protected void setRaiz(NoArvoreBinaria<T> raiz) {
    this.raiz = raiz;
  }

  public NoArvoreBinaria<T> getRaiz() {
    return raiz;
  }

  public boolean estaVazia() {
    return (raiz == null);
  }

  public boolean pertence(T info) {
    return buscar(info) != null;
  }

  public abstract NoArvoreBinaria<T> buscar(T info);

  private String arvorePre(NoArvoreBinaria<T> no) {
    if (no == null) {
      return "<>";
    } else {
      return "<" +
          no.getInfo() +
          arvorePre(no.getEsquerda()) +
          arvorePre(no.getDireita()) +
          ">";
    }
  }

  public String toString() {
    return arvorePre(raiz);
  }

  public int contarNos() {
    return contarNos(raiz);
  }

  private int contarNos(NoArvoreBinaria<T> no) {
    if (no == null) {
      return 0;
    } else {
      return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }
  }
}
