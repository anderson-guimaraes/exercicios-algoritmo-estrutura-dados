package L09;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

  @Override
  public void inserir(T dado) {

    if (getLimite() == getTamanho()) {
      redimensionar();
    }

    // procura a posicao pra adicionar.
    int posicao = procurarPosicaoInclusao(dado);

    if (posicao < getTamanho()) {
      deslocarDados(posicao);
    }

    // armazenda dado na posicao localizada.
    Object[] info = getInfo();
    info[posicao] = dado;

  }

  @Override
  public int buscar(T dado) {
    Object[] info = getInfo();

    int inicio = 0;
    int fim = getTamanho() - 1;
    int meio;

    while (inicio <= fim) {
      meio = (inicio + fim) / 2;

      int comparacao = dado.compareTo((T) info[meio]);
      if (comparacao < 0) {
        fim = meio - 1;
      } else {
        if (comparacao > 0) {
          inicio = meio + 1;
        } else {
          return meio;
        }
      }
    }

    return -1;
  }

  private int procurarPosicaoInclusao(T itemAdicionar) {
    Object[] info = getInfo();
    int i; // posicao onde deve ser adicionado o dado

    for (i = 0; i < getTamanho(); i++) {
      if (((Comparable) info[i]).compareTo(itemAdicionar) > 0) {
        break;
      }
    }

    return i;
  }

  private void deslocarDados(int posicao) {
    Object[] info = getInfo();
    for (int i = getTamanho() - 1; i >= posicao; i--) {
      info[i + 1] = info[i];
    }
  }

}
