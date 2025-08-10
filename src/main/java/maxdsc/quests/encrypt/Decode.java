package maxdsc.quests.encrypt;

/** Решает задачи кодирования/декодирования символов по таблице ASCII. */
public class Decode {

  private String text;

  /**
   * Конструктор класса.
   *
   * @param str - строка для кодирования/декодирования.
   */
  public Decode(String str) {
    this.text = str;
  }

  /** Кодирует текст в шестнадцатиричный формат ASCII. */
  public void encode() {
    if (checkSpaces(1)) {
      for (int i = 0; i < text.length(); i++) {
        int decSymbol = (int) text.charAt(i);
        if (decSymbol != ' ') {
          System.out.printf("%x ", decSymbol);
        }
      }
    } else {
      System.out.print("Error");
    }
  }

  /**
   * Декодирует текст из шестнадцатиричного формата ASCII в обычные буквы. Если в тексте есть
   * символы, которые не входят в шестнадцатиричную систему, то выдает ошибку.
   */
  public void decode() {
    if (checkSpaces(2)) {
      for (int i = 0; i < text.length(); i = i + 3) {
        char symbol1 = text.charAt(i);
        char symbol2 = text.charAt(i + 1);
        String twoSymbols = new StringBuilder().append(symbol1).append(symbol2).toString();
        try {
          Integer decSymbol = Integer.parseInt(twoSymbols, 16);
          System.out.printf("%c ", decSymbol.intValue());
        } catch (NumberFormatException e) {
          System.out.print("Error");
        }
      }
    } else {
      System.out.print("Error");
    }
  }

  /**
   * Проверяет все ли символы расположены через пробелы, для mode == 1, когда кодируем, mode == 2,
   * когда декодируем, так как при декодировании нужно разделение через пробел двух символов.
   */
  private boolean checkSpaces(int mode) {
    boolean result = true;
    int countSym = 0;
    int countSpace = 0;

    for (int i = 0; i < text.length(); i++) {
      char symbol = text.charAt(i);
      if (symbol != ' ') {
        countSym++;
      } else {
        countSpace++;
      }
    }

    if (countSpace * mode + (mode - 1) != countSym - 1) {
      result = false;
    }
    return result;
  }
}
