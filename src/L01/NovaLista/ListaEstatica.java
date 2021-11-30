package L01.NovaLista;

public class ListaEstatica {
  private Object[] info;
  private int tamanho;

  public ListaEstatica() {
    info = new Object[10];
    tamanho = 0;
  }

  public void inserir(Object valor) {
    if (tamanho == info.length) {
      redimensionar();
    }

    info[tamanho] = valor;
    tamanho++;
  }

  private void redimensionar() {
    
    Object[] novo = new Object[info.length + 10];

    for (int i = 0; i < info.length; i++) {
      novo[i] = info[i];
    }
    info = novo;
  }

  public void exibir() {
    for (int i = 0; i < tamanho; i++) {
      System.out.println(info[i]);
    }
  }

  public int buscar(Object valor) {
    for (int i = 0; i < tamanho; i++) {
      if (info[i] == valor) {
        return i;
      }
    }
    return -1;
  }

  public void retirar(Object valor) {
    int posicao = buscar(valor);

    if (posicao > -1) {
      for (int i = posicao; i < tamanho - 1; i++) {
        info[i] = info[i + 1];
      }
      tamanho--;
    }
  }

  public void liberar() {
    info = new Object[10];
    tamanho = 0;
  }

  public Object obterElemento(int posicao) {
    if (posicao >= 0 && (posicao < tamanho)) {
      return info[posicao];
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public boolean estaVazia() {
    return tamanho == 0;
  }

  public int getTamanho() {
    return tamanho;
  }

  public String toString() {
    String resultado = "";

    for (int i = 0; i < tamanho; i++) {
      if (i > 0) {
        resultado += ",";
      }
      resultado += info[i];
    }

    return resultado;
  }

}
