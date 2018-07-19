
// holds the cell values of the board
public class CellValue
{
    public enum cellValue  // 3 cell values X, O and EMPTY that a board can have
    {
        X {
            @Override
            public String toString()
            {
              return "X"; // string form of the constant
            }
        },
        O {
            @Override
            public String toString()
            {
                return "O"; // string form of the constant
            }
        },
        EMPTY{
            @Override
            public String toString()
            {
                return " "; // string form of the constant
            }
        }
    }

}
