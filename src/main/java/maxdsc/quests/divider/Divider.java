package maxdsc.quests.divider;

/** Производит операции с делителем. */
public class Divider {

  /** Число, от которого берется делитель. */
  private int num;

  /**
   * Конструктор с переданным числом, которого нужно взять делитель, если число отрицательное, то
   * минус отбрасывается.
   */
  public Divider(int a) {
    if (a < 0) {
      a = -1 * a;
    }
    this.num = a;
  }

  /** Выводит результат - наибольший простой делитель. */
  public void getLargestAndPrime() {
    if (checkLimits()) {
      int result = checkDivisor();
      System.out.print(result);
    }
  }

  /**
   * Находит наибольший делитель от числа.
   *
   * @param num - число, от которого нужно найти наибольший делитель.
   */
  private int findLargestDivisor(int num) {
    int middle = num / 2;
    int div = 0;
    for (int i = 2; i < middle + 1; i++) {
      int sum = 0;
      while (sum <= num) {
        sum = sum + i;
        if (sum == num) {
          div = i;
        }
      }
    }
    return div;
  }

  /** Проверяет является ли делитель простым, если нет то находит следующий меньший. */
  private int checkDivisor() {
    int largeDiv = findLargestDivisor(this.num);
    int largeAndPrimeDiv = -1;
    if (largeDiv == 0) {
      largeAndPrimeDiv = this.num;
    } else {
      while (largeDiv != 0) {
        largeAndPrimeDiv = largeDiv;
        largeDiv = findLargestDivisor(largeDiv);
      }
    }
    return largeAndPrimeDiv;
  }

  /** Проверяет граничные условия. */
  private boolean checkLimits() {
    boolean result = true;
    if (this.num == 0) {
      System.out.print("Error");
      result = false;
    } else if (this.num == 1) {
      System.out.print(this.num);
      result = false;
    }
    return result;
  }
}
