package maxdsc.quests.fibonacci;

/** Решает задачу вычисления числа Фибоначчи для номера n. */
public class Fibonacci {

  private int num;

  /**
   * Конструктор класса.
   *
   * @param n - номер, для которого нужно нужно вычислить число Фибоначчи.
   */
  public Fibonacci(int n) {
    this.num = n;
  }

  /** Выводит результат вычислений числа Фибонначи в консоль. */
  public void printResultToConsole() {
    int res = calcFib(num);
    if (res > 0) {
      System.out.print(res);
    } else {
      System.out.print("Error");
    }
  }

  /**
   * Рекурсивно вычисляет число Фибонначи.
   *
   * @param n - член последовательности, нужен для организации рекурсии вычислений.
   */
  private int calcFib(int n) {
    int result = 0;
    if (n == 1) {
      result = 1;
    } else if (n == 2) {
      result = result + 1;
    } else if (n > 2) {
      result = calcFib(n - 1) + calcFib(n - 2);
    } else {
      result = -1;
    }
    return result;
  }
}
