package maxdsc.quests.func;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/** Вычисляет и выводит на экран значения различных функции. */
public class Functions {

  private static final int MEASUREMENTS = 42;
  private static final double LOWER = -PI;
  private static final double TOP = PI;
  private static final String NAN_STR = "    -    ";

  /**
   * Выводит в консоль значения в виде таблицы. Где в первом стобце x, от которого вычисляют все
   * функции. Во втором столбце значения функции Верзьера Аньези с единичным диаметром. В третьем
   * столбце значения функции Лемниската Бернулли с единичным интервалом (c=1) в положительной
   * полуплоскости (y > 0). В четвертом столбце значения квадратичной гиперболы. Интервалы
   * вычисления функций от -PI до PI. Всего 42 измерения. Если в ходе вычисления получилось NaN, то
   * выводит в консоль прочерк.
   */
  public void printTablesToConsole() {
    double step = (abs(LOWER) + abs(TOP)) / (MEASUREMENTS - 1);
    double x = LOWER;
    for (int i = 0; i < MEASUREMENTS; i++) {

      double agnesi = calcVersieraAgnesi(x);
      double lemBern = calcLemniscateOfBernoulli(x);
      double quadHyp = calcQuadHyperbola(x);
      String agnesiStr = String.format("%.7f", agnesi);
      String lemBernStr = String.format("%.7f", lemBern);
      String quadHypStr = String.format("%.7f", quadHyp);

      if (Double.isNaN(agnesi)) {
        agnesiStr = NAN_STR;
      }

      if (Double.isNaN(lemBern)) {
        lemBernStr = NAN_STR;
      }

      if (Double.isNaN(quadHyp)) {
        quadHypStr = NAN_STR;
      }

      System.out.printf("%f|%s|%s|%s\n", x, agnesiStr, lemBernStr, quadHypStr);
      x = x + step;
    }
  }

  /**
   * Вычисляет значения функции Верзьера Аньези с единичным диаметром. Вычисляет по формуле: y = a^3
   * (a^2 + x^2), где a - диаметр (по условию задачи единичный).
   *
   * @param x - для какого x вычислить функцию.
   */
  private double calcVersieraAgnesi(double x) {
    double a = 1;
    double y = pow(a, 3) / (pow(a, 2) + pow(x, 2));
    return y;
  }

  /**
   * Вычисляет значения функции Лемниската Бернулли с единичным интервалом (c=1) в положительной
   * полуплоскости (y > 0) Вычисляет по формуле: y = sqrt( sqrt(c^4 + 4*x^2*c^2) - x^2 - c^2 ), где
   * с - интервал (по условию задачи единичный).
   *
   * @param x - для какого x вычислить функцию.
   */
  private double calcLemniscateOfBernoulli(double x) {
    double c = 1;
    double y = sqrt(sqrt(pow(c, 4) + 4 * pow(x, 2) * pow(c, 2)) - pow(x, 2) - pow(c, 2));
    return y;
  }

  /**
   * Вычисляет значения квадратичной гиперболы. Задается формулой: y = 1/(x^2).
   *
   * @param x - для какого x вычислить функцию.
   */
  private double calcQuadHyperbola(double x) {
    double y = 1 / pow(x, 2);
    return y;
  }
}
