package CVUT.passwordCracker;

public class BruteForceAttacker extends Thief {

    @Override
    public void breakPassword(int sizeOfPassword) {
      char [] password = new char[sizeOfPassword];
      char [] safeCharacters = getCharacters();
      int numOfCharacters = safeCharacters.length - 1;
      int passwordIndex = password.length - 1;
      
      fillPassword(password, safeCharacters);
      getCombination(safeCharacters, password, passwordIndex);
    }

    public void fillPassword(char [] password, char [] safeCharacters)
    {
      int index = 0;
      while (index < password.length)
      {
        password[index] = safeCharacters[0];
        index++;
      }
    }
    public boolean getCombination(char [] safeCharacters, char [] password, int passwordIndex)
    {
      if (tryOpen(password))
          return true;
      for (int i = 0; i < safeCharacters.length; i++)
      {
        password[passwordIndex] = safeCharacters[i];
        if (passwordIndex == 0) {
            if (tryOpen(password))
              return true;
        } else {
            if (getCombination(safeCharacters, password, passwordIndex - 1))
              return true;
        }
      }
      return false;
    }

}
