package L09;

public abstract class ListaAbstract<T> {
  private T[] info;
  private int tamanho;
  private final byte TAMANHO_INICIAL = 10;

  public ListaAbstract() {
    info = (T[]) new Object[TAMANHO_INICIAL];
    tamanho = 0;
  }

  public int getTamanho() {
    return tamanho;
  }

  protected void setTamanho(int tamanho) {
    this.tamanho = tamanho;
  }

  protected void redimensionar() {
    T[] novo = (T[]) new Object[tamanho + 10];
    for (int i = 0; i < tamanho; i++) {
      novo[i] = info[i];
    }
    info = novo;
  }

  public int getLimite() {
    return info.length;
  }

  public abstract void inserir(T dado);

  public void exibir() {
    for (int i = 0; i < tamanho; i++) {
      System.out.println(info[i]);
    }
  }

  public abstract int buscar(T dado);

  public void retirar(T dado) {
    int posicao = buscar(dado);
    if (posicao > -1) {
      for (int i = posicao; i < tamanho - 1; i++) {
        info[i] = info[i + 1];
      }

      info[tamanho - 1] = null;
      tamanho--;
    }
  }

  public void liberar() {
    info = (T[]) new Object[TAMANHO_INICIAL];
    tamanho = 0;
  }

  public T obterElemento(int pos) {
    if (pos >= 0 && (pos < tamanho)) {
      retirar(info[pos]);
      return this.info[pos];
    } else {
      throw new IndexOutOfBoundsException("Posicao inválida");
    }
  }

  @Override
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

  protected T[] getInfo() {
    return info;
  }

}
